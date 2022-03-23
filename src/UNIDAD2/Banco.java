package UNIDAD2;

import EDI.*;

public class Banco
{
	private Datos obd=new Datos();
	
	public double Deposito()
	{
		double dep;
		do
			dep=obd.Doble("Cantidad depositada");
		while(dep<1);
		return dep;
	}
	
	public double Porcentaje()
	{
		int por;
		do
			por=obd.Entero("porcentaje a ganar");
		while(por<0 || por>100);
		return por/100.0+1;
	}
	
	public int Tiempo()
	{
		int mes;
		do
			mes=obd.Entero("Cantidad de meses");
		while(mes<0);
		return mes;
	}
	
	public double Calcular(double dep, double por, int mes)
	{
		if(mes==0)
			return dep;
		return por*Calcular(dep, por, mes-1);
	}
	
	public void Mostrar(double sal)
	{
		System.out.println("Saldo de la cuenta "+sal);
	}
}