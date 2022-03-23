package UNIDAD1;

import java.util.Vector;

import EDI.Menu;

public class LibrosP
{
	public static void main(String[] args)
	{
		int op, pos, isbn = 0;
		Menu obm = new Menu("Libreria ITJ", new String[] { "Nuevo", "Consulta",
				"Buscar", "Modificar", "Borrar" });
		Vector<Libreria> lista = new Vector<Libreria>(5, 2);

		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (!lista.isEmpty())
					{
						for (pos = 0; pos < lista.size(); pos++)
							isbn = lista.get(pos - 1).Isbn() + 1;
					}
					else
						isbn = 1;
					lista.add(new Libreria(isbn));
					break;
				case 2:
					if (!lista.isEmpty())
					{
						System.out.println("Lista de libros...");
						for (pos = 0; pos < lista.size(); pos++)
							lista.get(pos).Mostrar();
					}
					else
						System.out.println("No hay libros...");
					break;
				case 3:
					if (!lista.isEmpty())
					{
						isbn=obm.obd.Entero("ISBN a buscar...");
						for (pos = 0; pos < lista.size(); pos++)
							if (lista.get(pos).Existe(isbn))
							{
								System.out.println("Libros encontados");
								lista.get(pos).Mostrar();
								break;
							}
						if (pos == lista.size())
							System.out.println("No existe...");
					}
					else
						System.out.println("No hay libros...");
					break;
				case 4:
					if (!lista.isEmpty())
					{
						isbn=obm.obd.Entero("ISBN a Modificar...");
						for (pos = 0; pos < lista.size(); pos++)
							if (lista.get(pos).Existe(isbn))
							{
								System.out.println("Libros encontados");
								lista.get(pos).Mostrar();
								lista.get(pos).Modificar();
								System.out.println("Datos Modificados....");
								lista.get(pos).Mostrar();
								break;
							}
						if (pos == lista.size())
							System.out.println("No existe...");
					}
					else
						System.out.println("No hay libros...");
					break;
				case 5:
					if (!lista.isEmpty())
					{
						isbn=obm.obd.Entero("ISBN a Borrar...");
						for (pos = 0; pos < lista.size(); pos++)
							if (lista.get(pos).Existe(isbn))
							{
								System.out.println("Libros encontados...");
								lista.get(pos).Mostrar();
								lista.remove(pos);
								System.out.println("Libro Borrado...");
								pos--;
								break;
							}
						if (pos == lista.size())
							System.out.println("No existe...");
					}
					else
						System.out.println("No hay libros...");
			}
		while (op != obm.Salir());
	}
}
