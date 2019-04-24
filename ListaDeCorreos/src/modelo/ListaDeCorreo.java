package modelo;
import java.util.ArrayList;

public class ListaDeCorreo {
	private ArrayList<String> listaDeCorreos = new ArrayList<String>();
	private Estado estado;
	
	public void enviarMensaje(Correo correo) {
		estado.enviarMensaje(this,correo);
	}
	
	public void suscribirse(String correo) {
		estado.suscribirse(this, correo);
	}

	public ArrayList<String> getListaDeCorreos() {
		return listaDeCorreos;
	}

	public void setListaDeCorreos(ArrayList<String> listaDeCorreos) {
		this.listaDeCorreos = listaDeCorreos;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
