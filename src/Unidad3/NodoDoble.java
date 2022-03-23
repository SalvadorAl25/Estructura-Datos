package Unidad3;

public class NodoDoble
{
	private int num;
	private NodoDoble ant, sig;
	
	public NodoDoble(int num)
	{
		ant=null;
		this.num=num;
		sig=null;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	public NodoDoble getAnt()
	{
		return ant;
	}
	public void setAnt(NodoDoble ant)
	{
		this.ant = ant;
	}
	public NodoDoble getSig()
	{
		return sig;
	}
	public void setSig(NodoDoble sig)
	{
		this.sig = sig;
	}
}
