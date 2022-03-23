package UNIDAD4;

import EDI.Datos;
import EDI.Menu;

public class Productos
{
	private Producto obp=new Producto();
	private Datos obd=new Datos();
	
	public Productos()
	{
		System.out.println("Dame Los Datos del producto...");
		obp.Clave(obd.Entero("clave"));
		obp.Nombre(obd.Cadena("Nombre"));
		obp.Existencia(obd.Entero("Existencia"));
		obp.Precio(obd.Doble("Precio"));
	}
	
	public Productos(int clv)
	{
		obp.Clave(clv);
	}
	
	public void Mostrar()
	{
		System.out.println(obp.Clave()+"\t"+obp.Nombre()+"\t"+obp.Existencia()+"\t"+obp.Precio());
	}
	
	public boolean Existe(int clv)
	{
		return obp.Clave()==clv;
	}
	
	public int Clave()
	{
		return obp.Clave();
	}
	public void Modificar()
	{
		int op;
		Menu obm=new Menu("Modificaciones", new String []{"Nombre", "Existencia", "Precio"});
		do
			switch(op=obm.Opcion())
			{
				case 1:
					obp.Nombre(obd.Cadena("Nuevo Nombre..."));
					break;
				case 2:
					obp.Existencia(obd.Entero("Nueva Existencia"));
					break;
				case 3:
					obp.Precio(obd.Doble("Nuevo Precio"));
					
			}
		while(op!=obm.Salir());
	}
}
