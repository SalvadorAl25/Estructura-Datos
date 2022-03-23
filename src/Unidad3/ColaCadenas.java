package Unidad3;
import java.util.*;
import EDI.*;

public class ColaCadenas
{
	public static void main(String[] args)
	{
		int op, pos;
		boolean ban;
		String nom;
		Vector<String> cola=new Vector<String>(5, 2);
		Menu obm=new Menu("Cola de alumnos", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					cola.add(obm.obd.Cadena("Nuevo Nombre"));
					break;
				case 2:
					if(!cola.isEmpty())
						System.out.println("Alumno atendido "+cola.remove(0));
					else
						System.out.println("Cola vacia...");
					break;
				case 3:
					if(!cola.isEmpty())
					{
						System.out.println("");
						for(pos=0; pos<cola.size(); pos++)
							System.out.println((pos+1)+"-."+cola.get(pos));
					}
					else
						System.out.println("Cola Vacia...");
					break;
				case 4:
					if(!cola.isEmpty())
					{
						ban=true;
						nom=obm.obd.Cadena("Nombre o apellido a buscar");
						for (pos = 0; pos < cola.size(); pos++)
							if(cola.get(pos).toUpperCase().indexOf(nom.toUpperCase())!=-1)
							{
								System.out.println((pos+1)+".-"+cola.get(pos));
								ban=false;
							}
						if(ban)
							System.out.println("El Nombre o apellido no existe...");
					}
					else
						System.out.println("Cola vacia...");
					break;
				case 5:
					if(!cola.isEmpty())
					{
						ban=true;
						do
							pos=obm.obd.Entero("Posicion a modificar");
						while(pos<1 || pos>cola.size());
						System.out.println("Nombre a modificar "+cola.get(pos-1));
						cola.set(pos-1, obm.obd.Cadena("Nombre Nuevo"));
					}
					else
						System.out.println("Cola vacia...");
					
			}
		while(op!=obm.Salir());
	}
}
