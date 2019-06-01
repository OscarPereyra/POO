package modelo;

public class UsuarioNoPago extends Usuario {
	private String nombre;
	private String apellido;
	private int DNI;
	private double recargo = 20;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public double getRecargo() {
		return recargo;
	}
	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}
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
	}
}
