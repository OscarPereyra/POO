package modelo;

public class AsientoReservado {
	private Asiento asiento;
	private Usuario usuario;
	public AsientoReservado(Asiento asiento,Usuario usuario) {
		this.asiento = asiento;
		this.usuario = usuario;
	}
	public Asiento getAsiento() {
		return asiento;
	}
	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
