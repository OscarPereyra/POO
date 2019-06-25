package modelo;

import java.util.ArrayList;

public abstract class Usuario {
	protected String nombre;
	protected String apellido;
	protected String DNI;
	protected ArrayList<Asiento> compras;
	protected ArrayList<Asiento> reservas;
	protected ArrayList<Busqueda> busquedas;
	abstract boolean esVip();
	abstract boolean esPago();
	abstract void comprar(Asiento asiento)throws Exception;
	abstract void reservarAsiento(Asiento asiento);
	abstract Double getRecargoUsuario();
	public void agregarBusqueda(Busqueda busqueda) {
		busquedas.add(busqueda);
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	public ArrayList<Asiento> getCompras() {
		return compras;
	}
	public ArrayList<Asiento> getReservas() {
		return reservas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void agregarReservado(Asiento asiento) {
		compras.add(asiento);
	}
}
