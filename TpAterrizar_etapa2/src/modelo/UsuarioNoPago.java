package modelo;

public class UsuarioNoPago extends Usuario {
	public UsuarioNoPago(String DNI) {
		this.DNI = DNI;
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
