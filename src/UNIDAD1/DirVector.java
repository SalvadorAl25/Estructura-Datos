package UNIDAD1;

import java.util.Random;
import EDI.*;

public class DirVector
{
	private int vec[], ind, di;
	
	public DirVector()
	{
		Datos obd=new Datos();
		do
			ind=obd.Entero("Cual es el tamano del vector?");
		while(ind<1);
		vec=new int[ind];
		do
			di=obd.Entero("Direccion inicial?");
		while(di<1);
	}
	
	public void Aleatorio()
	{
		Random obr=new Random();
		for (ind = 0; ind < vec.length; ind++)
			vec[ind]=obr.nextInt(100);
	}
	
	public void Mostar()
	{
		System.out.println("Elementos y direcciones...");
		for (ind = 0; ind < vec.length; ind++)
			System.out.println(vec[ind]+"\t"+(di+ind*4)+"-"+(di+ind*4+3));
	}
	
	public void Pares()
	{
		for (ind = 0; ind < vec.length; ind++)
			if(vec[ind]%2==0)
				System.out.println((vec[ind]+"\t"+(di+ind*4)+"-"+(di+ind*4+3)));
			else
				System.out.println(vec[ind]);
	}
}
