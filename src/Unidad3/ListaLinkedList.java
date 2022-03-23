package Unidad3;

import java.util.LinkedList;

import EDI.Menu;

public class ListaLinkedList
{
	public static void main(String[] args)
	{
		int op, o, pos;
		String nom;
		Menu obm, ob;
		obm = new Menu("Lista con LinkedList...", new String[] { "Insertar",
				"Extraer", "Recorrido", "Buscar", "Modificar" });
		LinkedList<String> lista = new LinkedList<String>();

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
								lista.addFirst(
										obm.obd.Cadena("Nombre").toUpperCase());
								break;
							case 2:
								if (!lista.isEmpty())
								{
									do
										pos = obm.obd.Entero("Posicion");
									while (pos < 1 || pos > lista.size());
									pos--;
									lista.add(pos, obm.obd.Cadena("Nombre")
											.toUpperCase());
								}
								else
									System.out.println("Lista Vacia... ");
								break;
							case 3:
								lista.addLast(
										obm.obd.Cadena("Nombre").toUpperCase());
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
									System.out.println("Nombre Eliminado "
											+ lista.removeFirst());
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
									System.out.println("Nombre Eliminado "
											+ lista.remove(pos));
								}
								else
									System.out.println("Lista Vacia...");
								break;
							case 3:
								if (!lista.isEmpty())
									System.out.println("Nombre Eliminado "
											+ lista.removeLast());
								else
									System.out.println("Lista Vacia...");
						}
					while (o != ob.Salir());
					break;
				case 3:
					if (!lista.isEmpty())
					{
						System.out.println("Nombres de la lista...");
						/*
						 * for (String cad : lista) System.out.println(cad);
						 */
						for (pos = 0; pos < lista.size(); pos++)
							System.out
									.println((pos + 1) + ".-" + lista.get(pos));
					}
					else
						System.out.println("Lista Vacia...");
					break;
				case 4:
					boolean ban = true;
					if (!lista.isEmpty())
					{
						nom = obm.obd.Cadena("Nombre a Buscar").toUpperCase();
						for (pos = 0; pos < lista.size(); pos++)
							if (lista.get(pos).indexOf(nom) != -1)
							{
								System.out.println(
										(pos + 1) + ".-" + lista.get(pos));
								ban = false;
							}
						if(ban)
							System.out.println("No Existe");
					}
					else
						System.out.println("Lista Vacia...");
					break;
				case 5:
					if(!lista.isEmpty())
					{
						do
							pos=obm.obd.Entero("Posicion a modificar");
						while(pos<1 || pos>lista.size());
						pos--;
						lista.set(pos, obm.obd.Cadena("Nuevo Nombre").toUpperCase());
					}
					else
						System.out.println("Lista Vacia...");
			}
		while (op != obm.Salir());
	}
}
