package test;

import modelo.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.mockito.*;

import org.junit.Assert;

// retorno lanchita [["EC0344-42","565.60","P","P","D"], ["EC0344-66","365.60","T","E","D"], … ]
//asiento
////String codigoAsiento,Double precio, clase, ubicacion,Boolean , fechaSalida, fechaLlegada, aerolinea
//asientoDTO
////String codigoVuelo, int numeroAsiento, Date fechaSalida, horaSalida, precio,clase, ubicacion, Date fechaLlegada
public class TestOceanic {	
	
	@Test
	public void formatoCiudad_RecibeLAYRetornaSLA() {
		AerolineaOceanic aerolinea = new AerolineaOceanic();
		String ciudadEnviada = aerolinea.formatoCiudad("LA");
		String ciudadEsperada = "SLA";
		Assert.assertEquals("No devuelve lo esperado", ciudadEsperada, ciudadEnviada);
	}
	public void formatoCiudad_RecibeLRYRetornaLR_() {
		AerolineaOceanic aerolinea = new AerolineaOceanic();
		String ciudadEnviada = aerolinea.formatoCiudad("LR");
		String ciudadEsperada = "LR_";
		Assert.assertEquals("No devuelve lo esperado", ciudadEsperada, ciudadEnviada);
	}
	public void convertirAsientoDTOAAsiento_DeModoCorrecto() throws Exception {
		AerolineaOceanic aerolinea = new AerolineaOceanic();
		Fecha fecha = new Fecha();
		Asiento asientoEsperado = new Asiento("EC0344-42", 1000D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.VENTANILLA, false, fecha.convertirALatinoamericano("20/06/19"), fecha.convertirALatinoamericano("21/06/19"), aerolinea);
		AsientoDTO dto = new AsientoDTO("EC0344",42,fecha.convertirALatinoamericano("20/06/19"),null,1000,TipoClaseAsiento.TURISTA,TipoUbicacionAsiento.VENTANILLA,fecha.convertirALatinoamericano("21/06/19"));
		Asiento asiento = aerolinea.convertirAsientoDTOAAsiento(dto);
		Assert.assertEquals(asientoEsperado, asiento);
	}
}
