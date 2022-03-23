package UNIDAD1;

import EDI.*;

public class ALUMNOS
{
	private Alumno oba;
	private Datos obd=new Datos();
	
	public ALUMNOS(String nc)
	{
		oba=new Alumno();
		System.out.println("Dame los datos del alumno...");
		oba.setNc(nc);
		oba.setNom(obd.Cadena("Nombre"));
		oba.setCar(obd.Cadena("Carrera"));
		oba.setPro(obd.Entero("Promedio"));
		oba.setSem(obd.Entero("Semestre"));
	}
	
	public void Mostrar()
	{
		System.out.println("\nDatos del alumno...");
		System.out.println("No. Ctrl. "+oba.getNc());
		System.out.println("Nombre "+oba.getNom());
		System.out.println("Carrera "+oba.getCar());
		System.out.println("promedio "+oba.getPro());
		System.out.println("Semestre "+oba.getSem());
	}
	
	public boolean Existe(String nc)
	{
		return oba.getNc().equalsIgnoreCase(nc);
	}
	
	public void Modificar()
	{
		int op;
		Menu obm=new Menu("Modificaciones", new String[]{"No. Ctrl", "Nombre, Carrera", "Promedio", "Semestre"});
		
		do
			switch(op=obm.Opcion())
			{
			case 1:
				oba.setNc(obd.Cadena("No. Ctrl."));
				break;
			case 2:
				oba.setNom(obd.Cadena("Nombre"));
				break;
			case 3:
				oba.setPro(obd.Entero("Promedio"));
				break;
			case 4:
				oba.setCar(obd.Cadena("Carrera"));
				break;
			case 5:
				oba.setSem(obd.Entero("Semestre"));
			}
		while(op!=obm.Salir());
	}
}
