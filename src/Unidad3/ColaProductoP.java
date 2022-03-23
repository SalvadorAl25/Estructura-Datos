package Unidad3;

import EDI.Menu;

public class ColaProductoP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm=new Menu("Cola de Productos", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		ColaProducto obc=new ColaProducto();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obc.Insertar();
					break;
				case 2:
					obc.Extraer();
					break;
				case 3:
					obc.Recorrido();
					break;
				case 4:
					obc.Buscar();
					break;
				case 5:
					obc.Modificar();
			}
		while(op!=obm.Salir());
	}
}
