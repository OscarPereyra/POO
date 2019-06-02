package modelo;

public class UsuarioEstandar extends Usuario {
	private double montoTotalCompras = 0;
	public UsuarioEstandar(String DNI){
		this.DNI = DNI;
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
