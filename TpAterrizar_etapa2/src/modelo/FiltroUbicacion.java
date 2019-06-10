package modelo;

import java.util.ArrayList;

public class FiltroUbicacion extends Filtro {
	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos, Object criterio) {
		if(criterio!=null) {asientos.removeIf(asiento -> asiento.getUbicacion().equals(criterio));}		
	}

	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos, Object criterio1, Object criterio2) {
		// TODO Auto-generated method stub
		
	}
}