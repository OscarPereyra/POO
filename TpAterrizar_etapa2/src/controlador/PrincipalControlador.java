package controlador;

import viewModel.*;

public class PrincipalControlador {
	private PrincipalViewModel modelo;
	
	public PrincipalControlador() {
		this.modelo = new PrincipalViewModel();
	}

	public PrincipalViewModel getModelo() {
		return modelo;
	}

	public void setModelo(PrincipalViewModel modelo) {
		this.modelo = modelo;
	}
}
