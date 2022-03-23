package Unidad3;

import java.util.*;
import EDI.*;

public class PilaStack
{
	public static void main(String[] args)
	{
		int op, num, numb, pos;
		Menu obm = new Menu("Pila con Stack", new String[] { "Insertar",
				"Extraer", "Recorrido", "Buscar", "Modificar" });
		Stack<Integer> pila = new Stack<Integer>();
		Stack<Integer> aux = new Stack<Integer>();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					pila.push(obm.obd.Entero("Numero a insertar"));
					break;
				case 2:
					if (!pila.isEmpty())
					{
						System.out.println("Numero Extraido" + pila.pop());
					}
					else
						System.out.println("Pila Vacia");
					break;
				case 3:
					if (!pila.empty())
					{
						System.out.println("Elementos de la pila...");
						while (!pila.empty())
						{
							num = pila.pop();
							System.out.println(num);
							aux.push(num);
						}
						while (!aux.empty())
							pila.push(aux.pop());
					}
					else
						System.out.println("pila vacia...");
					break;
				case 4:
					if (!pila.empty())
					{
						num = obm.obd.Entero("Numero a buscar");
						pos = pila.search(num);
						if (pos != -1)
							System.out.println(
									"Encontrado en la posicion " + pos);
						else
							System.out.println("El Numero no existe...");
					}
					else
						System.out.println("Pila Vacia...");
					break;
				case 5:
					if (!pila.empty())
					{
						numb = obm.obd.Entero("Numero a modificar...");
						if (pila.search(numb) != -1)
						{
							while (!pila.empty())
							{
								num = pila.pop();
								if(num==numb)
									num=obm.obd.Entero("Numero de remplazo");
								System.out.println(num);
								aux.push(num);
							}
							while (!aux.empty())
								pila.push(aux.pop());
						}
						else
							System.out.println("el numero no existe...");
					}
					else
						System.out.println("pila vacia...");

			}
		while (op != obm.Salir());
	}
}
