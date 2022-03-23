package Unidad3;

import EDI.Datos;

public class PilaLibros
{
	private int ind, isbn, pos;
	private Libros pila[];
	private Datos obd = new Datos();

	public PilaLibros()
	{
		do
			ind = obd.Entero("Cantidad de Libros");
		while (ind < 1);
		pila = new Libros[ind];
		ind = -1;
	}

	private boolean Vacia()
	{
		return ind == -1;
	}

	public boolean Llena()
	{
		return ind == pila.length - 1;
	}

	public void Insertar()
	{
		if (!this.Llena())
		{
			if (this.Vacia())
				isbn = 1;
			else
				isbn = pila[ind].Isbn() + 1;
			pila[++ind] = new Libros(isbn);
		}
		else
			System.out.println("Pila Llena...");
	}

	public void Extraer()
	{
		if (!this.Vacia())
			pila[ind--].Mostrar();
		else
			System.out.println("Pila Vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
			for (pos = ind; pos >= 0; pos--)
				pila[pos].Mostrar();
		else
			System.out.println("Pila Vacia...");
	}

	public void Buscar()
	{
		if (!this.Vacia())
		{
			isbn = obd.Entero("ISBN a buscar");
			for (pos = ind; pos >= 0; pos--)
				if (pila[pos].Existe(isbn))
				{
					pila[pos].Mostrar();
					break;
				}
			if (pos == -1)
				System.out.println("No Existe...");
		}
		else
			System.out.println("Pila Vacia");
	}

	public void Modificar()
	{

		if (!this.Vacia())
		{
			isbn = obd.Entero("ISBN a buscar");
			for (pos = ind; pos >= 0; pos--)
				if (pila[pos].Existe(isbn))
				{
					pila[pos].Mostrar();
					pila[pos].Modificar();
					pila[pos].Mostrar();
					break;
				}
			if (pos == -1)
				System.out.println("No Existe...");
		}
		else
			System.out.println("Pila Vacia");
	}

}
