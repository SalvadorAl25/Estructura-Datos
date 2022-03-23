package Unidad3;

import EDI.Menu;
import java.util.*;

public class PilaStackAlumnos
{
	public static void main(String[] args)
	{
		int op;
		String nc;
		Alumnos oba;
		boolean ban;
		Menu obm = new Menu("Pila de Alumnos con Stack", new String[] {
				"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar" });
		Stack<Alumnos> pila = new Stack<Alumnos>();
		Stack<Alumnos> aux = new Stack<Alumnos>();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					do
					{
						nc = obm.obd.Cadena("No Ctrl.");
						ban = false;
						if (!pila.empty())
						{
							while (!pila.isEmpty())
							{
								oba = pila.pop();
								if (oba.Existe(nc))
									ban = true;
								aux.push(oba);
							}
							while (!aux.empty())
								pila.push(aux.pop());
						}
					}
					while (ban);
					pila.push(new Alumnos(nc));
					break;
				case 2:
					if (!pila.empty())
						pila.pop().Mostrar();
					else
						System.out.println("Pila Vacia...");
					break;
				case 3:
					if (!pila.empty())
					{
						while (!pila.isEmpty())
						{
							oba = pila.pop();
							oba.Mostrar();
							aux.push(oba);
						}
						while (!aux.empty())
							pila.push(aux.pop());
					}
					else
						System.out.println("Pila vacia...");
					break;
				case 4:
					if (!pila.empty())
					{
						nc = obm.obd.Cadena("No. Ctrl a buscar...");
						ban=true;
						while (!pila.isEmpty())
						{
							oba = pila.pop();
							if (oba.Existe(nc))
							{
								oba.Mostrar();
								ban=false;
							}
							aux.push(oba);
						}
						while (!aux.empty())
							pila.push(aux.pop());
					}
					else
						System.out.println("Pila vacia...");
					break;
				case 5:
					if (!pila.empty())
					{
						nc = obm.obd.Cadena("No. Ctrl a modificar");
						ban=true;
						while (!pila.isEmpty())
						{
							oba = pila.pop();
							if (oba.Existe(nc))
							{
								oba.Mostrar();
								oba.Modificar();
								oba.Mostrar();
								ban=false;
							}
							aux.push(oba);
						}
						while (!aux.empty())
							pila.push(aux.pop());
					}
					else
						System.out.println("Pila vacia...");
			}
		while (op != obm.Salir());
	}
}
