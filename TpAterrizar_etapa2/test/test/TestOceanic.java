package test;

import org.junit.*;
import modelo.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.util.ArrayList;

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
	public void convertirAsientoDTOAAsiento_DeModoCorrecto() throws Exception {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic aerolinea = new AerolineaOceanic(mockOceanic);
		Fecha fecha = new Fecha();
		Asiento asientoEsperado = new Asiento("EC0344-42", 1000D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.VENTANILLA, false, fecha.convertirALatinoamericano("20/06/19"), fecha.convertirALatinoamericano("21/06/19"), aerolinea);
		AsientoDTO dto = new AsientoDTO("EC0344",42,fecha.convertirALatinoamericano("20/06/19"),null,1000D,TipoClaseAsiento.TURISTA,TipoUbicacionAsiento.VENTANILLA,fecha.convertirALatinoamericano("21/06/19"));
		Asiento asiento = (Asiento) aerolinea.convertirAsientoDTOAAsiento(dto);
		System.out.print(asientoEsperado);
		System.out.print(asiento);
		System.out.println();
		System.out.print(asientoEsperado.getCodigoAsiento());
		System.out.print(asiento.getCodigoAsiento());
		System.out.println();
		System.out.print(asientoEsperado.getDestino());
		System.out.print(asiento.getDestino());
		System.out.println();
		System.out.print(asientoEsperado.getClase());
		System.out.print(asiento.getClase());
		System.out.println();
		System.out.print(asientoEsperado.getPrecio());
		System.out.print(asiento.getPrecio());
		System.out.println();
		System.out.print(asientoEsperado.getFechallegada());
		System.out.print(asiento.getFechallegada());
		System.out.println();
		System.out.print(asientoEsperado.getFechaSalida());
		System.out.print(asiento.getFechaSalida());
		System.out.println();
		System.out.print(asientoEsperado.getEstadoReservado());
		System.out.print(asiento.getEstadoReservado());
		System.out.println();
		System.out.print(asientoEsperado.getAerolinea());
		System.out.print(asiento.getAerolinea());
		System.out.println();
		Assert.assertEquals("No se convirtio el asiento",asientoEsperado, asiento);		
	}
	@Test
	public void convertirAsientoDTOAAsiento_ConParametrosNulos() throws Exception {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic aerolinea = new AerolineaOceanic(mockOceanic);
		//Fecha fecha = new Fecha();
		//Asiento asientoEsperado = new Asiento(null,null,null,null,null,null,null,null);
		AsientoDTO dto = new AsientoDTO(null,0,null,null,null,null,null,null);
		Asiento asiento = aerolinea.convertirAsientoDTOAAsiento(dto);
		Assert.assertEquals("No se convirtio el asiento",null, asiento);
	}
}
