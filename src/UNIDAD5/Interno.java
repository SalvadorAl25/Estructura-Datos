package UNIDAD5;

import java.util.*;

import EDI.Datos;

public class Interno
{
	private int arr[], ind, num, can, x, aux;
	private Datos obd = new Datos();
	private Random obr = new Random();

	public Interno()
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

	public void Burbuja()
	{
		for (x = 1; x < arr.length; x++)
			for (ind = 0; ind < arr.length; ind++)
				if (arr[ind] > arr[ind + 1])
				{
					aux = arr[ind];
					arr[ind] = arr[ind] + 1;
					arr[ind + 1] = aux;
				}
	}

	public void Mejorado()
	{
		for (ind = 0; ind < arr.length - 1; ind++)
			for (x = ind + 1; x < arr.length; x++)
				if (arr[ind] > arr[x])
				{
					aux = arr[ind];
					arr[ind] = arr[x];
					arr[x] = aux;
				}
	}

	public void QuickSoft()
	{
		// se le conoce como divide y venceras...
		this.QuickSoft(0, arr.length - 1);
	}

	private void QuickSoft(int ini, int fin)
	{
		int cen = (ini + fin) / 2, izq = ini, der = fin, piv = arr[cen];
		while (izq <= der)
		{
			while (arr[izq] < piv)
				izq++;
			while (arr[der] > piv)
				der--;
			if (izq <= der)
			{
				aux = arr[izq];
				arr[izq] = arr[der];
				arr[der] = aux;
				izq++;
				der--;
			}
		}
		if (ini < der)
			this.QuickSoft(ini, der);
		if (izq < fin)
			this.QuickSoft(izq, fin);
	}

	public void Shellsort()
	{
		// se le conoce como incrementos decrecientes...
		// el primer ciclo se encarga del control de los incrementos, inicia con
		// la mitad del tama;o del arreglo y continua su ejecucion, mientras le
		// incremento sea mayor que 0
		// su valor cambiante es de la mitar del incremento anterior.
		// un segundo ciclo controla el numero de comparaciones que se debe
		// hacer, segun el tama;o del incremento, su control debe comenzar con
		// el valor del ciclo anterior
		// cambiando de 1 en 1 mientras sea menor al tama;o del arreglo.
		int inc;
		for (inc = arr.length / 2; inc > 0; inc /= 2)
			for (ind = inc; ind < arr.length; ind++)
				// un tercer ciclo determina en que momento se detienen las
				// comparaciones o se hacen los posibles intercambios... su
				// control comienza con el valor del ciclo anterior
				// y mientras que ese valor, mientras que su valor sea mayor o
				// igual al incremento que controla del 1er ciclo y el elemento
				// de la posicion que controla este ciclo menos el incremento
				// sea mayor que el elemento del control de este ciclo se
				// realizan los intercambios entre estas posiciones, por ultimo
				// el control del ciclo se debe decrementar con el valor del
				// incremento
				for (x = ind; x >= inc && arr[x - inc] > arr[x]; x -= inc)
				{
					aux = arr[x - inc];
					arr[x - inc] = arr[x];
					arr[x] = aux;
				}
	}

	public void Radix()
	{
		// se le llama metodos por distribucion
		int nd = this.Digitos(), dig, fac;
		@SuppressWarnings("unchecked")
		LinkedList<Integer> lista[] = new LinkedList[10];
		for (ind = 0; ind < lista.length; ind++)
			lista[ind] = new LinkedList<Integer>();
		for (dig = 1, fac = 1; dig <= nd; dig++, fac *= 10)
		{
			for (ind = 0; ind < arr.length; ind++)
				lista[arr[ind] / fac % 10].add(arr[ind]);
			ind = 0;
			for (x = 0; x < lista.length; x++)
				while (!lista[x].isEmpty())
					arr[ind++] = lista[x].removeFirst();
		}
	}

	private int Digitos()
	{
		int may = arr[0];
		for (ind = 1; ind < arr.length; ind++)
			if (arr[ind] > may)
				may = arr[ind];
		return (may + "").length();
	}

	public void Java()
	{
		Arrays.sort(arr);
	}
}
