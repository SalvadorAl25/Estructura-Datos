package UNIDAD4;

import EDI.Menu;

public class Arbol3P
{
	public static void main(String[] args)
	{
		int op;
		Menu obm;
		obm = new Menu("Arbol binario con 3 Ref",
				new String[] { "Insertar", "Eliminar", "Recorrido", "Buscar", "Modificar", "Balanceo" });

		Arbol3 arbol = new Arbol3();
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
					arbol.Balancear();
			}
		while (op != obm.Salir());
	}
}
