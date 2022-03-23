package Unidad3;

import EDI.*;

public class PilaCaracter
{
	private char pila[], car;
	private int ind, pos;
	private Datos obd=new Datos();
	private boolean ban;
	
	public PilaCaracter()
	{
		do
			ind=obd.Entero("Dame el tama;o de la pila");
		while(ind<1);
		pila=new char[ind];
		ind=-1;
	}
	
	public boolean Vacia()
	{
		return ind==-1;
	}
	
	private boolean Llena()
	{
		return ind==pila.length-1;
	}
	
	public boolean Insertar(char car)
	{
		ban=!this.Llena();
		if(ban)
			pila[++ind]=car;
		return ban;
	}
	
	public char Extraer()
	{
		car=' ';
		if(!this.Vacia())
			car=pila[ind--];
		return car;
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
			for (pos=ind; pos>=0; pos--)
				System.out.println((pos+1)+"| "+pila[pos]);
	}
	
	public int Buscar(char car)
	{
		pos=-1;
		if(!this.Vacia())
			for (pos = ind; pos>=0; pos--)
				if(pila[pos]==car)
					break;
		return pos+1;
	}
	
	public void Modificar(int pos, char car)
	{
		pos--;
		if(!this.Vacia())
			if(pos>=0 && pos<=ind)
				pila[pos]=car;
	}
}