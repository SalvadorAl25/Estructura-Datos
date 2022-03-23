package Unidad3;

public class NodoDobleProductos
{
	private Productos dato;
	private NodoDobleProductos ant, sig;
	
	public NodoDobleProductos(Productos dato)
	{
		ant=null;
		this.dato=dato;
		sig=null;
	}

	public Productos getDato()
	{
		return dato;
	}

	public void setDato(Productos dato)
	{
		this.dato = dato;
	}

	public NodoDobleProductos getAnt()
	{
		return ant;
	}

	public void setAnt(NodoDobleProductos ant)
	{
		this.ant = ant;
	}

	public NodoDobleProductos getSig()
	{
		return sig;
	}

	public void setSig(NodoDobleProductos sig)
	{
		this.sig = sig;
	}
}
