package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]
public class TestReservaLanchita {
	@Test
	public void reservarAsiento_SeReservaUnAsientoCorrectamente() {
		System.out.println("Empezo");
		Buscador buscador = new Buscador();
		System.out.println("Creo el buscador");
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		System.out.println("Mockeo lanchita");
		ArrayList<ArrayList<String>> asientosLanchita = lanchitaAsientos();
		when(mockLanchita.asientosDisponibles(anyString(), anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn(asientosLanchita);
		System.out.println("Agrego comportamiento");
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		AerolineaLanchita aerolinea = new AerolineaLanchita();
		Busqueda busqueda = new Busqueda("", "", "", "", "","", TipoClaseAsiento.PRIMERA, TipoUbicacionAsiento.PASILLO);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(aerolinea, usuario, busqueda);
		System.out.println(asientosEncontrados);
		buscador.reservarAsiento(asientosEncontrados.get(0), usuario, aerolinea);
		AsientoReservado primerAsientoReservado = aerolinea.getAsientosReservados().get(0);
		
		Assert.assertTrue("El usuario no pudo reservar el asiento",primerAsientoReservado.getAsiento().equals(asientosEncontrados.get(0)));
	}
	
	private ArrayList<ArrayList<String>> lanchitaAsientos(){
		ArrayList<ArrayList<String>> asientosLanchita = new ArrayList<ArrayList<String>>();
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-42","565.60","P","P","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","365.60","T","E","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","840.50","E","C","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","1200.30","P","P","D"));
		return asientosLanchita;
	}
}
