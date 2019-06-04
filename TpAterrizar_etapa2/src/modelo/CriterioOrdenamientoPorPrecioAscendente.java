package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CriterioOrdenamientoPorPrecioAscendente extends CriterioOrdenamiento{
	@Override
	public void aplicarCriterio(ArrayList<Asiento> asientos) {
		Collections.sort(asientos, new Comparator<Asiento>() { 
			@Override
			public int compare(Asiento a1, Asiento a2) {
				return Double.compare(a1.getPrecio(),a2.getPrecio());
			}
		});
	}
}