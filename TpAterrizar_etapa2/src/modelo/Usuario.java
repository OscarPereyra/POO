package modelo;

public abstract class Usuario {
	abstract boolean esVip();
	abstract boolean esPago();
	abstract void comprar(Double monto);
}
