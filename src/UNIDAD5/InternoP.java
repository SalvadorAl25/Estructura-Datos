package UNIDAD5;

import EDI.Menu;

public class InternoP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Ordenamiento Interno...",
				new String[] { "Burbuja", "Burbuja Mejorado", "Quicksoft",
						"Shellsort", "Radix", "Java" });
		Interno obi = new Interno();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					obi.Mostrar();
					obi.Burbuja();
					obi.Mostrar();
					break;
				case 2:
					obi.Mostrar();
					obi.Mejorado();
					obi.Mostrar();
					break;
				case 3:
					obi.Mostrar();
					obi.QuickSoft();
					obi.Mostrar();
					break;
				case 4:
					obi.Mostrar();
					obi.Shellsort();
					obi.Mostrar();
					break;
				case 5:
					obi.Mostrar();
					obi.Radix();
					obi.Mostrar();
					break;
				case 6:
					obi.Mostrar();
					obi.Java();
					obi.Mostrar();

			}
		while (op != obm.Salir());
	}
}
