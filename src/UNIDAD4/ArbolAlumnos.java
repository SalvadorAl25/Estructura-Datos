package UNIDAD4;

import java.util.LinkedList;

import EDI.Datos;

public class ArbolAlumnos
{
	private NodoAlumnos raiz, nvo, act, ant, may;
	private Datos obd = new Datos();
	private LinkedList<Alumnos> lista;

	public ArbolAlumnos()
	{
		raiz = null;
	}

	private boolean Vacio()
	{
		return raiz == null;
	}

	private void Existe()
	{
		for (act = raiz; act != null && act.getDato().NoCtrl()
				.equalsIgnoreCase(nvo.getDato()
						.NoCtrl()); ant = act, act = nvo.getDato().NoCtrl()
								.compareToIgnoreCase(act.getDato().NoCtrl()) > 0
										? act.getDer() : act.getIzq())
			;
	}

	public void Insertar()
	{
		nvo = new NodoAlumnos(new Alumnos());
		if (!this.Vacio())
		{
			this.Existe();
			if (act == null)
				if (nvo.getDato().NoCtrl()
						.compareToIgnoreCase(ant.getDato().NoCtrl()) > 0)
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
			else
				System.out.println("El No. Ctrl Ya Existe...");
		}
		else
			raiz = nvo;
	}

	public void Eliminar()
	{
		if (!this.Vacio())
		{
			nvo = new NodoAlumnos(new Alumnos());
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
						nvo = act.getIzq();
						may = nvo;
						while (may.getDer() != null)
							may = may.getDer();
						may.setDer(act.getDer());
					}
				if (act == raiz)
					raiz = nvo;
				else
					if (ant.getIzq() == act)
						ant.setIzq(nvo);
					else
						ant.setDer(nvo);
			}
			else
				System.out.println("Arbol Vacio...");
		}
	}

	public void Recorrido()
	{
		if (!this.Vacio())
		{
			System.out.println("Lista de Alumnos");
			this.Recorrido(raiz);
		}
		else
			System.out.println("Arbol Vacio...");
	}

	private void Recorrido(NodoAlumnos tmp)
	{
		if (tmp != null)
		{
			this.Recorrido(tmp.getIzq());
			tmp.getDato().Mostrar();
			this.Recorrido(tmp.getDer());
		}
	}

	public void Buscar()
	{
		if (!this.Vacio())
		{
			nvo = new NodoAlumnos(
					new Alumnos(obd.Cadena("No. Ctrl del alumno a buscar")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Datos del alumno...");
				act.getDato().Mostrar();
			}
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Arbol Vacio");
	}

	public void Modificar()
	{
		boolean rep;
		if (!this.Vacio())
		{
			nvo = new NodoAlumnos(
					new Alumnos(obd.Cadena("No. Ctrl del alumno a Modificar")));
			this.Existe();
			if (act != null)
			{
				System.out.println("Datos del alumno...");
				act.getDato().Mostrar();
				do
				{
					act.getDato().Modificar();
					rep = this.Repetido();
					if (rep)
						System.out.println("No. Ctrl. Repetido...");
				}
				while (rep);
				System.out.println("Datos Modificardos");
				act.getDato().Mostrar();
				this.Balanceo();
			}
			else
				System.out.println("No Existe...");
		}
		else
			System.out.println("Arbol Vacio");
	}

	public void Balanceo()
	{
		if (!this.Vacio())
		{
			this.Lista(raiz);
			raiz = null;
			this.Balanceo(0, lista.size() - 1);
		}
		else
			System.out.println("Arbol Vacio...");
	}

	private void Lista(NodoAlumnos tmp)
	{
		if (tmp != null)
		{
			this.Lista(tmp.getIzq());
			lista.add(tmp.getDato());
			this.Lista(tmp.getDer());
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

	public void Insertar(Alumnos alu)
	{

		nvo = new NodoAlumnos(alu);
		if (!this.Vacio())
		{
			this.Existe();
			if (act == null)
				if (nvo.getDato().NoCtrl()
						.compareToIgnoreCase(ant.getDato().NoCtrl()) > 0)
					ant.setDer(nvo);
				else
					ant.setIzq(nvo);
			else
				System.out.println("El No. Ctrl Ya Existe...");
		}
		else
			raiz = nvo;
	}

	private boolean Repetido()
	{
		int con = 0;
		for (act = raiz; act != null && act.getDato().NoCtrl()
				.equalsIgnoreCase(nvo.getDato()
						.NoCtrl()); ant = act, act = nvo.getDato().NoCtrl()
								.compareToIgnoreCase(act.getDato().NoCtrl()) > 0
										? act.getDer() : act.getIzq())
			if (ant.getDato().NoCtrl().equalsIgnoreCase(act.getDato().NoCtrl()))
				con++;
		return con > 1;
	}
}
