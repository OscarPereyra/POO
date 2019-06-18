package modelo;

import java.util.ArrayList;

public class UsuarioEstandar extends Usuario {
	private double montoTotalCompras = 0;
	public UsuarioEstandar(String nombre,String DNI){
		this.nombre = nombre;
		this.DNI = DNI;
		this.busquedas = new ArrayList<Busqueda>();
		this.compras = new ArrayList<Asiento>();
		this.reservas = new ArrayList<Asiento>();
	}
	@Override
	public boolean esVip() {
		return montoTotalCompras>100000;
	}
	@Override
	public boolean esPago() {
		return true;
	}
	@Override
	public void comprar(Asiento asiento)throws Exception {
		asiento.getAerolinea().comprar(this,asiento);
		montoTotalCompras += asiento.getPrecio();
		compras.add(asiento);
	}
	@Override
	public void reservarAsiento(Asiento asiento) {
		asiento.getAerolinea().reservar(this, asiento);
		reservas.add(asiento);
	}
	@Override
	Double getRecargoUsuario() {
		return 0.0;
	}
}
