package viewModel;

import java.util.ArrayList;
import modelo.*;

public class ComprasViewModel {
	private Usuario usuario;
	private ArrayList<Asiento> asientos;
	
	public ComprasViewModel(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
