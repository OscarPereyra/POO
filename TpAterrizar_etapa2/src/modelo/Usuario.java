package modelo;

import java.util.ArrayList;

public abstract class Usuario {
	protected String nombre;
	protected String apellido;
	protected String DNI;
	protected ArrayList<Busqueda> busquedas;
	abstract boolean esVip();
	abstract boolean esPago();
	abstract void comprar(Double monto);
	
	public void agregarBusqueda(Busqueda busqueda) {
		busquedas.add(busqueda);
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
}
