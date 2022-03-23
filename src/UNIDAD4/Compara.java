package UNIDAD4;

import java.util.*;

public class Compara implements Comparator<Productos>
{
	public int compare(Productos p1, Productos p2)
	{
		return p1.Clave()-p2.Clave();
	}
}
