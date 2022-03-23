package UNIDAD1;

import EDI.*;
import java.util.Random;

public class DirMatLetras
{
	private int ren, col, di;
	private char mat[][];

	public DirMatLetras()
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
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
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

	public void Renglones()
	{
		String vocales="AEIOUaeiou";
		System.out.println("\nDirecciones por renglones");
		for(ren=0;ren<mat.length;ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				if(vocales.indexOf(mat[ren][col])!=1)
					System.out.print((di + (mat[0].length * ren + col) * 2) + "\t");
						else
							System.out.print("\t");
			System.out.println();
		}	
	}

	public void Columna()
	{
		String vocales="AEIOUaeiou";
		System.out.println("\nDirecciones por Columnas");
		for(ren=0;ren<mat.length;ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				if(vocales.indexOf(mat[ren][col])!=1)
					System.out.print((di + (mat.length * col + ren) * 2) + "\t");
						else
							System.out.print("\t");
			System.out.println();
		}	
		
	}
}