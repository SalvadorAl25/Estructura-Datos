package Unidad3;

import EDI.Menu;

public class ColaPromediosP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm=new Menu("Cola Promedios", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		ColaPromedios obc=new ColaPromedios();
		
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
