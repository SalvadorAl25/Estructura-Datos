package UNIDAD1;

import java.util.Random;
import EDI.*;

public class DirMatriz
{
	private int mat[][], ren, col, di;

	public DirMatriz()
	{
		Datos obd = new Datos();
		do
			ren = obd.Entero("Renglones...");
		while (ren < 2);
		do
			col = obd.Entero("Columnas...");
		while (col < 2);
		do
			di = obd.Entero("Direccion inicial");
		while (di < 1);
		mat = new int[ren][col];
	}

	public void Aleatorios()
	{
		Random obr = new Random();
		for (ren = 0; ren < mat.length; ren++)
			for (col = 0; col < mat[ren].length; col++)
				mat[ren][col] = obr.nextInt(100);
	}

	public void Mostrar()
	{
		System.out.println("Datos de la matriz...");
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat.length; col++)
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
				System.out
						.print((di + (mat[0].length * ren + col) * 2) + "\t");
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
	
	public void InparRen()
	{
		System.out.println("Elementos Inpares Renglones");
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				if(mat[ren][col]%2!=0)
					System.out.print((di + (mat[0].length * ren + col) * 2) + "\t");
				else
					System.out.print("\t");
			System.out.println();
		}
	}
	
	public void InparCol()
	{
		System.out.println("Elementos Inpares Columnas");
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				if(mat[ren][col]%2!=0)
					System.out.print((di + (mat.length * col + ren) * 2) + "\t");
				else
					System.out.print("\t");
			System.out.println();
		}
		
	}
}
