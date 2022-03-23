package Unidad3;

public class ConersionP
{
	public static void main(String[] args)
	{
		int num;
		Conersion obc=new Conersion();
		num=obc.Entero();
		obc.Presentar("Binario "+obc.Transformar(num, 2));
		obc.Presentar("Octal "+obc.Transformar(num, 8));
		obc.Presentar("Exadecimal "+obc.Transformar(num, 16));
	}
}
