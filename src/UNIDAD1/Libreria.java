package UNIDAD1;

import EDI.*;

public class Libreria
{
	private Libros obl;
	private Datos obd = new Datos();

	public Libreria(int isbn)
	{
		obl = new Libros();
		System.out.println("Datos del libro...");
		obl.setIsbn(isbn);
		System.out.println("ISBN: "+obl.getIsbn());
		obl.setTit(obd.Cadena("Titulo: "));
		obl.setAutor(obd.Cadena("Autor: "));
		obl.setEdi(obd.Cadena("Editorial: "));
		obl.setPre(obd.Doble("Precio: "));
	}

	public void Mostrar()
	{
		System.out.println("\nDatos del Libro...");
		System.out.println("ISBN: " + obl.getIsbn());
		System.out.println("Titulo: " + obl.getTit());
		System.out.println("Autor: " + obl.getAutor());
		System.out.println("Editorial: " + obl.getEdi());
		System.out.println("Precio: " + obl.getPre()+"$");
	}

	public boolean Existe(int isbn)
	{
		if(obl.getIsbn()==isbn)  //return obl.getIsbn()==isbn;
			return true;
		else
			return false;
	}

	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Modificaciones ", new String[] {"Titulo",
				"Autor", "Editorial", "Precio" });

		do
			switch (op = obm.Opcion())
			{
				case 1:
					obl.setTit(obd.Cadena("Titulo: "));
					break;
				case 2:
					obl.setAutor(obd.Cadena("Autor: "));
					break;
				case 3:
					obl.setEdi(obd.Cadena("Editorial: "));
					break;
				case 4:
					obl.setPre(obd.Doble("Precio: "));
			}
		while (op != obm.Salir());
	}
	
	public int Isbn()
	{
		return obl.getIsbn();
	}
}