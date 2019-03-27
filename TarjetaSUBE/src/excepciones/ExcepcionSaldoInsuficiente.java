package excepciones;

public class ExcepcionSaldoInsuficiente extends RuntimeException {
	public ExcepcionSaldoInsuficiente() {
		super("Saldo insuficiente");
	}
}
