package modelo;

import java.util.ArrayList;

public class UsuarioEstandar extends Usuario {
	private double montoTotalCompras = 0;
	public UsuarioEstandar(String nombre,String DNI){
		this.nombre = nombre;
		this.DNI = DNI;
		this.busquedas = new ArrayList<Busqueda>();
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
	public void comprar(Double monto) {
		montoTotalCompras +=monto;
	}
}
