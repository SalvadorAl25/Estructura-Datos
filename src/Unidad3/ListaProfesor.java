package Unidad3;

import EDI.Datos;

public class ListaProfesor
{
	private NodoProfesor ini, fin, nvo, ant;
	private int pos, nt;
	private Datos obd=new Datos();
	
	public ListaProfesor()
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
			for(nvo=ini, tam=1; nvo.getSig()!=null; nvo=nvo.getSig(), tam++);
		return tam;
	}
	
	private int NoTargeta()
	{
		int nt=0;
		if(!this.Vacia())
			for (nvo=ini; nvo!=null; nvo=nvo.getSig())
				if(nvo.getDato().NoTargeta()>nt)
					nt=nvo.getDato().NoTargeta();
			return nt+1;
	}
	
	public void InsertarInicio()
	{
		nvo=new NodoProfesor(new NuevoProfesor(this.NoTargeta()));
		if(!this.Vacia())
		{
			nvo.setSig(ini);
			ini=nvo;
		}
		else
			ini=fin=nvo;
	}
	
	public void InsertarPosicion()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("Posicion para insertar el nuevo profesor");
			while(pos<1);
			if(pos==1)
				this.InsertarInicio();
			else
				if(pos>this.Tamano())
					this.InsertarFinal();
				else
				{
					nvo=new NodoProfesor(new NuevoProfesor(this.NoTargeta()));
					for(ant=ini;pos!=2; ant=ant.getSig(), pos--);
					nvo.setSig(ant.getSig());
					ant.setSig(nvo);
				}
		}
		else
			System.out.println("Lista Vacia...");
	}
	
	public void InsertarFinal()
	{
		nvo=new NodoProfesor(new NuevoProfesor(this.NoTargeta()));
		if(!this.Vacia())
		{
			fin.setSig(nvo);
			fin=nvo;
		}
		else
			ini=fin=nvo;
	}
	
	public void ExtraerIni()
	{
		if(!this.Vacia())
		{
			System.out.println("Profesor Eliminado...");
			ini.getDato().Mostrar();
			ini=ini.getSig();
		}
		else
			System.out.println("Lista Vacia... ");
	}
	
	public void ExtraerPos()
	{
		if(!this.Vacia())
		{
			do
				pos=obd.Entero("Posicion del profesor a eliminar");
			while(pos<1 || pos>this.Tamano());
			if(pos==1)
				this.ExtraerIni();
			else
				if(pos==this.Tamano())
					this.ExtraerFin();
				else
				{
					for(ant=ini; pos!=2; ant=nvo.getSig(), pos--);
					System.out.println("Porfesor Eliminado...");
					ant.getSig().getDato().Mostrar();
					ant.setSig(ant.getSig().getSig());
				}
		}
		else
			System.out.println("Lista Vacia...");
	}
	
	public void ExtraerFin()
	{
		if(!this.Vacia())
		{
			System.out.println("Profesor Eliminado");
			fin.getDato().Mostrar();
			if(ini!=fin)
			{
				for(nvo=ini; nvo.getSig()!=fin; nvo=nvo.getSig());
				fin=nvo;
				fin.setSig(null);
			}
		}
		else
			System.out.println("Lista Vacia... ");
	}
	
	public void Recorrido()
	{
		if(!this.Vacia())
		{
			System.out.println("Profesor de la lista...");
			for(nvo=ini, pos=1; nvo!=null; nvo=nvo.getSig(), pos++)
			{
				System.out.println(pos+".-");
				nvo.getDato().Mostrar();
			}
		}
		else
			System.out.println("Lista Vacia...");
	}
	
	public void Buscar()
	{
		if(!this.Vacia())
		{
			do
				nt=obd.Entero("No. Targeta a buscar");
			while(nt<1);
			for(nvo=ini, pos=1; nvo!=null && nvo.getDato().Existe(nt); nvo=nvo.getSig(), pos++);
			
			/*for(nvo=ini, pos=1; nvo!=null; nvo.getSig(), pos++)
				if(nvo.getDato().Existe(nt))
					break;*/
			if(nvo!=null)
			{
				System.out.println(pos+".-");
				nvo.getDato().Mostrar();
			}
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Lista Vacia...");
	}
	
	public void Modificar()
	{
		if(!this.Vacia())
		{
			do
				nt=obd.Entero("No. Targeta a Modificar");
			while(nt<1);
			for(nvo=ini, pos=1; nvo!=null && nvo.getDato().Existe(nt); nvo=nvo.getSig(), pos++);
			
			/*for(nvo=ini, pos=1; nvo!=null; nvo.getSig(), pos++)
				if(nvo.getDato().Existe(nt))
					break;*/
			if(nvo!=null)
			{
				System.out.println(pos+".-");
				nvo.getDato().Mostrar();
				nvo.getDato().Modificar();
				System.out.println(pos+".-");
				nvo.getDato().Mostrar();
			}
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Lista Vacia...");
	}
}