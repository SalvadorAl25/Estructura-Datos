package UNIDAD4;

public class Nodo3
{
	private String dato;
	private Nodo3 pad, izq, der;
	
	public Nodo3(String dato)
	{
		pad=null;
		this.dato=dato;
		izq=null;
		der=null;
	}

	public String getDato()
	{
		return dato;
	}

	public void setDato(String dato)
	{
		this.dato = dato;
	}

	public Nodo3 getPad()
	{
		return pad;
	}

	public void setPad(Nodo3 pad)
	{
		this.pad = pad;
	}

	public Nodo3 getIzq()
	{
		return izq;
	}

	public void setIzq(Nodo3 izq)
	{
		this.izq = izq;
	}

	public Nodo3 getDer()
	{
		return der;
	}

	public void setDer(Nodo3 der)
	{
		this.der = der;
	}
}