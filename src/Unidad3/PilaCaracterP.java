package Unidad3;

import EDI.*;

public class PilaCaracterP
{
	public static void main(String[] args)
	{
		int op, pos;
		char car;
		Menu obm=new Menu("Pila Estatica", new String[]{"Insertar", "Extraer", "Recorrido", "Buscar", "Modificar"});
		PilaCaracter obp=new PilaCaracter();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					if(!obp.Insertar(obm.obd.Caracter("Dame un caracter")))
						System.out.println("Pila Llena...");
					break;
				case 2:
					if((car=obp.Extraer())==' ')
						System.out.println("Pila Vacia...");
					else
						System.out.println("Caracter Eliminado "+car);
					break;
				case 3:
					obp.Recorrido();
					break;
				case 4:
					if((pos=obp.Buscar(obm.obd.Caracter("Caracter a buscar")))==0)
						System.out.println("No existe...");
					else
						System.out.println("Caracter Encontrado en la posicion "+pos);
					break;
				case 5:
					obp.Modificar(obm.obd.Entero("Posicion"), obm.obd.Caracter("Caracter"));
			}
		while(op!=obm.Salir());
	}
}
