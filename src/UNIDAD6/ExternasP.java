package UNIDAD6;

import EDI.Menu;

public class ExternasP
{
	public static void main(String[] args)
	{
		Menu obm=new Menu("Busqueda Externa...", new String[]{"Secuencial", "Binario","Mostrar"});
		int op;
		Externas obe=new Externas();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obe.Mostrar();
					obe.Secuencial();
					break;
				case 2:
					obe.Mostrar();
					obe.Binario();
					break;
				case 3:
					obe.Mostrar();
			}
		while(op!=obm.Salir());
	}
}
