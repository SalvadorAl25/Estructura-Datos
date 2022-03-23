package UNIDAD4;

public class Producto
{
	private int clv, exi;
	private double pre;
	private String nom;

	public void Clave(int clv)
	{
		this.clv = clv;// quien recive
	}

	public int Clave()
	{
		return clv;
	}

	public void Nombre(String nom)
	{
		this.nom = nom;
	}

	public String Nombre()
	{
		return nom;
	}

	public void Precio(double pre)
	{
		this.pre = pre;
	}

	public double Precio()
	{
		return pre;
	}

	public void Existencia(int exi)
	{
		this.exi = exi;
	}

	public int Existencia()
	{
		return exi;
	}
}
