package UNIDAD1;

import EDI.Datos;

public class ProductoP
{
	public static void main(String[] args)
	{
		Producto obp = new Producto();
		Datos obd = new Datos();
		System.out.println("Dame los datos del producto:");
		obp.Clave(obd.Entero("Clave........"));
		obp.Nombre(obd.Cadena("Nombre......."));
		obp.Precio(obd.Doble("Precio......."));
		obp.Existencia(obd.Entero("Existencia..."));

		System.out.println("Datos del producto...");
		System.out.println("Clave....." + obp.Clave());
		System.out.println("Nombre....." + obp.Nombre());
		System.out.println("Precio....." + obp.Precio());
		System.out.println("Existencia....." + obp.Existencia());
	}
}
