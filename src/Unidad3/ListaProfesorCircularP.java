package Unidad3;

import EDI.Menu;

public class ListaProfesorCircularP
{
	public static void main(String[] args)
	{
		int op, o;
		Menu obm, ob;
		obm = new Menu("Lista de Profesores Circular...", new String[] { "Insertar",
				"Extraer", "Recorrido", "Buscar", "Modificar" });
		ListaProfesorCircular lista = new ListaProfesorCircular();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					ob = new Menu("Insertar...",
							new String[] { "Inicio", "Posicion", "Final" });

					do
						switch (o = ob.Opcion())
						{
							case 1:
								lista.InsertarIni();
								break;
							case 2:
								lista.InsertarPosicion();
								break;
							case 3:
								lista.InsertarFin();
						}
					while (o != ob.Salir());
					break;
				case 2:
					ob = new Menu("Extraer...",
							new String[] { "Inicio", "Posicion", "Final" });

					do
						switch (o = ob.Opcion())
						{
							case 1:
								lista.ExtraerIni();
								break;
							case 2:
								lista.ExtraerPos();
								break;
							case 3:
								lista.ExtraerFin();
						}
					while (o != ob.Salir());
					break;
				case 3:
					lista.Recorrido();
					break;
				case 4:
					lista.Buscar();
					break;
				case 5:
					lista.Modificar();
			}
		while (op != obm.Salir());
	}
}
