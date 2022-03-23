package UNIDAD5;

import EDI.Menu;

/* Tarea:
 * generar un metodo que ayude a que los numeros no se repitan
 * tiene que trabajar con el metodo "Externo"
 * 
 */

public class ExternoP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm=new Menu("Ordenamiento Externo...", new String[]{"Directo", "Natural","Mostrar"});
		Externo obe=new Externo();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obe.Mostrar();
					obe.Directa();
					obe.Mostrar();
					break;
				case 2:
					obe.Mostrar();
					obe.Natural();
					obe.Mostrar();
					break;
				case 3:
					obe.Mostrar();
			}
		while(op!=obm.Salir());
	}
}
