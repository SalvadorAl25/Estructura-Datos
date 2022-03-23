package UNIDAD6;

import EDI.Menu;

public class InternasP
{
		public static void main(String[] args)
		{
			Menu obm=new Menu("Busqueda Externa...", new String[]{"Secuencial", "Binario"});
			int op;
			Internas obi=new Internas();
			
			do
				switch(op=obm.Opcion())
				{
					case 1:
						obi.Mostrar();
						obi.Secuencial();
						break;
					case 2:
						obi.Mostrar();
						obi.Binaria();
				}
			while(op!=obm.Salir());
		}
}
