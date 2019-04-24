package modelo;

public class EstadoAbierto extends Estado {

	@Override
	public void enviarMensaje(ListaDeCorreo lista, Correo correo) {
		lista.getListaDeCorreos().stream().forEach((persona) -> mailSender.enviarMail(persona,correo));
	}

	@Override
	public void suscribirse(ListaDeCorreo lista, String mail) {
		lista.getListaDeCorreos().add(mail);
	}
	
	
}
