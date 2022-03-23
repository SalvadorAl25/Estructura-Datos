package UNIDAD1;

import EDI.*;

public class AlumnosP
{
	public static void main(String[] args)
	{
		int op, x=-1, con;
		String nc;
		ALUMNOS lista[]=new ALUMNOS[5];
		Menu obm=new Menu("Menu De Alumnos", new String[]{"Nuevo", "Consultar", "Modificar", "Buscar", "Borrar"});
		
		do
			switch(op=obm.Opcion())
			{
			case 1:
				if(x<lista.length-1)
				{
					do
					{
						nc=obm.obd.Cadena("No. Ctrl");
						for(con=0; con<=x; con++)
							if(lista[con].Existe(nc))
								break;
						if(con<=x)
							System.out.println("Ya Existe...");
					}
					while(con<=x);
					lista[++x]=new ALUMNOS(nc);
				}
				else
					System.out.println("No Hay Espacio...");
				break;
			case 2:
				if(x!=-1)
					for(con=0; con<=x; con++)
						lista[con].Mostrar();
				else
					System.out.println("No Hay Datos...");
				break;
			case 3:
				if(x!=-1)
				{
					nc=obm.obd.Cadena("No. Ctrl a Modificar...");
					for(con=0; con<=x; con++)
						if(lista[con].Existe(nc))
						{
							lista[con].Mostrar();
							lista[con].Modificar();
							lista[con].Mostrar();
							break;
						}
					if(con>x)
						System.out.println("No Existe...");
					else
						System.out.println("No Hay Datos...");
				}
				break;
			case 4:
				if(x!=-1)
				{
					nc=obm.obd.Cadena("No. Ctrl a Buscar...");
					for(con=0; con<=x; con++)
						if(lista[con].Existe(nc)) //el punto y coma si se utiliza en este tipo de condiciones, significa que no contiene cuerpo, y en este caso no aria nada...
						{
							lista[con].Mostrar();
							break;
						}
					if(con>x)
						System.out.println("No Existe...");
					else
						System.out.println("No Hay Datos...");
				}
			case 5:
				if(x!=-1)
				{
					nc=obm.obd.Cadena("No. Ctrl a Borrar...");
					for(con=0; con<=x; con++)
						if(lista[con].Existe(nc))
						{
							lista[con].Mostrar();
							for(;con<x; con++)
								lista[con]=lista[con+1];
							x--;
							con--;
							break;
						}
					if(con>x)
						System.out.println("No Existe...");
					else
						System.out.println("No Hay Datos...");
				}
			}
		while(op!=obm.Salir());
	}
}
