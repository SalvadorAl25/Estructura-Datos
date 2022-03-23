package UNIDAD4;

import EDI.Datos;
import java.util.*;

public class Arbol3
{
	private Nodo3 raiz, nvo, act, ant, may;
	private Datos obd = new Datos();
	private LinkedList<String> lista;

	public Arbol3()
	{
		raiz = null;
	}

	private boolean Vacio()
	{
		return raiz == null;
	}

	private void Existe()
	{
		for (act = raiz; act != null && !act.getDato()
				.equals(nvo.getDato()); ant = act, act = nvo.getDato()
						.compareTo(act.getDato()) > 0 ? act.getDer()
								: act.getIzq())
			;
	}

	public void Insertar()
	{
		nvo = new Nodo3(obd.Cadena("Nuevo Nombre").toUpperCase());
		if (this.Vacio())
		{
			this.Existe();
			if (act == null)
			{
				if (nvo.getDato().compareTo(ant.getDato()) > 0)
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
				nvo.setPad(ant);
			}
		}
		else
			raiz = nvo;
	}

	public void Eliminar()
	{
		if (!this.Vacio())
		{
			nvo = new Nodo3(obd.Cadena("Nombre a eliminar").toUpperCase());
			this.Existe();
			if (act != null)
			{
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
						raiz.setPad(null);
				}
				else
				{
					if (nvo.getDato().compareTo(ant.getDato()) > 0)
						ant.setDer(nvo);
					else
						ant.setIzq(nvo);
					if (nvo != null)
						nvo.setPad(ant);
				}
			}
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void Recorrido()
	{
		if (!this.Vacio())
		{
			System.out.println("Nombres del arbol...");
			this.Recorrido(raiz);
		}
		else
			System.out.println("Arbol Vacio...");
	}

	private void Recorrido(Nodo3 tmp)
	{
		if (tmp == null)
			return;
		this.Recorrido(tmp.getIzq());
		System.out.println(tmp.getDato());
		this.Recorrido(tmp.getDer());
	}

	public void Buscar()
	{
		if (!this.Vacio())
		{
			nvo = new Nodo3(obd.Cadena("Nombre a buscar...").toUpperCase());
			this.Existe();
			if (act != null)
				System.out.println("Si Existe en el Arbol...");
			else
				System.out.println("No Existe en el arbol...");
		}
		else
			System.out.println("Arbol Vacio...");
	}

	public void Modificar()
	{
		if (!this.Vacio())
		{
			nvo = new Nodo3(obd.Cadena("Nombre a Modificar...").toUpperCase());
			this.Existe();
			if (act != null)
			{
				do
					act.setDato(obd.Cadena("Nuevo Nombre").toUpperCase());
				while (this.Repetido());
				this.Balancear();
			}
		}
		else
			System.out.println("Arbol Vacio...");
	}

	private boolean Repetido()
	{
		int con = 0;
		for (ant = raiz; ant != null; ant = act.getDato()
				.compareTo(ant.getDato()) > 0 ? ant.getDer() : ant.getIzq())
			if (ant.getDato().equals(act.getDato()))
				con++;
		if (con > 1)
			System.out.println("Nombre Repetido...");
		return con > 1;
	}

	public void Balancear()
	{
		if (!this.Vacio())
		{
			lista = new LinkedList<String>();
			this.Lista(raiz);
			raiz = null;
			this.Balancear(0, lista.size() - 1);
		}
		else
			System.out.println("Arbol Vacio...");
	}

	private void Lista(Nodo3 tmp)
	{
		if (tmp == null)
			return;
		this.Lista(tmp.getIzq());
		lista.add(tmp.getDato());
		this.Lista(tmp.getDer());
	}

	private void Balancear(int ini, int fin)
	{
		int cen = (ini + fin) / 2;
		if (ini <= fin)
		{
			this.Insertar(lista.get(cen));
			this.Balancear(ini, cen - 1);
			this.Balancear(cen + 1, fin);
		}
	}

	private void Insertar(String nom)
	{
		nvo = new Nodo3(nom);
		if (this.Vacio())
		{
			this.Existe();
			if (act == null)
			{
				if (nvo.getDato().compareTo(ant.getDato()) > 0)
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
				nvo.setPad(ant);
			}
		}
		else
			raiz = nvo;
	}
}
