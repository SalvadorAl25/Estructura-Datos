package UNIDAD4;

import java.util.LinkedList;

import EDI.Datos;


public class ArbolProductos
{
	private NodoProductos raiz, nvo, act, ant, may;
	private Datos obd = new Datos();
	private LinkedList<Productos>lista;

	public ArbolProductos()
	{
		raiz = null;
	}

	private boolean Vacio()
	{
		return raiz == null;
	}

	public void Insertar()
	{
		nvo=new NodoProductos(new Productos());
		if(!this.Vacio())
		{
			this.Existe();
			if(act==null)
			{
				if(nvo.getDato().Clave()>ant.getDato().Clave())
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
				nvo.setPad(ant);
			}
		}
		else
			raiz=nvo;
	}

	private void Existe()
	{
		for (act = raiz; act != null
				&& nvo.getDato().Clave() != act.getDato().Clave(); ant = act, act = nvo.getDato().Clave() > act
								.getDato().Clave() ? act.getDer()
										: act.getIzq())
			;
	}

	public void Eliminar()
	{
		if (!this.Vacio())
		{
			nvo = new NodoProductos(
					new Productos(obd.Entero("Clave del producto a eliminar")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Producto eliminado...");
				act.getDato().Mostrar();
				if (act.getIzq() == null)
					nvo = act.getDer();
				else
					if (act.getDer() == null)
						nvo = act.getIzq();
					else
					{
						may = act.getIzq();
						nvo = may;
						while (may.getDer() != null)
							may = may.getDer();
						may.setDer(act.getDer());
						act.getDer().setPad(may);
					}
				if (act == raiz)
				{
					raiz = nvo;
					if (nvo != null)
						nvo.setPad(null);
				}
				else
				{
					if (ant.getIzq() == act)
						ant.setIzq(nvo);
					else
						ant.setDer(nvo);
					if (act != raiz)
						nvo.setPad(ant);
				}

			}
			else
				System.out.println("El producto no existe...");
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void Recorrido()
	{
		if(!this.Vacio())
		{
			System.out.println("Productos del arbol...");
			this.Recorrido(raiz);
		}
		else
			System.out.println("Arbol Vacio...");
	}
	
	private void Recorrido(NodoProductos tmp)
	{
		if(tmp==null)
			return;
		this.Recorrido(tmp.getIzq());
		tmp.getDato().Mostrar();
		this.Recorrido(tmp.getDer());
	}

	public void Buscar()
	{
		if (!this.Vacio())
		{
			nvo = new NodoProductos(
					new Productos(obd.Entero("Clave del producto a Buscar...")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Producto encontrado...");
				act.getDato().Mostrar();
			}
			else
				System.out.println("El producto no existe...");
		}
		else
			System.out.println("Arbol Vacio");
	}

	public void Modificar()
	{
		if (!this.Vacio())
		{
			nvo = new NodoProductos(
					new Productos(obd.Entero("Clave del producto a Modificar...")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Datos del producto...");
				act.getDato().Mostrar();
				act.getDato().Modificar();
				System.out.println("Datos del producto modificado");
				act.getDato().Mostrar();
			}
			else
				System.out.println("El producto no existe...");
		}
		else
			System.out.println("Arbol Vacio");
	}

	public void Balanceo()
	{
		if(!this.Vacio())
		{
			lista=new LinkedList<Productos>();
			this.Lista(raiz);
			raiz=null;
			this.Balanceo(0, lista.size()-1);
		}
		else
			System.out.println("Arbol vacio...");
	}
	
	private void Lista(NodoProductos tmp)
	{
		if(tmp!=null)
		{
			this.Lista(tmp.getIzq());
			lista.add(tmp.getDato());
			this.Lista(tmp.getDer());
		}
	}
	
	private void Balanceo(int ini, int fin)
	{
		int cen=(ini+fin)/2;
		if(ini<=fin)
		{
			this.Insertar(lista.get(cen));
			this.Balanceo(ini, cen-1);
			this.Balanceo(cen+1, fin);
		}
	}
	
	private void Insertar(Productos pro)
	{
		nvo=new NodoProductos(new Productos());
		if(!this.Vacio())
		{
			this.Existe();
			if(act==null)
			{
				if(nvo.getDato().Clave()>ant.getDato().Clave())
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
				nvo.setPad(ant);
			}
		}
		else
			raiz=nvo;
	}
}
