package UNIDAD6;

import java.io.*;
import java.util.*;
import EDI.Datos;

public class Externas
{
	/*
	 * funsion hash modulo(lo divide), cuadratica, plegamiento(lo divide en
	 * bloques y el mas a la derecha es la posicon), truncamiento(toma los pares
	 * o impares los concatena y los manda mas a la derecha) controles de
	 * coalisiones, prueba lineal(reasignacion)
	 * 
	 * 
	 */

	private String arch = "base.jas", aux1 = "auxiliar1.jas",
			aux2 = "auxiliar2.jas";
	private RandomAccessFile oba, ob1, ob2;
	private Datos obd = new Datos();
	private int can, num, con, pos;

	public Externas()
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
				if (!this.Existe())
				{
					oba = new RandomAccessFile(arch, "rw");
					oba.seek(con * 4);
					oba.writeInt(num);
					oba.close();
				}
			}
			catch (IOException e)
			{
			}
		}
		this.Natural();
	}

	private boolean Existe()
	{
		int n;
		boolean exi = false;
		try
		{
			oba = new RandomAccessFile(arch, "r");
			try
			{
				while (true)
				{
					n = oba.readInt();
					if (n == num)
					{
						exi = true;
						break;
					}
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
		return exi;
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

	private void Natural()
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
					while (true)
					{
						num = oba.readInt();
						ob1.writeInt(num);
						ant = num;
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
		int num1 = 0, num2 = 0, con = 0;
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
					if (num1 < num2)
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

	public void Secuencial()
	{
		num = obd.Entero("Numero a Buscar");
		pos = 0;
		con = 0;
		try
		{
			oba = new RandomAccessFile(arch, "r");
			try
			{
				while (true)
				{
					con++;
					if (num == oba.readInt())
					{
						pos = con;
						oba.close();
						break;
					}
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
		if (pos != 0)
			System.out.println("Encontrado en la posicion: " + pos);
		else
			System.out.println("No Existe...");
	}

	public void Binario()
	{
		int ini = 0, fin = this.Tamano(arch), cen, nb;
		nb = obd.Entero("Numero a buscar");
		try
		{
			oba = new RandomAccessFile(arch, "r");
			cen = (ini + fin) / 2;
			oba.seek(cen * 4);
			num = oba.readInt();
			while (num!=nb && ini <= fin)
			{
				if (num > nb)
					fin = cen - 1;
				else
					ini = cen + 1;
				cen = (ini + fin) / 2;
				oba.seek(cen * 4);
				num = oba.readInt();
			}
			oba.close();
			if (num == nb)
				System.out.println(
						"Numero encontrado en la posicion: " + (cen + 1));
		}
		catch (IOException e)
		{
		}
	}
}
