package UNIDAD1;

import EDI.*;

public class LibreriaP
{
	public static void main(String[] args)
	{
		int isbn = 0, op, x = -1, con;
		Libreria libr[] = new Libreria[6];
		Menu obm = new Menu("Libreria Gandhi...", new String[] { "Nuevo",
				"Consulta", "Modificar", "Buscar", "Borrar" });

		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (x < libr.length - 1)
					{
						do
						{
							isbn++;
							for(con=0; con<=x; con++)
								if(libr[con].Existe(isbn))
									break;
							if(con<=x)
								System.out.println("Ya Existe...");
						}
						while(con<=x);
						libr[++x]=new Libreria(isbn);
					}
					else
						System.out.println("No hay espacio...");
					break;
				case 2:
					if(x!=-1)
						for(con=0; con<=x; con++)
							libr[con].Mostrar();
					else
						System.out.println("No Hay Datos...");
					break;
				case 3:
					if(x!=-1)
					{
						isbn=obm.obd.Entero("ISBN a Modificar...");
						for(con=0; con<=x; con++)
							if(libr[con].Existe(isbn))
							{
								libr[con].Mostrar();
								libr[con].Modificar();
								break;
							}
						if(con>x)
							System.out.println("No Existe...");
					}
					else
						System.out.println("No Hay Datos...");
					break;
				case 4:
					if(x!=-1)
					{
						isbn=obm.obd.Entero("ISBN a Buscar...");
						for(con=0; con<=x; con++)
							if(libr[con].Existe(isbn))
							{
								libr[con].Mostrar();
								break;
							}
						if(con>x)
							System.out.println("No Existe...");
					}
					else
						System.out.println("No Hay Datos...");
					break;
				case 5:
					if(x!=-1)
					{
						isbn=obm.obd.Entero("ISBN a Borrar...");
						for(con=0; con<=x; con++)
							if(libr[con].Existe(isbn))
							{
								libr[con].Mostrar();
								for(;con<x; con++)
									libr[con]=libr[con+1];
								x--;
								con--;
								break;
							}
						if(con>x)
							System.out.println("No Existe...");
					}
					else
						System.out.println("No Hay Datos...");
			}
		while (op != obm.Salir());
	}
}
