package Unidad3;

import EDI.Datos;

public class ColaPromedios
{
	private int ind, pos;
	private String cola[], pro;
	private boolean ban;
	private Datos obd=new Datos();
	
	public ColaPromedios()
	{
		do
			ind=obd.Entero("Cantidad de promedios de la cola");
		while(ind<1);
		cola=new String[ind];
		ind=-1;
	}
	
	private boolean Vacia()
	{
		return ind==-1;
	}
	
	public boolean Llena()
	{
		return ind==cola.length-1;
	}
	
	public String Promedio()
	{
		String uno="N789", dos="A0123456789";
		do
		{
			ban=false;
			pro=obd.Cadena("Promedio").toUpperCase();
			if(pro.length()<2 || pro.length()>3)
				ban=true;
			else
				if(pro.length()==2)
				{
					if(uno.indexOf(pro.charAt(0))==-1)
						ban=true;
					if(dos.indexOf(pro.charAt(1))==-1)
						ban=true;
				}
				else
					if(!pro.equals("100"))
						ban=true;
		}
		while(ban);
		return pro;
	}
	
	public void Insertar()
	{
		if(!this.Llena())
			cola[++ind]=this.Promedio();
		else
			System.out.println("Cola llena...");
	}
	
	public void Extraer()
	{
		if(!this.Vacia())
		{
			System.out.println("Promedio extraido "+cola[0]);
			for(pos=0; pos<ind; pos++)
				cola[pos]=cola[pos+1];
			ind--;
		}
		else
			System.out.println("Cola vacia...");
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			System.out.println("Promedios de la cola...");
			for(pos=0; pos<=ind; pos++)
				System.out.println((pos+1)+"\t"+cola[pos]);
		}
		else
			System.out.println("Cola Vacia...");
	}
	
	public void Buscar()
	{
		ban=true;
		if(!this.Vacia())
		{
			pro=obd.Cadena("Promedio a buscar...").toUpperCase();
			for(pos=0; pos<=ind; pos++)
				if(cola[pos].equals(pro))
				{
					System.out.println((pos+1)+"\t"+cola[pos]);
					ban=false;
				}
			if(ban)
				System.out.println("No existe...");
		}
		else
			System.out.println("Cola vacia...");
	}
	
	public void Modificar()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("Posicion");
			while(pos<1 || pos>ind+1);
			pos--;
			cola[pos]=this.Promedio();
		}
		else
			System.out.println("Cola vacia...");
	}
	
	
}