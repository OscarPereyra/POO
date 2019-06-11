package modelo;

import java.util.ArrayList;

public class FiltroUbicacion extends Filtro {
	private TipoUbicacionAsiento ubicacion;
	public void Filtro (TipoUbicacionAsiento ubicacion) {
		this.ubicacion = ubicacion;
	}
	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos) {
		if(ubicacion!=null) {asientos.removeIf(asiento -> asiento.getUbicacion().equals(ubicacion));}		
	}
}