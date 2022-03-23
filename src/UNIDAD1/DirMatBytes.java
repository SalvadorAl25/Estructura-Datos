package UNIDAD1;

/* Construir un arreglo de bytes asignarlos de manera aleatoria y presentar las direcciones de memoria fisica por renglon y columna si el arreglo es cuadrado*/

import EDI.*;
import java.util.*;

public class DirMatBytes
{
	private int ren, col, di;
	private byte mat[][];
	
	public DirMatBytes()
	{
		Datos obd=new Datos();
		do
			ren=obd.Entero("Renglones");
		while(ren<2);
		do
			col=obd.Entero("Columnas");
		while(col<2);
		do
			di=obd.Entero("Direccion inicial");
		while(di<1);
		mat=new byte[ren][col];
	}
	
	public void Aleatorios()
	{
		Random obr=new Random();
		for (ren = 0; ren < mat.length; ren++)
			for (col = 0; col < mat[ren].length; col++)
				mat[ren][col]=(byte)obr.nextInt(128);
	}
	
	public void Mostrar()
	{
		System.out.println("Contenido Del arreglo");
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				System.out.print(mat[ren][col]+"\t");
			System.out.println();
		}
	}
	
	public void Direcciones()
	{
		if(mat.length==mat[0].length)
		{
			System.out.println("Direcciones Por Renglon y Columna");
			for (ren = 0; ren < mat.length; ren++)
				System.out.println((char)mat[ren][ren]+"-"+(di + (mat[0].length * ren + col) * 2) + "\t");
		}
		else
			System.out.println("No Contiene Diagonal...");
	}
}
