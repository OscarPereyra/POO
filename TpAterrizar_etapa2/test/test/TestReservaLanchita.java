package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import modelo.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class TestReservaLanchita {
	
	//@Mock IAerolineaLanchita mockLanchita;
	
	/*@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}*/
	
	@Test
	public void reservarAsiento_SeReservaUnAsientoCorrectamente() {
		System.out.println("Entro al test");
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		System.out.println("Mockeo lanchita");
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = new Buscador(aerolineas);
		System.out.println("Creo el buscador");
		ArrayList<ArrayList<String>> asientosLanchita = lanchitaAsientos();
		System.out.println("Creo asientos");
		when(mockLanchita.asientosDisponibles(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(asientosLanchita);
		System.out.println("Agrego comportamiento");
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		ArrayList clases = new ArrayList();
		clases.add(TipoClaseAsiento.TURISTA);
		Busqueda busqueda = new Busqueda("", "", "", "", "","", clases, TipoUbicacionAsiento.PASILLO,null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario, busqueda);
		System.out.println(asientosEncontrados);
		usuario.reservarAsiento(asientosEncontrados.get(0));
		AsientoReservado primerAsientoReservado = aerolineaLanchita.getAsientosReservados().get(0);
		
		Assert.assertTrue("El usuario no pudo reservar el asiento",primerAsientoReservado.getAsiento().equals(asientosEncontrados.get(0)));
	}
	
	private ArrayList<ArrayList<String>> lanchitaAsientos(){
		ArrayList<ArrayList<String>> asientosLanchita = new ArrayList<ArrayList<String>>();
		/*asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-42","565.60","P","P","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","365.60","T","E","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","840.50","E","C","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","1200.30","P","P","D"));*/
		ArrayList<String> asiento1 = new ArrayList<String>();
		asiento1.add("EC0344-66");
		asiento1.add("565.60");
		asiento1.add("P");
		asiento1.add("P");
		asiento1.add("D");
		asientosLanchita.add(asiento1);
		return asientosLanchita;
	}
}

/*
@Test
public void asientosDisponiblesPorOrigen_recibedestinoLRy2006porFecha() {
	
	IAerolineaOceanic oceanicMock = Mockito.mock(IAerolineaOceanic.class);
	Mockito.when(oceanicMock.asientosDisponiblesParaOrigen("SLA", "20/06/19")).thenReturn(new ArrayList<AsientoDTO>());
	Assert.assertThat(oceanicMock.asientosDisponiblesParaOrigen("SLA", "20/06/19"));
		
}*/