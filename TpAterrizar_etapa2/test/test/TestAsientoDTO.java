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
		AsientoDTO dto = new AsientoDTO("EC0344",42,fecha.convertirALatinoamericano("20/06/19"),"",1000D,TipoClaseAsiento.TURISTA,TipoUbicacionAsiento.VENTANILLA,fecha.convertirALatinoamericano("21/06/19"),"");
		Asiento asiento = dto.convertirAsientoDTOAAsiento(dto,aerolinea);
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

}
