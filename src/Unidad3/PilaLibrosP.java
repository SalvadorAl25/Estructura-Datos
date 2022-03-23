package Unidad3;

import EDI.Menu;

public class PilaLibrosP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm=new Menu("Pila Estatica", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		
		PilaLibros pila=new PilaLibros();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					pila.Insertar();
					break;
				case 2:
					pila.Extraer();
					break;
				case 3:
					pila.Recorrido();
					break;
				case 4:
					pila.Buscar();
					break;
				case 5:
					pila.Modificar();
			}
		while(op!=obm.Salir());
	}
}