package Unidad3;

import EDI.Datos;

public class ColaProducto
{
	private int ind, pos, clv;
	private Productos cola[];
	private Datos obd = new Datos();

	public ColaProducto()
	{
		do
			ind = obd.Entero("Cantidad de productos de la cola");
		while (ind < 1);
		cola = new Productos[ind];
		ind = -1;
	}

	private boolean Vacia()
	{
		return ind == -1;
	}

	private boolean Llena()
	{
		return ind == cola.length - 1;
	}

	public void Insertar()
	{
		if (!this.Llena())
			cola[++ind] = new Productos();
		else
			System.out.println("Cola Llena...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
		{
			System.out.println("Producto Extraido");
			cola[0].Mostrar();
			for (pos = 0; pos < ind; pos++)
				cola[pos] = cola[pos + 1];
			ind--;
		}
		else
			System.out.println("Cola vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Productos de la cola....");
			for (pos = 0; pos <= ind; pos++)
				cola[pos].Mostrar();
		}
		else
			System.out.println("Cola vacia...");
	}

	public void Buscar()
	{
		if (!this.Vacia())
		{
			clv = obd.Entero("Clave del producto a buscar");
			for (pos = 0; pos <= ind; pos++)
				if (cola[pos].Existe(clv))
				{
					System.out.println("Producto encontrado en la posicion"+(pos+1));
					cola[pos].Mostrar();
					break;
				}
			if(pos>ind)
				System.out.println("El producto no existe...");
		}
		else
			System.out.println("Cola vacia...");
	}
	
	public void Modificar()
	{
		if (!this.Vacia())
		{
			clv = obd.Entero("Clave del producto para modificar");
			for (pos = 0; pos <= ind; pos++)
				if (cola[pos].Existe(clv))
				{
					System.out.println("Producto encontrado en la posicion "+(pos+1));
					cola[pos].Mostrar();
					cola[pos].Modificar();
					System.out.println("Producto modificado");
					cola[pos].Mostrar();
					break;
				}
			if(pos>ind)
				System.out.println("El producto no existe...");
		}
		else
			System.out.println("Cola vacia...");
	}
}
