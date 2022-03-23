package Unidad3;

public class NodoProfesor
{
	private NuevoProfesor dato;
	private NodoProfesor sig;
	
	public NodoProfesor(NuevoProfesor dato)
	{
		this.dato=dato;
		sig=null;
	}

	public NuevoProfesor getDato()
	{
		return dato;
	}

	public void setDato(NuevoProfesor dato)
	{
		this.dato = dato;
	}

	public NodoProfesor getSig()
	{
		return sig;
	}

	public void setSig(NodoProfesor sig)
	{
		this.sig = sig;
	}
	
	
}
