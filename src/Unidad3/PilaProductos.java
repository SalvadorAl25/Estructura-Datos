package Unidad3;

import java.util.*;
import EDI.*;

public class PilaProductos
{
	public static void main(String[] args)
	{
		int op, pos, clv;
		Menu obm=new Menu("Pila Dinamica Vector", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		Vector<Productos> pila=new Vector<Productos>(5,2);
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					pila.add(new Productos());
					break;
				case 2:
					if(!pila.isEmpty())
					{
						System.out.println("Datos del producto extraido...");
						pila.remove(pila.size()-1).Mostrar();
					}
					else
						System.out.println("Pila Vacia...");
					break;
				case 3:
					if(!pila.isEmpty())
					{
						System.out.println("Productos de la pila...");
						for(pos=pila.size()-1; pos>=0; pos--)
							pila.get(pos).Mostrar();
					}
					else
						System.out.println("Pila vacia...");
					break;
				case 4:
					if(!pila.isEmpty())
					{
						clv=obm.obd.Entero("Clave del producto que busca");
						for(pos=pila.size()-1; pos>=0; pos--)
							if(pila.get(pos).Existe(clv))
							{
								System.out.println("Producto encontrado...");
								pila.get(pos).Mostrar();
								break;
							}
						if(pos==-1)
							System.out.println("El producto no existe...");
					}
					break;
				case 5:
					if(!pila.isEmpty())
					{
						clv=obm.obd.Entero("Clave del producto a Modificar");
						for(pos=pila.size()-1; pos>=0; pos--)
							if(pila.get(pos).Existe(clv))
							{
								System.out.println("Producto encontrado...");
								pila.get(pos).Mostrar();
								pila.get(pos).Modificar();
								System.out.println("Producto Modificado...");
								pila.get(pos).Mostrar();
								break;
							}
						if(pos==-1)
							System.out.println("El producto no existe...");
					}
			}
		while(op!=obm.Salir());
	}
}
