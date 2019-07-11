package excepciones;

public class AsientoLanchitaNoDisponibleException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AsientoLanchitaNoDisponibleException(String texto) {
		super(texto);
	}
}
