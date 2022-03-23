package UNIDAD2;

import EDI.Datos;
import java.util.*;


public class Vector
{
	private int vec[], ind, pos=0;
	private Datos obd=new Datos();
	private Random obr=new Random();
	
	public void Tamano()
	{
		ind=obd.Entero("Tamano del vector");
		if(ind<1)
			this.Tamano();
		vec=new int [ind];
		ind--;
	}
	
	public void Aleatorios()
	{
		if(ind>0)
		{
			ind--;
			this.Aleatorios();
		}
		vec[pos++]=obr.nextInt(100);
	}
	
	public void Mostrar()
	{
		if(ind<vec.length)
		{
			System.out.println(vec[ind]);
			ind++;
			this.Mostrar();
		}
	}
}
