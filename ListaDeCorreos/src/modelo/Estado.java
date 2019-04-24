package modelo;

public abstract class Estado {
	private MailSender mailSender = new MailSender();
	
	public abstract void enviarMensaje(ListaDeCorreo lista, Correo correo);
	public abstract void suscribirse(ListaDeCorreo lista, String mail);
}
