package UNIDAD2;

/*utilizando recursividad realizar un programa que muestre esta escala
 * 12345
 * 1234
 * 123
 * 12
 * 1
 * un granjero quiere determinar cual es la cantidad de pares de conejos  que tendra despues de una cantidad de meses si el granjero compra un par de conejos y ese par al final del
 * mes tiene a otro par de conejos, cada par de conejos es productivo al mes por lo tanto se tiene otro par*/

public class ElevarP
{
	public static void main(String[] args)
	{
		Elevar obv=new Elevar();
		obv.Mostrar(obv.Calcular(obv.Numero(), obv.Potencia()));
	}
}
