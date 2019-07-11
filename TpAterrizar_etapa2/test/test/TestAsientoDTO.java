package test;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;

import modelo.AerolineaOceanic;
import modelo.Asiento;
import modelo.AsientoDTO;
import modelo.Fecha;
import modelo.IAerolineaOceanic;
import modelo.TipoClaseAsiento;
import modelo.TipoUbicacionAsiento;

public class TestAsientoDTO {
	@Test
	public void convertirAsientoDTOAAsiento_DeModoCorrecto() throws Exception {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic aerolinea = new AerolineaOceanic(mockOceanic);
		Fecha fecha = new Fecha();
		Asiento asientoEsperado = new Asiento("EC0344-42", 1000D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.VENTANILLA, false, fecha.convertirALatinoamericano("20/06/19"), fecha.convertirALatinoamericano("21/06/19"), aerolinea);
		AsientoDTO dto = new AsientoDTO("EC0344",42,fecha.convertirALatinoamericano("20/06/19"),"",1000D,TipoClaseAsiento.TURISTA,TipoUbicacionAsiento.VENTANILLA,fecha.convertirALatinoamericano("21/06/19"),"",false,false);
		Asiento asiento = dto.convertirAsientoDTOAAsiento(aerolinea);
		Assert.assertEquals("No se convirtio el asiento",asientoEsperado.getCodigoAsiento(), asiento.getCodigoAsiento());		
	}

}
