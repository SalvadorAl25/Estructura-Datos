package UNIDAD2;
/*utilizando recursividad calcule el producto de dos numeros*/
import EDI.Datos;
public class Producto
{
	public int Numero()
	{
		Datos obd=new Datos();
		int num;
		do
			num=obd.Entero("Producto 1: ");
		while(num<1);
		return num;
	}
	
	public int Resultado(int num1, int num2)
	{
		if(num1==1)
			return num2;
		else
			return num2+Resultado(num1-1, num2);
	}
	
	public void Mostrar(int res)
	{
		System.out.println("El resultado es "+res);
	}
}
