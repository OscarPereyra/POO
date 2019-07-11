package test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;

import dummys.OceanicDummy;

import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.*;

// retorno lanchita [["EC0344-42","565.60","P","P","D"], ["EC0344-66","365.60","T","E","D"], … ]
//asiento
////String codigoAsiento,Double precio, clase, ubicacion,Boolean , fechaSalida, fechaLlegada, aerolinea
//asientoDTO
////String codigoVuelo, int numeroAsiento, Date fechaSalida, horaSalida, precio,clase, ubicacion, Date fechaLlegada
public class TestOceanic {	
	
	@Test
	public void formatoCiudad_RecibeLAYRetornaSLA() {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic aerolinea = new AerolineaOceanic(mockOceanic);
		String ciudadEnviada = aerolinea.formatoCiudad("LA");
		String ciudadEsperada = "SLA";
		Assert.assertEquals("No devuelve lo esperado", ciudadEsperada, ciudadEnviada);
	}
	@Test
	public void formatoCiudad_RecibeLRYRetornaLR_() {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic aerolinea = new AerolineaOceanic(mockOceanic);
		String ciudadEnviada = aerolinea.formatoCiudad("LR");
		String ciudadEsperada = "LR_";
		Assert.assertEquals("No devuelve lo esperado", ciudadEsperada, ciudadEnviada);
	}
	@Test
	public void reservar_() throws ParseException {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic oceanic = new AerolineaOceanic(mockOceanic);
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		//Fecha fecha = new Fecha();
		OceanicDummy asientosOceanic = new OceanicDummy();
		System.out.println(asientosOceanic);
		System.out.println(asientosOceanic.getAsientos().size());
		AsientoDTO dto = asientosOceanic.getAsiento("EC0742",42);
		System.out.println(dto);
		Asiento asientoReserva = dto.convertirAsientoDTOAAsiento(oceanic);
		System.out.println(asientoReserva.getCodigoAsiento());
		//Asiento asientoReserva = dto.convertirAsientoDTOAAsiento(asientosOceanic.getAsiento("EC0344",42), oceanic);
		//Asiento asientoReserva = ((OceanicDummy) asientosOceanic).getAsiento("EC0344-",42).convertirAsientoDTOAAsiento(asientoDTO, aerolinea);
		//Asiento asiento = new Asiento("EC0344-42", 1000D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.VENTANILLA, false, fecha.convertirALatinoamericano("20/06/19"), fecha.convertirALatinoamericano("21/06/19"), oceanic);
		when(mockOceanic.estaReservado(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(false);
		oceanic.reservar(usuario, asientoReserva);
		System.out.println(asientoReserva.getEstadoReservado());
		
		Assert.assertTrue("No se realizo la reserva", asientoReserva.getEstadoReservado());
	}
	@Test
	public void comprar_() throws ParseException {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic oceanic = new AerolineaOceanic(mockOceanic);
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		Fecha fecha = new Fecha();
		Asiento asiento = new Asiento("EC0344-42", 1000D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.VENTANILLA, false, fecha.convertirALatinoamericano("20/06/19"), fecha.convertirALatinoamericano("21/06/19"), oceanic);
		when(mockOceanic.comprarSiHayDisponibilidad(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(true);
		oceanic.comprar(usuario, asiento);
		Assert.assertTrue("No se realizo la compra", asiento.getEstadoReservado());
		
	}
}
