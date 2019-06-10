package modelo;

import java.util.ArrayList;

public class FiltroPrecio extends Filtro {

	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos, Object precioMin, Object precioMax) {
		if ((Double)precioMin<(Double)precioMax) {
			asientos.removeIf(asiento -> noEstaEnRango(asiento.getPrecio(),precioMin,precioMax));
		}
	}
	private boolean noEstaEnRango(Double precio, Object precioMin, Object precioMax) {
		return ((Double)precioMin<precio && precio<(Double)precioMax);
	}
	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos, Object criterio) {
		// TODO Auto-generated method stub
		
	}
	
}