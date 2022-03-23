package Unidad3;

import java.util.Vector;

import EDI.Menu;

public class ColaLibro
{
	public static void main(String[] args)
	{
		int op, pos, isbn;
		Vector<Libros> cola=new Vector<Libros>(5, 2);
		Menu obm=new Menu("Cola Libros", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					if(!cola.isEmpty())
						isbn=cola.get(cola.size()-1).Isbn()+1;
					else
						isbn=1;
					cola.add(new Libros(isbn));
					break;
				case 2:
					if(!cola.isEmpty())
					{
						System.out.println("Libro Vendido ");
						cola.remove(0).Mostrar();
					}
					else
						System.out.println("Cola vacia...");
					break;
				case 3:
					if(!cola.isEmpty())
					{
						System.out.println("Libros en venta...");
						for(pos=0; pos<cola.size(); pos++)
							cola.get(pos).Mostrar();
					}
					else
						System.out.println("Cola Vacia...");
					break;
				case 4:
					if(!cola.isEmpty())
					{
						isbn=obm.obd.Entero("ISBN a buscar");
						for (pos = 0; pos < cola.size(); pos++)
							if(cola.get(pos).Isbn()==isbn)  //cola.get(pos).
							{
								cola.get(pos).Mostrar();
								break;
							}
						if(pos==cola.size())
							System.out.println("El Libro no existe...");
					}
					else
						System.out.println("Cola vacia...");
					break;
				case 5:
					if(!cola.isEmpty())
					{
						isbn=obm.obd.Entero("isbn del libro a modificar");
						for(pos=0; pos<cola.size(); pos++)
							if(cola.get(pos).Existe(isbn))
							{
								System.out.println("Libro a modificar ");
								cola.get(pos).Mostrar();
								cola.get(pos).Modificar();
								System.out.println("Libro Modificado...");
								cola.get(pos).Mostrar();
							}
						if(pos>cola.size())
							System.out.println("el libro no existe");
					}
					else
						System.out.println("Cola vacia...");
					
			}
		while(op!=obm.Salir());
	}
}
