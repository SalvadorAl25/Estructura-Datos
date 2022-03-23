package Unidad3;

public class NodoSimple
{
	private String nom;
	private NodoSimple ref;
	
	public NodoSimple(String nom)
	{
		this.nom=nom.toUpperCase();
		ref=null;
	}
	
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	public NodoSimple getRef()
	{
		return ref;
	}
	public void setRef(NodoSimple ref)
	{
		this.ref = ref;
	}
	
	
}
