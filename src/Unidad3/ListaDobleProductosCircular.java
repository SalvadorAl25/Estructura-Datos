package Unidad3;

/* Tarea Crear un metodo que se encarge de insertar nodos dentro de una lista de manera ordenada basado en el programa "lista simple" que almacene nombres de personas
 * 
 */

import EDI.Datos;

public class ListaDobleProductosCircular
{
	private NodoDobleProductos ini, fin, nvo, act, ant;
	private int pos, clv;
	private Datos obd = new Datos();

	public ListaDobleProductosCircular()
	{
		ini = null;
	}

	private boolean Vacia()
	{
		return ini == null;
	}

	private int Tamano()
	{
		int tam = 0;
		for (nvo = ini, tam = 1; nvo != fin; nvo = nvo.getSig(), tam++)
			;
		return tam;
	}

	public void InsertarIni()
	{
		nvo = new NodoDobleProductos(new Productos());
		if (!this.Vacia())
		{
			nvo.setSig(ini);
			ini.setAnt(nvo);
			ini = nvo;
			ini.setAnt(fin);
			fin.setSig(ini);
		}
		else
		{
			ini = fin = nvo;
			ini.setSig(ini);
			ini.setAnt(ini);
		}
	}

	public void InsertarPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Posicion");
			while (pos < 1);
			if (pos == 1)
				this.InsertarIni();
			else
				if (pos > this.Tamano())
					this.InsertarFin();
				else
				{
					nvo = new NodoDobleProductos(new Productos());
					for (act = ini; pos != 1; ant = act, act = act
							.getSig(), pos++)
						;
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
		nvo = new NodoDobleProductos(new Productos());
		if (!this.Vacia())
		{
			fin.setSig(nvo);
			nvo.setAnt(fin);
			fin = nvo;
		}
		else
			ini = fin = nvo;
		fin.setSig(ini);
		ini.setAnt(fin);
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Producto eliminado...");
			ini.getDato().Mostrar();
			if (ini != fin)
			{
				ini = ini.getSig();
				ini.setAnt(fin);
				fin.setSig(ini);

			}
			else
				ini = null;
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void ExtraerPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Posicion");
			while (pos < 1 || pos > this.Tamano());
			if (pos == 1)
				this.ExtraerIni();
			else
				if (pos == this.Tamano())
					this.ExtraerFin();
				else
				{
					for (act = ini; pos != 1; ant = act, act = act
							.getSig(), pos--)
						;
					System.out.println("Producto Eliminado... ");
					act.getDato().Mostrar();
					act = act.getSig();
					ant.setSig(act);
					act.setAnt(ant);
				}
		}
		else
			System.out.println("Lista Vacia");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Producto Eliminado...");
			fin.getDato().Mostrar();
			if (ini != fin)
			{
				fin = fin.getAnt();
				fin.setSig(ini);
				ini.setAnt(fin);
			}
			else
				ini = null;
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void Recorrido()
	{
		int tam=this.Tamano();
		if (!this.Vacia())
		{
			System.out.println("Productos de la lista...");
			for (act = ini, pos = 1; pos<=tam; act = act.getSig(), pos++)
			{
				System.out.print(pos + ".-");
				act.getDato().Mostrar();
			}
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void Buscar()
	{
		int tam=this.Tamano();
		if (!this.Vacia())
		{
			do
				clv = obd.Entero("Clave de producto a buscar");
			while (clv < 1);
			for (act = ini, pos = 1; pos<=tam
					&& !act.getDato().Existe(clv); act = act.getSig(), pos++)
				;
			if (pos<=tam)
			{
				System.out.println("Producto encontrado en la posicion " + pos);
				act.getDato().Mostrar();
			}
			else
				System.out.println("El Producto No Existe");
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void Modificar()
	{
		int tam=this.Tamano();
		if (!this.Vacia())
		{
			do
				clv = obd.Entero("Clave de producto a Modificar");
			while (clv < 1);
			for (act = ini, pos = 1; pos<=tam
					&& !act.getDato().Existe(clv); act = act.getSig(), pos++)
				;
			if (pos<=tam)
			{
				System.out.println("Producto encontrado en la posicion " + pos);
				act.getDato().Mostrar();
				act.getDato().Modificar();
				System.out.println("Producto Modificado...");
				act.getDato().Mostrar();
			}
			else
				System.out.println("El Producto No Existe");
		}
		else
			System.out.println("Lista Vacia...");
	}
}