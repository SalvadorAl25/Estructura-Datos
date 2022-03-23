package UNIDAD4;

import java.util.LinkedList;

import EDI.*;

public class Arbol2
{
	private Nodo2 raiz, nvo, ant, act, may, ants, sus;
	private Datos obd = new Datos();
	private LinkedList<Integer> lista;

	public Arbol2()
	{
		raiz = null;
	}

	private boolean Vacio()
	{
		return raiz == null;
	}

	private void Existe()
	{
		for (act = raiz; act != null && act.getDato() != nvo.getDato(); ant = act, act = nvo.getDato() > act.getDato()? act.getDer() : act.getIzq());
	}

	private void Repetido()
	{
		for (ant = raiz; ant != null && ant.getDato() != nvo
				.getDato(); ant = nvo.getDato() > ant.getDato() ? ant.getDer()
						: ant.getIzq())
			;
	}

	public void Insertar()
	{
		nvo = new Nodo2(obd.Entero("Numero"));
		if (!this.Vacio())
		{
			this.Existe();
			if (act == null)
				if (nvo.getDato()<ant.getDato())
					ant.setIzq(nvo);
				else
					ant.setDer(nvo);
			else
				System.out.println("Ya Existe...");
		}
		else
			raiz = nvo;
	}

	public void EliminarFusion()
	{
		if (!this.Vacio())
		{
			nvo = new Nodo2(obd.Entero("Numero a Eliminar"));
			this.Existe();
			if (act != null)
			{
				if (act.getDer() == null)
					nvo = act.getIzq();
				else
					if (act.getIzq() == null)
						nvo = act.getDer();
					else
					{
						nvo = act.getIzq();
						may = nvo;
						while (may.getDer() != null)
							may = may.getDer();
						may.setDer(act.getDer());
					}
				if (act == raiz)
					raiz = nvo;
				else
					if (ant.getDer() == act)
						ant.setDer(nvo);
					else
						ant.setIzq(nvo);
			}
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void EliminarCopiado()
	{
		if (!this.Vacio())
		{
			nvo = new Nodo2(obd.Entero("Numero a eliminar"));
			this.Existe();
			if (act.getIzq() == null && act.getDer() == null)
				if (ant.getIzq() == act)
					ant.setIzq(null);
				else
					ant.setDer(null);
			else
				if (act.getIzq() == null)
				{
					sus = act.getDer();
					ants = null;
					while (sus.getIzq() != null)
					{
						ants = sus;
						sus = sus.getIzq();
					}
					act.setDato(sus.getDato());
					if (ants != null)
						ants.setIzq(sus.getDer());
					else
						act.setDer(sus.getDer());
				}
				else
				{
					sus = act.getIzq();
					ants = null;
					while (sus.getDer() != null)
					{
						ants = sus;
						sus = sus.getDer();
					}
					act.setDato(sus.getDato());
					if (ants != null)
						ants.setDer(sus.getIzq());
					else
						act.setIzq(sus.getIzq());
				}
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void RecorridoAmplitud()
	{
		LinkedList<Nodo2> cola = new LinkedList<Nodo2>();
		if (!this.Vacio())
		{
			cola.add(raiz);
			while (!cola.isEmpty())
			{
				nvo = cola.removeFirst();
				System.out.println(nvo.getDato());
				if (nvo.getIzq() != null)
					cola.add(nvo.getIzq());
				if (nvo.getDer() != null)
					cola.add(nvo.getDer());
			}
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void RecorridoProfundidad()
	{
		LinkedList<Nodo2> pila = new LinkedList<Nodo2>();
		if (!this.Vacio())
		{
			pila.add(raiz);
			while (!pila.isEmpty())
			{
				nvo = pila.removeLast();
				System.out.println(nvo.getDato());
				if (nvo.getDer() != null)
					pila.add(nvo.getDer());
				if (nvo.getIzq() != null)
					pila.add(nvo.getIzq());
			}
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void Buscar()
	{
		if (!this.Vacio())
		{
			nvo = new Nodo2(obd.Entero("Numero a Buscar..."));
			this.Existe();
			if (act != null)
				System.out.println("Si Existe...");
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void Modificar()
	{
		if (!this.Vacio())
		{
			nvo = new Nodo2(obd.Entero("Numero a Modificar..."));
			this.Existe();
			if (act != null)
			{
				do
				{
					nvo = new Nodo2(obd.Entero("Nuevo Numero..."));
					this.Repetido();
					if (ant != null)
						System.out.println("Numero Repetido...");
				}
				while (ant != null);
				act.setDato(nvo.getDato());
				this.Balanceo();
			}
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void Balanceo()
	{
		lista = new LinkedList<Integer>();
		if (!this.Vacio())
		{
			this.Lista(raiz);
			raiz = null;
			this.Balanceo(0, lista.size() - 1);
		}
		else
			System.out.println("Arbol Vacio...");
	}

	/*private void PreOrden(Nodo2 tem)
	{
		if(tem!=null)
		{
			System.out.println(tem.getDato()+" ");
			PreOrden(tem.getIzq());
			PreOrden(tem.getDer());
		}
	}

	private void InOrden(Nodo2 tem)
	{
		if(tem!=null)
		{
			InOrden(tem.getIzq());
			System.out.println(tem.getDato()+" ");
			InOrden(tem.getDer());
		}
	}

	private void PostOrden(Nodo2 tem)
	{
		if(tem!=null)
		{
			PostOrden(tem.getIzq());
			PostOrden(tem.getDer());
			System.out.println(tem.getDato()+" ");
		}
	}*/

	public void Lista(Nodo2 tem)
	{
		if(tem!=null)
		{
			this.Lista(tem.getIzq());
			lista.add(tem.getDato());
			this.Lista(tem.getDer());
		}
	}

	private void Balanceo(int ini, int fin)
	{
		int cen = (ini + fin) / 2;
		if (ini <= fin)
		{
			this.Insertar(lista.get(cen));
			this.Balanceo(ini, cen - 1);
			this.Balanceo(cen + 1, fin);
		}
	}
	
	private void Insertar(int num)
	{
		nvo = new Nodo2(num);
		if (!this.Vacio())
		{
			this.Existe();
			if (act == null)
				if (nvo.getDato()<ant.getDato())
					ant.setIzq(nvo);
				else
					ant.setDer(nvo);
			else
				System.out.println("Ya Existe...");
		}
		else
			raiz = nvo;
	}
}
