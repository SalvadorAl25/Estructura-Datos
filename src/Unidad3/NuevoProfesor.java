package Unidad3;

import EDI.*;

public class NuevoProfesor
{
	private Profesor obp;
	
	public NuevoProfesor(int nt)
	{
		Datos obd=new Datos();
		obp=new Profesor();
		obp.setNt(nt);
		System.out.println("Targeta: "+nt);
		obp.setNom(obd.Cadena("Nombre"));
		obp.setSue(obd.Doble("Sueldo"));
	}
	
	public void Mostrar()
	{
		System.out.println(obp.getNt()+"\t"+obp.getNom()+"\t"+obp.getSue());
	}
	
	public boolean Existe(int nt)
	{
		return obp.getNt()==nt;
	}
	
	public int NoTargeta()
	{
		return obp.getNt();
	}
	
	public void Modificar()
	{
		int op;
		Menu obm=new Menu("Modificaciones...", new String[]{"Nombre", "Sueldo"});
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obp.setNom(obm.obd.Cadena("Nombre"));
					break;
				case 2:
					obp.setSue(obm.obd.Doble("Sueldo"));
			}
		while(op!=obm.Salir());
	}
}
