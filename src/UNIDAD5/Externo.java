package UNIDAD5;

import java.io.*;
import java.util.*;
import EDI.Datos;

public class Externo
{
	private String arch = "base.jss", aux1 = "auxiliar1.jss",
			aux2 = "auxiliar2.jss";
	private RandomAccessFile oba, ob1, ob2;
	private Datos obd = new Datos();
	private int can, num, con;

	public Externo()
	{
		Random obr = new Random();
		do
			can = obd.Entero("Cantidad de numeros");
		while (can < 1);
		this.Borrar();
		for (con = 0; con < can; con++)
		{
			num = obr.nextInt(can * 10);
			try
			{
				oba = new RandomAccessFile(arch, "rw");
				oba.seek(con * 4);
				oba.writeInt(num);
				oba.close(); // hay que cerrar los archivos porque puede entrar
								// datos basura intendibles, y ademas otros
								// procesos no lo pueden usar al mismo tiempo
			}
			catch (IOException e)
			{
			}
		}
	}

	public void Mostrar()
	{
		System.out.println("Contenido del archivo...");
		con = 1;
		try
		{
			oba = new RandomAccessFile(arch, "r");
			try
			{
				while (true)
				{
					num = oba.readInt();
					System.out.print(num + "\t");
					if (con % 5 == 0)
						System.out.println();
					con++;
				}
			}
			catch (EOFException e)
			{
				oba.close();
			}
		}
		catch (IOException e)
		{
		}
	}

	private void Borrar()
	{
		try
		{
			oba = new RandomAccessFile(arch, "rw");
			oba.setLength(0);
			oba.close();
		}
		catch (IOException e)
		{
		}
	}

	public void Directa()
	{
		int par = 1, tam = this.Tamano(arch);
		do
		{
			this.Particion(par);
			this.Fusion(par);
			par *= 2;
		}
		while (par <= tam);
	}

	private int Tamano(String a)
	{
		int t = 0;
		try
		{
			RandomAccessFile o = new RandomAccessFile(a, "r");
			t = (int) o.length() / 4;
			o.close();
		}
		catch (IOException e)
		{

		}
		return t;
	}

	private void Particion(int par)
	{
		try
		{
			oba = new RandomAccessFile(arch, "r");
			ob1 = new RandomAccessFile(aux1, "rw");
			ob1.setLength(0);
			ob2 = new RandomAccessFile(aux2, "rw");
			ob2.setLength(0);
			try
			{
				while (true)
				{
					for (con = 1; con <= par; con++)
						ob1.writeInt(oba.readInt());
					for (con = 1; con <= par; con++)
						ob2.writeInt(oba.readInt());
				}
			}
			catch (EOFException e)
			{
				oba.close();
				ob1.close();
				ob2.close();
			}
		}
		catch (IOException e)
		{

		}

	}

	private void Fusion(int par)
	{
		int num1 = 0, num2 = 0, con1 = 0, con2 = 0;
		con = 0;
		try
		{
			oba = new RandomAccessFile(arch, "rw");
			oba.setLength(0);
			ob1 = new RandomAccessFile(aux1, "r");
			ob2 = new RandomAccessFile(aux2, "r");
			try
			{
				num1 = ob1.readInt();
				num2 = ob2.readInt();
				while (true)
				{
					con1 = 1;
					con2 = 1;
					while (con1 <= par && con2 <= par)
					{
						if (num1 <= num2)
						{
							oba.writeInt(num1);
							con++;
							num1 = ob1.readInt();
							con1++;
						}
						else
						{
							oba.writeInt(num2);
							num2 = oba.readInt();
							con2++;
						}
					}
					if (con1 > par)
						for (; con1 <= par; con1++)
						{
							oba.writeInt(num1);
							con++;
							num1 = ob1.readInt();

						}
					else
						for (; con2 <= par; con2++)
						{
							oba.writeInt(num2);
							num2 = oba.readInt();
						}
				}
			}
			catch (EOFException e)
			{
				if (con <= this.Tamano(aux1))
					try
					{
						while (true)
						{
							oba.writeInt(num1);
							num1 = ob1.readInt();

						}
					}
					catch (EOFException ee)
					{
						ob1.close();
						ob2.close();
					}
				else
					try
					{
						while (true)
						{
							oba.writeInt(num2);
							num2 = ob1.readInt();

						}
					}
					catch (EOFException ee)
					{
						ob1.close();
						ob2.close();
					}
				oba.close();
			}
		}
		catch (IOException e)
		{
		}
	}

	public void Natural()
	{
		int tam;
		do
		{
			tam = this.Particion();
			if (tam != 0)
				this.Fusion();
		}
		while (tam != 0);
	}

	private int Particion()
	{
		int tam = 0, ant;
		boolean ban = true;
		try
		{
			oba = new RandomAccessFile(arch, "r");
			ob1 = new RandomAccessFile(aux1, "rw");
			ob1.setLength(0);
			ob2 = new RandomAccessFile(aux2, "rw");
			ob2.setLength(0);
			try
			{
				while (true)
				{
					num = oba.readInt();
					ob1.writeInt(num);
					ant = num;
					while (true)
					{
						num = oba.readInt();
						if (num < ant)
							ban = !ban;
						if (ban)
							ob1.writeInt(num);
						else
							ob2.writeInt(num);
						ant = num;
					}
				}
			}
			catch (EOFException e)
			{
				oba.close();
				ob1.close();
				ob2.close();
				tam = this.Tamano(aux2);
			}
		}
		catch (IOException e)
		{
		}
		return tam;
	}

	private void Fusion()
	{
		int num1 = 0, num2 = 0;
		con = 1;
		try
		{
			oba = new RandomAccessFile(arch, "rw");
			oba.setLength(0);
			ob1 = new RandomAccessFile(aux1, "r");
			ob2 = new RandomAccessFile(aux2, "r");
			try
			{
				num1 = ob1.readInt();
				num2 = ob2.readInt();
				while (true)
				{
					if (num1 <= num2)
					{
						oba.writeInt(num1);
						con++;
						num = ob1.readInt();

					}
					else
					{
						oba.writeInt(num2);
						num2 = ob2.readInt();
					}
				}
			}
			catch (EOFException e)
			{
				if (con < this.Tamano(aux1))
					try
					{
						while (true)
						{
							oba.writeInt(num1);
							num1 = ob1.readInt();

						}
					}
					catch (EOFException ee)
					{
						ob1.close();
						ob2.close();
					}
				else
					try
					{
						while (true)
						{
							oba.writeInt(num2);
							num2 = ob1.readInt();

						}
					}
					catch (EOFException ee)
					{
						ob1.close();
						ob2.close();
					}
				oba.close();
			}
		}
		catch (IOException e)
		{
		}
	}
}
