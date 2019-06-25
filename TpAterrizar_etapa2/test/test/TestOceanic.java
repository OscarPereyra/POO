package test;

import org.junit.*;
import modelo.*;
import static org.mockito.Mockito.*;

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
}
