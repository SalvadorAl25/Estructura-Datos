package UNIDAD1;

import java.util.*;

import EDI.*;

public class VecDinamico
{
	public static void main(String[] args)
	{
		int op, num;
		Menu obm=new Menu("Vector Dinamico", new String[]{"Insertar", "Consulta","Buscar","Modificar","Borrar"});
		
		Vector<Integer> obv=new Vector<Integer>(5, 3);
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obv.add(obm.obd.Entero("Dame un numero"));
					break;
				case 2:
					if(!obv.isEmpty())
					{
						System.out.println("Elementos del Vector...");
						System.out.println(obv);
						/*for (pos = 0; pos < obv.size(); pos++)
							System.out.println(obv.get(pos));*/
					}
					else
						System.out.println("No hay datos");
					break;
				case 3:
					if(!obv.isEmpty())
					{
						num=obm.obd.Entero("Numero a buscar");
						if(obv.contains(num))
							System.out.println("posicion"+obv.indexOf(num)+1);
						else
							System.out.println("No existe...");
					}
					else
						System.out.println("No hay datos...");
					break;
				case 4:
					if(!obv.isEmpty())
					{
						num=obm.obd.Entero("Numero a Modificar");
						if(obv.contains(num))
							obv.set(obv.indexOf(num), obm.obd.Entero("Nuevo Numero"));
						else
							System.out.println("No existe...");
					}
					else
						System.out.println("No hay datos...");
					break;
				case 5:
					if(!obv.isEmpty())
					{
						num=obm.obd.Entero("Numero a Borrar");
						if(obv.contains(num))
							obv.remove(obv.indexOf(num));
						else
							System.out.println("No existe...");
					}
					else
						System.out.println("No hay datos...");
			}
		while(op!=obm.Salir());
	}
}
