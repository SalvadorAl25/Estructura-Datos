package UNIDAD4;

import java.util.TreeSet;

import EDI.Menu;

public class ArbolTreeSet
{
	public static void main(String[] args)
	{
		int op, num;
		Object arr[];
		Menu obm;
		obm = new Menu("Arbol binario TreeSet...", new String[] { "Insertar",
				"Eliminar", "Recorrido", "Buscar", "Modificar"});
		TreeSet<Integer> arbol = new TreeSet<Integer>();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (arbol.add(obm.obd.Entero("Numero a insertar...")))
						System.out.println("Insertado...");
					else
						System.out.println("Repetido...");
					break;
				case 2:
					if (!arbol.isEmpty())
					{
						num = obm.obd.Entero("Numero a eliminar...");
						if (arbol.remove(num))
							System.out.println("Eliminado...");
						else
							System.out.println("No Existe...");
					}
					else
						System.out.println("Arbol Vacio...");
					break;
				case 3:
					if (!arbol.isEmpty())
					{
						System.out.println("Numeros del arbol...");
						arr = new Object[arbol.size()];
						arr = arbol.toArray();
						for (num = 0; num < arr.length; num++)
							System.out.println(arr[num]);
						// for (Integer n : arbol)
						// System.out.println(n);
					}
					else
						System.out.println("Arbol Vacio...");
					break;
				case 4:
					if (!arbol.isEmpty())
					{
						num = obm.obd.Entero("Numero a buscar");
						if (arbol.contains(num))
							System.out.println("si existe...");
						else
							System.out.println("No existe...");
					}
					else
						System.out.println("Arbol Vacio...");
					break;
				case 5:
					if (!arbol.isEmpty())
					{
						num = obm.obd.Entero("Numero a Modificar...");
						if (arbol.contains(num))
						{
							arbol.remove(num);
							num = obm.obd.Entero("Nuevo Numero...");
							if (arbol.add(num))
								System.out.println("Modificado...");
							else
								System.out.println("Repetido...");
						}
						else
							System.out.println("No existe...");
					}
					else
						System.out.println("Arbol Vacio...");
					break;
				case 6:
					

			}
		while (op != obm.Salir());
	}
}
