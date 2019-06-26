package viewModel;

import java.util.ArrayList;

import modelo.Asiento;
import modelo.Usuario;

public class ReservasViewModel {
	private Usuario usuario;
	
	public ReservasViewModel(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
