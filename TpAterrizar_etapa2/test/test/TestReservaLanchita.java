package test;

import org.junit.*;
import modelo.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.util.ArrayList;

//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class TestReservaLanchita {
		
	@Test
	public void reservarAsiento_SeReservaUnAsientoCorrectamente() throws ParseException {
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = new Buscador(aerolineas);
		ArrayList<ArrayList<String>> asientosLanchita = lanchitaAsientos();
		when(mockLanchita.asientosDisponibles(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosLanchita);
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		ArrayList<TipoClaseAsiento> clases = new ArrayList<TipoClaseAsiento>();
		clases.add(TipoClaseAsiento.PRIMERA);
		Busqueda busqueda = new Busqueda("", "", "", "", "","", clases, TipoUbicacionAsiento.PASILLO,null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario, busqueda);
		usuario.reservarAsiento(asientosEncontrados.get(0));
		Asiento primerAsientoReservado = usuario.getReservas().get(0);		
		Assert.assertTrue("El usuario no pudo reservar el asiento",primerAsientoReservado.equals(asientosEncontrados.get(0)));
	}
	//deveriamos probar que el primer asiento reservado es igual a nulo pero el test me queda en azul no en verde
	@Test
	public void reservarAsiento_SeintentaReservarPeroNoSeObtieneNingunAsiento() throws Exception {
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = new Buscador(aerolineas);
		ArrayList<ArrayList<String>> asientosLanchita = lanchitaAsientos();
		when(mockLanchita.asientosDisponibles(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosLanchita);
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		ArrayList<TipoClaseAsiento> clases = new ArrayList<TipoClaseAsiento>();
		clases.add(TipoClaseAsiento.PRIMERA);
		Busqueda busqueda = new Busqueda("","","","","","",null,null,null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario, busqueda);
		usuario.reservarAsiento(asientosEncontrados.get(0));
		Asiento primerAsientoReservado = usuario.getReservas().get(0);		
		Assert.assertTrue("El usuario no pudo reservar el asiento",primerAsientoReservado.equals(asientosEncontrados.get(0)));
	}
	
	@Test
	public void reservarAsiento_2PersonasReservanElMismoAsientoYSeSobrereserva() throws Exception {
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = new Buscador(aerolineas);
		ArrayList<ArrayList<String>> asientosLanchita = lanchitaAsientos();
		when(mockLanchita.asientosDisponibles(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosLanchita);
		UsuarioEstandar usuario1 = new UsuarioEstandar("Alejando","40135297");
		UsuarioEstandar usuario2 = new UsuarioEstandar("Pepito","80135297");
		ArrayList<TipoClaseAsiento> clases = new ArrayList<TipoClaseAsiento>();
		clases.add(TipoClaseAsiento.PRIMERA);
		Busqueda busqueda = new Busqueda("","","","","","",null,null,null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario1, busqueda);
		usuario1.reservarAsiento(asientosEncontrados.get(0));
		usuario2.reservarAsiento(asientosEncontrados.get(0));
		Asiento primerAsientoReservado = aerolineaLanchita.getAsientosReservados().get(0).getAsiento();
		Assert.assertTrue("El usuario no pudo reservar el asiento",primerAsientoReservado.equals(asientosEncontrados.get(0)));
	}
	
	@Test
	public void reservarAsiento_CaeUnaReservaYSeTransfiereCorrectamente() throws Exception {
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = new Buscador(aerolineas);
		ArrayList<ArrayList<String>> asientosLanchita = lanchitaAsientos();
		when(mockLanchita.asientosDisponibles(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosLanchita);
		UsuarioEstandar usuario1 = new UsuarioEstandar("Alejando","40135297");
		UsuarioEstandar usuario2 = new UsuarioEstandar("Pepito","80135297");
		ArrayList<TipoClaseAsiento> clases = new ArrayList<TipoClaseAsiento>();
		clases.add(TipoClaseAsiento.PRIMERA);
		Busqueda busqueda = new Busqueda("","","","","","",null,null,null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario1, busqueda);
		usuario1.reservarAsiento(asientosEncontrados.get(0));
		usuario2.reservarAsiento(asientosEncontrados.get(0));
		buscador.transferirReserva("EC0344-42");
		Assert.assertTrue("El usuario no pudo reservar el asiento",!usuario2.getReservas().isEmpty());
	}
	
	@Test
	public void reservarAsiento_CompraAsientoReservadoYCaenTodasLasReservas() throws Exception {
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = new Buscador(aerolineas);
		ArrayList<ArrayList<String>> asientosLanchita = lanchitaAsientos();
		when(mockLanchita.asientosDisponibles(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosLanchita);
		UsuarioEstandar usuario1 = new UsuarioEstandar("Alejando","40135297");
		UsuarioEstandar usuario2 = new UsuarioEstandar("Pepito","80135297");
		UsuarioEstandar usuario3 = new UsuarioEstandar("Jorgito","50135297");
		ArrayList<TipoClaseAsiento> clases = new ArrayList<TipoClaseAsiento>();
		clases.add(TipoClaseAsiento.PRIMERA);
		Busqueda busqueda = new Busqueda("","","","","","",null,null,null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario1, busqueda);
		usuario1.reservarAsiento(asientosEncontrados.get(0));
		usuario2.reservarAsiento(asientosEncontrados.get(0));
		usuario3.reservarAsiento(asientosEncontrados.get(0));
		usuario1.comprar(asientosEncontrados.get(0));
		Assert.assertTrue("No se pudo transferir la reserva",aerolineaLanchita.getAsientosReservados().isEmpty());
	}
	
	private ArrayList<ArrayList<String>> lanchitaAsientos(){
		ArrayList<ArrayList<String>> asientosLanchita = new ArrayList<ArrayList<String>>();
		/*asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-42","565.60","P","P","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","365.60","T","E","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","840.50","E","C","D"));
		asientosLanchita.add((ArrayList<String>) Arrays.asList("EC0344-66","1200.30","P","P","D"));*/
		ArrayList<String> asiento1 = new ArrayList<String>();
		ArrayList<String> asiento2 = new ArrayList<String>();
		
		asiento1.add("EC0344-42");
		asiento1.add("56500.60");
		asiento1.add("P");
		asiento1.add("P");
		asiento1.add("D");
		asiento1.add("18/06/2019");
		asiento1.add("25/06/2019");
		
		asiento2.add("EC0344-66");
		asiento2.add("12000.30");
		asiento2.add("P");
		asiento2.add("P");
		asiento2.add("D");
		asiento2.add("18/06/2019");
		asiento2.add("25/06/2019");

		asientosLanchita.add(asiento1);
		asientosLanchita.add(asiento2);
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