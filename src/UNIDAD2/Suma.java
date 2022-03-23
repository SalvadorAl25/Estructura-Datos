
package UNIDAD2;

import EDI.*;

public class Suma
{
	public int Rango()
	{
		int num;
		Datos obd=new Datos();
		do
			num=obd.Entero("Dame el valor final");
		while(num<1);
		return num;
	}
	
	public int Recursivo(int num)
	{
		if(num==1)
			return num;
		else
			return num+this.Recursivo(num-1);
	}
	
	public void Mostrar(int suma)
	{
		System.out.println("La Suma es "+suma);
	}
}
