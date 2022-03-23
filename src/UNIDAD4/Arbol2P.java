package UNIDAD4;

import EDI.Menu;

public class Arbol2P
{
	public static void main(String[] args)
	{
		int op, o;
		Menu obm;
		obm=new Menu("Arbol Binario", new String[]{"Insertar", "Eliminar", "Recorrido", "Buscar", "Modificar", "Balanceo"});
		Arbol2 arbol=new Arbol2();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					arbol.Insertar();
					break;
				case 2:
					o=obm.obd.Entero("Eliminacion por...  \n1)Fusion \n2)Copiado");
					if(o==1)
						arbol.EliminarFusion();
					else
						arbol.EliminarCopiado();
					break;
				case 3:
					o=obm.obd.Entero("Recorrido por...  \n1)Amplitud \n2)Profundidad");
					if(o==1)
						arbol.RecorridoAmplitud();
					else
						arbol.RecorridoProfundidad();
					break;
				case 4:
					arbol.Buscar();
					break;
				case 5:
					arbol.Modificar();
					break;
				case 6:
					arbol.Balanceo();
			}
		while(op!=obm.Salir());
	}
}
