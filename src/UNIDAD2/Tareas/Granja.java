package UNIDAD2.Tareas;

import EDI.Datos;

public class Granja
{
	Datos obd=new Datos();
	
	public int Meses()
	{
		return obd.Entero("Meses");
	}
	
	public int Conejos(int mes)
	{
		int conj=0;
		if(mes==0 || mes==1)
			conj=mes;
		else
			return conj=this.Conejos(mes-2)+this.Conejos(mes-1);
		return conj;
	}
	
	public void Mostrar(int res)
	{
		System.out.println("Parejas Totales "+res);
	}
}
