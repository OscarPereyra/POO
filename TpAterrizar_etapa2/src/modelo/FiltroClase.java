package modelo;

import java.util.ArrayList;

public class FiltroClase extends Filtro {
	private ArrayList<TipoClaseAsiento> clases;
	public void Filtro (ArrayList<TipoClaseAsiento> clases) {
		this.clases = clases;
	}
	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos) {
			if(clases!=null) {asientos.removeIf(asiento -> !(clases.stream().allMatch(clase -> asiento.getClase().equals(clase))));}
	}			
}