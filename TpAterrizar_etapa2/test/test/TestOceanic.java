package test;

import modelo.AsientoDTO;
import modelo.IAerolineaOceanic;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.*;

import junit.framework.Assert;
public class TestOceanic {
	
	/*@Before
	public void setUp() {
		IAerolineaOceanic oceanicMock = Mockito.mock(IAerolineaOceanic.class);
	}*/
	@Test
	public void asientosDisponiblesPorOrigen_recibedestinoLRy2006porFecha() {
		
		IAerolineaOceanic oceanicMock = Mockito.mock(IAerolineaOceanic.class);
		Mockito.when(oceanicMock.asientosDisponiblesParaOrigen("SLA", "20/06/19")).thenReturn(new ArrayList<AsientoDTO>());
		Assert.assertNotNull(oceanicMock.asientosDisponiblesParaOrigen("SLA", "20/06/19"));
			
	}

	

}
