package sistemaSube;

import excepciones.ExcepcionSaldoInsuficiente;

public class tarjeta {
	private double saldo;
	private String usuario;
	private int id;
	private char estado;
	private double saldoNegativo = 20;
	
	public tarjeta(String usuario, int id) {
		super();
		this.saldo = 0;
		this.usuario = usuario;
		this.id = id;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void cargarSaldo(double carga) {
		this.saldo += carga;
	}
	public boolean puedePagar(double monto) {
		return ((saldo-monto)>=-saldoNegativo);
	}
	public void pagar(double monto) {
		if(puedePagar(monto)) {
			saldo -= monto;
		}
		else {
			throw  new ExcepcionSaldoInsuficiente();
		}
	}
	public static void main(String[] args) {
		tarjeta tarjetita = new tarjeta("alejandro",123);
		tarjetita.cargarSaldo(800);
		System.out.print("Su saldo es: " + tarjetita.getSaldo());
	}
}

