package UNIDAD4;

public class Nodo2
{
	private int dato;
	private Nodo2 izq, der;
	
	public Nodo2(int dato)
	{
		this.dato=dato;
		izq=null;
		der=null;
	}

	public int getDato()
	{
		return dato;
	}

	public void setDato(int dato)
	{
		this.dato = dato;
	}

	public Nodo2 getIzq()
	{
		return izq;
	}

	public void setIzq(Nodo2 izq)
	{
		this.izq = izq;
	}

	public Nodo2 getDer()
	{
		return der;
	}

	public void setDer(Nodo2 der)
	{
		this.der = der;
	}
	
	
}
