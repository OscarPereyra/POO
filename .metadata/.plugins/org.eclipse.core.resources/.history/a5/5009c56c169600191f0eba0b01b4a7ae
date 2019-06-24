package modelo;

import java.util.ArrayList;

public class FiltroPrecio extends Filtro {
	private Double precioMin;
	private Double precioMax;
	public void Filtro (Double precioMin, Double precioMax) {
		this.precioMax= precioMax;
		this.precioMin= precioMin;
	}
	@Override
	public void aplicarFiltro(ArrayList<Asiento> asientos) {
		if ((Double)precioMin<(Double)precioMax) {
			asientos.removeIf(asiento -> noEstaEnRango(asiento.getPrecio(),precioMin,precioMax));
		}
	}
	private boolean noEstaEnRango(Double precio, Object precioMin, Object precioMax) {
		return ((Double)precioMin<precio && precio<(Double)precioMax);
	}	
}