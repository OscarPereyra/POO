package modelo;

import java.util.ArrayList;

public abstract class Usuario {
	private ArrayList<Busqueda> busquedas;
	abstract boolean esVip();
	abstract boolean esPago();
	abstract void comprar(Double monto);
	
	public Usuario() {
		super();
		this.busquedas = new ArrayList<Busqueda>();
	}
	public void agregarBusqueda(Busqueda busqueda) {
		busquedas.add(busqueda);
	}
}
