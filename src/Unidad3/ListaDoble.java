package Unidad3;

import EDI.*;

public class ListaDoble
{
	private NodoDoble ini, fin, nvo, act, ant;
	private int pos, num;
	private Datos obd=new Datos();
	
	public ListaDoble()
	{
		ini=null;
	}
	
	private boolean Vacia()
	{
		return ini==null;
	}
	
	private int Tamano()
	{
		int tam=0;
		if(!this.Vacia())
			for (act=ini, tam=1; act.getSig()!=null; act=act.getSig(), tam++);
		return tam;
	}
	
	public void InsertarIni()
	{
		nvo=new NodoDoble(obd.Entero("Numero"));
		if(!this.Vacia())
		{
			nvo.setSig(ini);
			ini.setAnt(nvo);
			ini=nvo;
		}
		else
			ini=fin=nvo;
	}
	
	public void InsertarPos()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("posicion");
			while(pos<1);
			if(pos==1)
				this.InsertarIni();
			else
				if(pos>this.Tamano())
					this.InsertarFin();
				else
				{
					nvo=new NodoDoble(obd.Entero("Numero"));
					for(act=ini; pos!=1; ant= act, act=act.getSig(), pos--);
					ant.setSig(nvo);
					nvo.setAnt(ant);
					nvo.setSig(act);
					act.setAnt(nvo);
				}
		}
		else
			System.out.println("Lista Vacia...");
	}
	
	public void InsertarFin()
	{
		nvo=new NodoDoble(obd.Entero("Numero"));
		if(!this.Vacia())
		{
			fin.setSig(nvo);
			nvo.setAnt(fin);
			fin=nvo;
		}
		else
			ini=fin=nvo;
	}
	
	public void ExtraerIni()
	{
		if(!this.Vacia())
		{
			System.out.println("Numero eliminado "+ini.getNum());
			if(ini!=fin)
			{
				ini=ini.getSig();
				ini.setAnt(null);
			}
			else
				ini=null;
		}
	}
	public void ExtraerPos()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("Posicion");
			while(pos<1 || pos>this.Tamano());
			if(pos==1)
				this.ExtraerIni();
			else
				if(pos==this.Tamano())
					this.ExtraerFin();
				else
				{
					for(act=ini; pos!=1; ant=act, act=act.getSig(), pos--);
					System.out.println("Numero Eliminado "+act.getNum());
					act=act.getSig();
					ant.setSig(act);
					act.setAnt(ant);
				}
		}
		else
			System.out.println("Lista Vacia...");
	}
	public void ExtraerFin()
	{
		if(!this.Vacia())
		{
			System.out.println("Numero eliminado "+fin.getNum());
			if(ini!=fin)
			{
				fin=fin.getAnt();
				fin.setSig(null);
			}
			else
				ini=null;
		}
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			System.out.println("Numero De La Lista...");
			for(act=ini; act!=null; act=act.getSig())
				System.out.println(act.getNum());
		}
		else
			System.out.println("Lista Vacia...");
	}
	
	public void Buscar()
	{
		boolean ban=true;
		if(!this.Vacia())
		{
			num=obd.Entero("Numero A Buscar");
			for(act=ini, pos=1; act!=null; act=act.getSig(), pos++)
				if(act.getNum()==num)
				{
					System.out.println("Encontrado en la posicion: "+pos);
					ban=false;
				}
			if(ban)
				System.out.println("No Existe...");
			
		}
	}
	public void Modificar()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("Posicion del numero a modificar");
			while(pos<1 || pos>this.Tamano());
			for(act=ini; pos!=1; act=act.getSig(), pos--);
			act.setNum(obd.Entero("Nuevo Numero"));
		}
		else
			System.out.println("Lista Vacia... ");
	}
}