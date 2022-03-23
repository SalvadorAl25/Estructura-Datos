package UNIDAD1;

import java.util.Random;
import EDI.*;

/* Construir un Arreglo bidimencional que solo agrege letras Mayusculas de manera aleatori, leer la direccion inicial de memoria por renglon y por columna del arreglo;
 * ademas construir un vector que se encarga de almacenar todas las vocales que se encuentren en el arreglo bidimencional y calcular sus direcciones de memoria solo 
 * si conocemos si el vector comienza donde termina la matriz*/

public class MatMayus
{
	private int ren, col, di,dir, ind;
	private char mat[][], vocales[];
	private String  voc="";

	public MatMayus()
	{
		Datos obd = new Datos();
		do
			ren = obd.Entero("No. de renglones");
		while (ren < 2);
		do
			col = obd.Entero("No. de columnas");
		while (col < 2);
		do
			di = obd.Entero("Dirección incial");
		while (di < 1);
		mat = new char[ren][col];
	}

	public void Aleatorios()
	{
		Random obr = new Random();
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (ren = 0; ren < mat.length; ren++)
			for (col = 0; col < mat[ren].length; col++)
				mat[ren][col] = letras.charAt(obr.nextInt(letras.length()));

	}

	public void Mostrar()
	{
		System.out.println("contenido del arreglo:");
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				System.out.print(mat[ren][col] + "\t");
			System.out.println();
		}

	}

	public void Renglon()
	{
		System.out.println("Direcciones Renglones");
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat.length; col++)
			{
				dir=di + (mat[0].length * ren + col) * 2;
				System.out.print(dir + "\t");
			}
			System.out.println();
		}
	}

	public void Columnas()
	{
		System.out.println("Direcciones Columnas...");
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat.length; col++)
				System.out.print((di + (mat.length * col + ren) * 2) + "\t");
			System.out.println();
		}
	}

	public void VecVocales()
	{
		String vocales = "AEIOU";
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				if (vocales.indexOf(mat[ren][col]) != -1)
					voc+=mat[ren][col];
		}
	}
	
	public void VecVocMostrar()
	{
		if(voc.length()!=0)
		{
			vocales=voc.toCharArray();
			System.out.println("\nVocales Encontradas...");
			for (ind = 0; ind < vocales.length; ind++)
				System.out.println(vocales[ind]+"\t"+(dir+ind*2+2));
		}
		else
			System.out.println("\nNo hay vocales");
	}
}
