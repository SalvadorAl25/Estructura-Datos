package UNIDAD2;

import EDI.Datos;

/* utilizando un procedimiento recursivo elevelo a una potencia de 0 a n, se pide solo el numero y la potencia*/

public class Elevar
{
	private Datos obd = new Datos();

	public int Numero()
	{
		return obd.Entero("Dame un numero");
	}

	public int Potencia()
	{
		int pot;
		pot = obd.Entero("Dame la potencia");
		if (pot < 0)
			return this.Potencia();
		else
			return pot;
	}

	public int Calcular(int num, int pot)
	{
		if (pot == 0)
			return 1;
		else
			return num * this.Calcular(num, pot - 1);
	}

	public void Mostrar(int res)
	{
		System.out.println("El resultado de la elevacion es " + res);
	}
}
