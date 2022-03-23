package UNIDAD4;

public class NodoProductos
{
	private Productos dato;
	private NodoProductos pad, izq, der;
	
	public NodoProductos(Productos dato)
	{
		pad=null;
		this.dato=dato;
		izq=null;
		der=null;
	}

	public Productos getDato()
	{
		return dato;
	}

	public void setDato(Productos dato)
	{
		this.dato = dato;
	}

	public NodoProductos getPad()
	{
		return pad;
	}

	public void setPad(NodoProductos pad)
	{
		this.pad = pad;
	}

	public NodoProductos getIzq()
	{
		return izq;
	}

	public void setIzq(NodoProductos izq)
	{
		this.izq = izq;
	}

	public NodoProductos getDer()
	{
		return der;
	}

	public void setDer(NodoProductos der)
	{
		this.der = der;
	}
}
