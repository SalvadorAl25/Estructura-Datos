package UNIDAD6;

import java.util.Arrays;
import java.util.Random;

import EDI.Datos;

public class Internas
{
	private int arr[], ind, num, can, x, pos;
	private Datos obd = new Datos();
	private Random obr = new Random();

	public Internas()
	{
		do
			can = obd.Entero("Cantidad de numeros");
		while (can < 1);
		arr = new int[can];
		for (ind = 0; ind < arr.length; ind++)
		{
			do
			{
				num = obr.nextInt(can * 10);
				for (x = 0; x < ind && arr[x] != num; x++)
					;
			}
			while (x != ind);
			arr[ind] = num;
		}
		Arrays.sort(arr);
	}

	public void Mostrar()
	{
		System.out.println("Contenido del arreglo...");
		for (ind = 0; ind < arr.length; ind++)
		{
			System.out.print(arr[ind] + "\t");
			if ((ind + 1) % 5 == 0) // es para ordenarlos en filas de 5 en 5
				System.out.println();
		}
	}

	public void Secuencial()
	{
		num = obd.Entero("Numero a buscar");
		pos = -1;
		for (ind = 0; ind < arr.length; ind++)
			if (arr[ind] == num)
			{
				pos = ind + 1;
				break;
			}
		if(pos!=-1)
			System.out.println("Encontrado en la posicion: "+pos);
		else
			System.out.println("No Existe...");
	}
	
	public void Binaria()
	{
		int ini=0, fin=arr.length-1, cen;
		pos=-1;
		num=obd.Entero("Numero a buscar...");
		while(ini<fin)
		{
			cen=(ini+fin)/2;
			if(arr[cen]==num)
			{
				pos=cen+1;
				break;
			}
			else
				if(num>arr[cen])
					ini=cen+1;
				else
					fin=cen-1;
		}
		if(pos!=-1)
			System.out.println("Encontrado en la posicion "+pos);
		else
			System.out.println("No existe...");
	}
}