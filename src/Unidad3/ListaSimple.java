 package Unidad3;

import EDI.*;

public class ListaSimple
{
	private NodoSimple ini, fin, nvo, ant, act;
	private int pos;
	private String na;
	private Datos obd = new Datos();

	public ListaSimple()
	{
		ini = null;
	}

	private boolean Vacia()
	{
		return ini == null;
	}

	public void InsetarOrden()
	{
		nvo = new NodoSimple(obd.Cadena("Nombre:"));
		if (!this.Vacia())
		{
			for (act = ini; act != null; ant = ini, act = act.getRef())
				if (act.getNom().compareToIgnoreCase(nvo.getNom()) > 0)
					break;
			if (act == ini)
			{
				nvo.setRef(ini);
				ini = nvo;
			}
			else
				if (act == null)
				{
					fin.setRef(nvo);
					fin = nvo;
				}
				else
					nvo.setRef(act);
			ant.setRef(nvo);
		}
		else
			ini = fin = nvo;
	}

	public void InsertarIni()
	{
		nvo = new NodoSimple(obd.Cadena("Nombre"));
		if (!this.Vacia())
		{
			nvo.setRef(ini);
			ini = nvo;
		}
		else
			ini = fin = nvo;
	}

	public void InsertarPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Posicion a insertar");
			while (pos < 1);
			if (pos == 1)
				this.InsertarIni();
			else
				if (pos > this.Tamano())
					this.InsertarFin();
				else
				{
					nvo = new NodoSimple(obd.Cadena("Nombre"));
					for (ant = ini; pos != 2; ant = ant.getRef(), pos--)
						;
					nvo.setRef(ant.getRef());
					ant.setRef(nvo);
				}
		}
		else
			System.out.println("Lista Vacia...");
	}

	private int Tamano()
	{
		int tam = 0;
		if (!this.Vacia())
			for (nvo = ini, tam = 1; nvo.getRef() != null; nvo = nvo
					.getRef(), tam++)
				;

		return tam;
	}

	public void InsertarFin()
	{
		nvo = new NodoSimple(obd.Cadena("Nombre"));
		if (!this.Vacia())
		{
			fin.setRef(nvo);
			fin = nvo;
		}
		else
			ini = fin = nvo;
	}

	public void ExtraerIni()
	{
		if (!this.Vacia())
		{
			System.out.println("Personas extraidas..." + ini.getNom());
			ini = ini.getRef();
		}
		else
			System.out.println("Lista vacia...");
	}

	public void ExtraerPos()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Posicion del nombre a extraer");
			while (pos < 1 || pos > this.Tamano());
			if (pos == 1)
				this.ExtraerIni();
			else
				if (pos == this.Tamano())
					this.ExtraerFin();
				else
				{
					for (ant = ini; pos != 2; ant = ant.getRef(), pos--)
						System.out.println(
								"Persona Extraida..." + ant.getRef().getNom());
					ant.setRef(ant.getRef().getRef());
				}
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void ExtraerFin()
	{
		if (!this.Vacia())
		{
			System.out.println("Persona Extraida..." + fin.getNom());
			for (ant = ini; ant.getRef() != fin; ant = ant.getRef())
				;
			fin.setRef(null);
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void Recorrido()
	{
		if (!this.Vacia())
		{
			System.out.println("Personas de la lista...");
			for (nvo = ini; nvo != null; nvo = nvo.getRef(), pos++)
				System.out.println(pos + ".-" + nvo.getNom());
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void Buscar()
	{
		boolean ban = true;
		if (!this.Vacia())
		{
			na = obd.Cadena("Nombre o apellido a buscar");
			for (nvo = ini, pos = 1; nvo != null; nvo = nvo.getRef(), pos++)
				if (nvo.getNom().indexOf(na.toUpperCase()) != -1)
				{
					System.out.println(pos + ".-" + nvo.getNom());
					ban = false;
				}
			if (ban)
				System.out.println("No Existe...");
		}
		else
			System.out.println("Lista Vacia...");
	}

	public void Modificar()
	{
		if (!this.Vacia())
		{
			do
				pos = obd.Entero("Posicion del nombre a modificar...");
			while (pos < 1 || pos > this.Tamano());
			for (nvo = ini; pos > 1; nvo = nvo.getRef(), pos--)
				;
			nvo.setNom(obd.Cadena("Nuevo nombre"));
		}
		else
			System.out.println("Lista Vacia...");
	}
}
