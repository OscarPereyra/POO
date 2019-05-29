package modelo;

public class UsuarioNoPago extends Usuario {
	private String nombre;
	private String apellido;
	private int DNI;
	private int montoTotalCompras=0;
	public UsuarioNoPago() {
		
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
		montoTotalCompras +=monto;
	}
}
