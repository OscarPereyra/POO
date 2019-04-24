package modelo;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import modelo.ListaDeCorreo;

public class TestCorreo {
	@Test
	public void enviarMensaje_QueEnvieUnMensaje() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.enviarMensaje("testmail@undav.com","Test","Texto de prueba");
		assert.assertTrue(lista.contieneMensaje(mensajito));
	}
}
