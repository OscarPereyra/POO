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
	public void comprar(Asiento asiento)throws Exception {
		asiento.getAerolinea().comprar(this,asiento);
	}
	@Override
	public void reservarAsiento(Asiento asiento) {
		asiento.getAerolinea().reservar(this, asiento);
	}
	@Override
	Double getRecargoUsuario() {
		return 20.0;
	}
}
