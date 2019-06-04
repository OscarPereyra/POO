package modelo;

import java.util.ArrayList;

public class UsuarioNoPago extends Usuario {
	public UsuarioNoPago(String nombre,String DNI) {
		this.nombre = nombre;
		this.DNI = DNI;
		this.busquedas = new ArrayList<Busqueda>();
	}
	@Override
	public boolean esVip() {
		return false;
	}
	@Override
	public boolean esPago() {
		return false;
	}
	@Override
	public void comprar(Double monto) {
	}
}
