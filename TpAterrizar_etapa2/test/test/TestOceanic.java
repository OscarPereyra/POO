package test;

import modelo.IAerolineaOceanic;
import org.junit.Test;
import org.mockito.*;
public class TestOceanic {
	private IAerolineaOceanic oceanicMock;
	private IAerolineaOceanic oceanic;

	/*@Before
	public void setUp() {
		IAerolineaOceanic oceanicMock = Mockito.mock(IAerolineaOceanic.class);
	}*/
	@Test
	public void asientosDisponiblesPorOrigen_recibedestinoLRy1006porFecha() {
		
		IAerolineaOceanic oceanicMock = Mockito.mock(IAerolineaOceanic.class);
		Mockito.when(oceanicMock.asientosDisponiblesParaOrigen("SLA", "20/06/19")).thenReturn(null);
		
	}

	

}
