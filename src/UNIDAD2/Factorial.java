package UNIDAD2;

import EDI.*;

public class Factorial
{
	public int Numero()
	{
		int num;
		Datos obd = new Datos();
		do
			num = obd.Entero("Dame un numero");
		while (num < 0);
		return num;
	}

	public int Calcular(int num)
	{
		if (num == 0)
			return 1;
		else
			return num * Calcular(num - 1);
	}

	public void Mostrar(int res)
	{
		System.out.println("El Factorial es " + res);
	}
}
