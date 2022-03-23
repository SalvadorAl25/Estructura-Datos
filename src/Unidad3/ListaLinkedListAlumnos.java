package Unidad3;

import java.util.LinkedList;

import EDI.Menu;

public class ListaLinkedListAlumnos
{
	public static void main(String[] args)
	{
		int op, o, pos, ind;
		String nc;
		boolean ban;
		Menu obm, ob;
		obm = new Menu("Lista de Alumnos con LinkedList...", new String[] {
				"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar" });
		LinkedList<Alumnos> lista = new LinkedList<Alumnos>();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					ob = new Menu("Menu de Insertar",
							new String[] { "Inicio", "Posicion", "Final" });
					do
						switch (o = ob.Opcion())
						{
							case 1:
								do
								{
									nc = obm.obd.Cadena("No. Control");
									for (pos = 0; pos < lista.size(); pos++)
										if (lista.get(pos).Existe(nc))
											break;
								}
								while (pos < lista.size());
								lista.addFirst(new Alumnos(nc));
								break;
							case 2:
								if (!lista.isEmpty())
								{
									do
										pos = obm.obd.Entero("Posicion");
									while (pos < 1 || pos > lista.size());
									pos--;
									do
									{
										nc = obm.obd.Cadena("No. Control");
										for (ind = 0; ind < lista.size(); ind++)
											if (lista.get(ind).Existe(nc))
												break;
									}
									while (pos < lista.size());
									lista.add(pos, new Alumnos(nc));
								}
								else
									System.out.println("Lista Vacia... ");
								break;
							case 3:
								do
								{
									nc = obm.obd.Cadena("No. Control");
									for (pos = 0; pos < lista.size(); pos++)
										if (lista.get(pos).Existe(nc))
											break;
								}
								while (pos < lista.size());
								lista.addLast(new Alumnos(nc));
						}
					while (o != ob.Salir());
					break;
				case 2:
					ob = new Menu("Menu de Extraer",
							new String[] { "Inicio", "Posicion", "Final" });
					do
						switch (o = ob.Opcion())
						{
							case 1:
								if (!lista.isEmpty())
								{
									System.out.println("Alumno Eliminado ");
									lista.removeFirst().Mostrar();
								}
								else
									System.out.println("Lista Vacia...");
								break;
							case 2:
								if (!lista.isEmpty())
								{
									do
										pos = obm.obd.Entero("Posicion");
									while (pos < 1 || pos > lista.size());
									pos--;
									System.out.println("Nombre Eliminado ");
									lista.remove(pos).Mostrar();
								}
								else
									System.out.println("Lista Vacia...");
								break;
							case 3:
								if (!lista.isEmpty())
								{
									System.out.println("Nombre Eliminado ");
									lista.removeLast().Mostrar();
									;
								}
								else
									System.out.println("Lista Vacia...");
						}
					while (o != ob.Salir());
					break;
				case 3:
					if (!lista.isEmpty())
					{
						System.out.println("Nombres de la lista...");
						for (Alumnos alu : lista)
							alu.Mostrar();
						/*
						 * for (pos = 0; pos < lista.size(); pos++) System.out
						 * .println(lista.Mostrar();
						 */
					}
					else
						System.out.println("Lista Vacia...");
					break;
				case 4:
					ban = true;
					if (!lista.isEmpty())
					{
						nc = obm.obd.Cadena("No. Ctrl a Buscar").toUpperCase();
						for (pos = 0; pos < lista.size(); pos++)
							if (lista.get(pos).Existe(nc))
							{
								lista.get(pos).Mostrar();
								ban = false;
							}
						if (ban)
							System.out.println("No Existe");
					}
					else
						System.out.println("Lista Vacia...");
					break;
				case 5:
					if (!lista.isEmpty())
					{
						ban=true;
						nc = obm.obd.Cadena("No. Ctrl a Modificar").toUpperCase();
						for (pos = 0; pos < lista.size(); pos++)
							if (lista.get(pos).Existe(nc))
							{
								lista.get(pos).Mostrar();
								lista.get(pos).Modificar();
								lista.get(pos).Mostrar();
								ban = false;
							}
						if (ban)
							System.out.println("No Existe");
					}
					else
						System.out.println("Lista Vacia...");
			}
		while (op != obm.Salir());
	}
}
