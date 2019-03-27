package sistemaSube;

import org.junit.Test;

import excepciones.ExcepcionSaldoInsuficiente;

import org.junit.Assert;

public class TarjetaTest {
	@Test
	public void setSaldo_UnaTarjetaSeCargaCon200Pesos() {
		tarjeta miTarjeta = new tarjeta("ale",123);
		miTarjeta.cargarSaldo(200);
		Assert.assertEquals("La tarjeta no se cargo con 200 pesos", 200, miTarjeta.getSaldo(), 0.01);
	}
	@Test
	public void puedePagar_NoTieneSaldoSuficienteYQuierePagar50Pesos() {
		tarjeta unaTarjeta = new tarjeta("pepe",123);
		Assert.assertFalse(unaTarjeta.puedePagar(50));
	}
	@Test
	public void puedePagar_TieneSaldoSuficienteYQuierePagar20Pesos() {
		tarjeta unaTarjeta = new tarjeta("pepe",123);
		unaTarjeta.cargarSaldo(50);
		Assert.assertTrue(unaTarjeta.puedePagar(20)); 
	}
	@Test
	public void puedePagar_TieneSaldoJustoYQuierePagar20Pesos() {
		tarjeta unaTarjeta = new tarjeta("pepe",123);
		Assert.assertTrue(unaTarjeta.puedePagar(20)); 
	}
	@Test(expected = ExcepcionSaldoInsuficiente.class)
	public void pagar_NoTieneSaldoYPaga150Pesos() {
		tarjeta unaTarjeta = new tarjeta("pepe",123);
		unaTarjeta.cargarSaldo(120);
		unaTarjeta.pagar(150);
	}
	@Test(expected = ExcepcionSaldoInsuficiente.class)
	public void pagar_NoTieneSaldoYPaga20PesosCon1Centavo() {
		tarjeta unaTarjeta = new tarjeta("pepe",123);
		unaTarjeta.pagar(20.01);
	}
	@Test
	public void pagar_TieneSaldoYPaga19PesosCon99Centavos() {
		tarjeta unaTarjeta = new tarjeta("pepe",123);
		unaTarjeta.pagar(19.99);
	}
}
