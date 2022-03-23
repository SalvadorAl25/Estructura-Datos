package Unidad3;

import EDI.Datos;

public class Conersion
{
	public int Entero()
	{
		int num;
		Datos obd=new Datos();
		num=obd.Entero("Decimal");
		if(num<0)
			num=this.Entero();
		return num;
	}
	
	public String Transformar(int num, int base)
	{
		String cad="0123456789ABCDEF";
		if(num<base)
			return ""+cad.charAt(num);
		else
			return this.Transformar(num/base, base)+cad.charAt(num%base);
	}
	
	public void Presentar(String res)
	{
		System.out.println(res);
	}
}
