package UNIDAD1;

import EDI.*;
import java.util.Random;

public class DirVecLetras
{
	private char vec[];
	private int ind, di;
	
	public DirVecLetras()
	{
		Datos obd=new Datos();
		do
			ind=obd.Entero("Cual es el tamano del vector...");
		while(ind<1);
		vec=new char[ind];
		do
			di=obd.Entero("Direccion inicial?");
		while(di<1);
	}
	
	public void Aleatorios()
	{
		String cad="ABCDEFHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random obr=new Random();
		for (ind = 0; ind < vec.length; ind++)
			vec[ind]=cad.charAt(obr.nextInt(cad.length()));
	}
	
	public void Mostrar()
	{
		String voc="AEIOUaeiou";
		System.out.println("Letras y Direcciones de la vocales...");
		for (ind = 0; ind < vec.length; ind++)
			if(voc.indexOf(vec[ind])!=-1)
				System.out.println(vec[ind]+"\t"+(di+ind*2)+"-"+(di+ind*2+1));
			else
				System.out.println(vec[ind]);
	}
}