package modelo;

public class AsientoLanchitaNoDisponibleException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public AsientoLanchitaNoDisponibleException(String texto) {
		mensaje = texto;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
