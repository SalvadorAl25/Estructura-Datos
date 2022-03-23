package UNIDAD1;

import EDI.*;

public class ProductosP
{
	public static void main(String[] args)
	{
		int tam, ind = -1, con, op;
		Datos obd = new Datos();
		Menu obm = new Menu("Menú de productos",
				new String[] { "Nuevo", "Mostrar" });
		Producto lista[];
		// definir el tamaño del arreglo
		do
			tam = obd.Entero("Cual es la cantidad de productos?");
		while (tam < 1);
		lista = new Producto[tam];

		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (ind < lista.length-1)
					{
						ind++;
						lista[ind] = new Producto();//lista es un objeto para guardar los datos del producto
						lista[ind].Clave(obd.Entero("Clave"));
						lista[ind].Nombre(obd.Cadena("Nombre"));
						lista[ind].Precio(obd.Doble("Precio"));
						lista[ind].Existencia(obd.Entero("Existencia"));

					}
					else
						System.out.println("Ya no hay espacio...");
					break;
				case 2:
					if(ind!=-1)
						for(con=0;con<=ind; con++)
						{
							System.out.println("Clave: "+lista[con].Clave());
							System.out.println("Nombre: "+lista[con].Nombre());
							System.out.println("Precio: "+lista[con].Precio());
							System.out.println("Existencia: "+lista[con].Existencia());
						}
					else
						System.out.println("No hay productos registrados...");

			}
		while (op != obm.Salir());
		// pregunte el tamaño que este afuera no dentro del menu
		// con un menu 1nuevo 2Mostrar 3Salir

	}
}
