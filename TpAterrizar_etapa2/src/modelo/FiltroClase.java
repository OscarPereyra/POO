package modelo;

import java.util.ArrayList;

public class FiltroClase extends Filtro {
	private ArrayList<TipoClaseAsiento> clases;
	public void Filtro (TipoClaseAsiento clase) {
		this.clase = clase;
	}
	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos) {
			if(clase!=null) {asientos.removeIf(asiento -> !(asiento.getClase().equals(clase)));}
	}			
}