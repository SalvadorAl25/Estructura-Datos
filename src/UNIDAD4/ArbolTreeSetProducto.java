package UNIDAD4;

import java.util.Iterator;
import java.util.TreeSet;

import EDI.Menu;

public class ArbolTreeSetProducto
{
	public static void main(String[] args)
	{
		int op, clv;
		Menu obm;
		obm = new Menu("Arbol binario TreeSet...", new String[] { "Insertar",
				"Eliminar", "Recorrido", "Buscar", "Modificar"});
		TreeSet<Productos> arbol = new TreeSet<Productos>(new Compara());
		Productos obp=null;
		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (arbol.add(new Productos()))
						System.out.println("Insertado...");
					else
						System.out.println("Repetido...");
					break;
				case 2:
					if (!arbol.isEmpty())
					{
						clv = obm.obd.Entero("Clave del producto a eliminar...");
						if (arbol.contains(new Productos(clv)))
						{
							System.out.println("Datos del producto");
							Iterator<Productos> it=arbol.iterator();
							while(it.hasNext())
							{
								obp=it.next();
								if(obp.Clave()==clv)
								{
									obp.Mostrar();
									break;
								}
							}
							System.out.println("Producto Eliminado");
							arbol.remove(new Productos(clv));
						}
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
						Iterator<Productos> it=arbol.iterator();
						while(it.hasNext())
							it.next().Mostrar();
					}
					else
						System.out.println("Arbol Vacio...");
					break;
				case 4:
					if (!arbol.isEmpty())
					{
						clv = obm.obd.Entero("Clave de producto a buscar");
						if (arbol.contains(new Productos(clv)))
						{
							System.out.println("Datos del producto");
							Iterator<Productos> it=arbol.iterator();
							while(it.hasNext())
							{
								obp=it.next();
								if(obp.Clave()==clv)
								{
									obp.Mostrar();
									break;
								}
							}
						}
						else
							System.out.println("No existe...");
					}
					else
						System.out.println("Arbol Vacio...");
					break;
				case 5:
					if (!arbol.isEmpty())
					{
						clv = obm.obd.Entero("Clave del producto a Modificar...");
						if (arbol.contains(clv))
						{
							Iterator<Productos> it=arbol.iterator();
							while(it.hasNext())
							{
								obp=it.next();
								if(obp.Clave()==clv)
								{
									obp.Mostrar();
									break;
								}
							}
							obp.Modificar();
							arbol.remove(new Productos(clv));
							arbol.add(obp);
							System.out.println("Modificado...");
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
