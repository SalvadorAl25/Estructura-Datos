package Unidad3;

import EDI.Menu;
import java.util.*;

public class PilaVecrtor
{
	public static void main(String[] args)
	{
		int op, pos;
		String nom;
		boolean ban=false;
		Menu obm=new Menu("Pila Dinamica", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		Vector<String> pila=new Vector<String>(5,2);
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					pila.add(obm.obd.Cadena("Nuevo Nombre"));
					break;
				case 2:
					if(!pila.isEmpty())
						System.out.println("Nombre Estraido"+pila.remove(pila.size()-1));
					else
						System.out.println("Pila Vacia...");
					break;
				case 3:
					if(!pila.isEmpty())
						for(pos=pila.size()-1; pos>=0; pos--)
							System.out.println((pos+1)+" | "+pila.get(pos));
					else
						System.out.println("Pila Vacia...");
					break;
				case 4:
					ban=true;
					if(!pila.isEmpty())
					{
						nom=obm.obd.Cadena("Nombre o Apellido a buscar");
						for(pos=pila.size()-1; pos>=0; pos--)
							if(pila.get(pos).toUpperCase().indexOf(nom.toUpperCase())!=-1)
							{
								System.out.println((pos+1)+" | "+pila.get(pos));
								ban=false;
							}
						if(ban)
							System.out.println("No existe...");
					}
					else
						System.out.println("Pila Vacia...");
					break;
				case 5:
					ban=true;
					if(!pila.isEmpty())
					{
						nom=obm.obd.Cadena("Nombre o Apellido a Modificar");
						for(pos=pila.size()-1; pos>=0; pos--)
							if(pila.get(pos).equalsIgnoreCase(nom))
							{
								System.out.println((pos+1)+" | "+pila.get(pos));
								pila.set(pos, obm.obd.Cadena("Nuevo Nombre"));
								System.out.println((pos+1)+" | "+pila.get(pos));
								ban=false;
							}
						if(ban)
							System.out.println("No existe...");
					}
					else
						System.out.println("Pila Vacia...");
					
			}
		while(op!=obm.Salir());
	}
	
	
}
