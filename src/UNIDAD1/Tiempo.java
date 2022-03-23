package UNIDAD1;

import java.time.*;

/* hacer metodo para comparar tiempos, el tiempo final con tiempo inicial, y mostrar la diferencia de tiempo
 * 
 */

public class Tiempo
{
	int hrs, min, seg, nan;
	
	public Tiempo()
	{
		LocalTime obt=LocalTime.now();
		hrs=obt.getHour()>12?obt.getHour()-12:obt.getHour();
		min=obt.getMinute();
		seg=obt.getSecond();
		nan=obt.getNano();
		this.Mostrar();
	}
	
	private void Mostrar()
	{
		System.out.println(hrs+":"+min+":"+seg);
	}
}
