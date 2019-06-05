package modelo;

import java.util.ArrayList;

public class FiltroClase extends Filtro {

	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos,Object criterio) {
			if(criterio!=null) {asientos.removeIf(asiento -> asiento.getClase().equals(criterio));}
		}

	}