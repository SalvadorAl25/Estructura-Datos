package UNIDAD4;

import EDI.Menu;

public class ArbolProductosP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm;
		obm = new Menu("Arbol binario de productos",
				new String[] { "Insertar", "Eliminar", "Recorrido", "Buscar", "Modificar", "Balanceo" });

		ArbolProductos arbol = new ArbolProductos();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					arbol.Insertar();
					break;
				case 2:
					arbol.Eliminar();
					break;
				case 3:
					arbol.Recorrido();
					break;
				case 4:
					arbol.Buscar();
					break;
				case 5:
					arbol.Modificar();
					break;
				case 6:
					arbol.Balanceo();
			}
		while (op != obm.Salir());
	}
}
