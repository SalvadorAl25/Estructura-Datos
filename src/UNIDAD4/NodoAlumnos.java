package UNIDAD4;

public class NodoAlumnos
{
	private Alumnos dato;
	private NodoAlumnos izq, der;
	
	public NodoAlumnos(Alumnos dato)
	{
		this.dato=dato;
		izq=null;
		der=null;
	}

	public Alumnos getDato()
	{
		return dato;
	}

	public void setDato(Alumnos dato)
	{
		this.dato = dato;
	}

	public NodoAlumnos getIzq()
	{
		return izq;
	}

	public void setIzq(NodoAlumnos izq)
	{
		this.izq = izq;
	}

	public NodoAlumnos getDer()
	{
		return der;
	}

	public void setDer(NodoAlumnos der)
	{
		this.der = der;
	}
	
	
}
