package dummys;

import java.util.ArrayList;

import modelo.AsientoDTO;

public class OceanicDummy {
	private ArrayList<AsientoDTO> asientos;
	
	public OceanicDummy()
	{
		this.asientos = new ArrayList<AsientoDTO>();
		
	}
	private void crearVuelo(int codigoVuelo)
	{
		for(int nAsiento=1;nAsiento<300;nAsiento++)
		{
			for(nAsiento=1;nAsiento<48;nAsiento+=3)
			{
				AsientoDTO asiento = new();
			}
		}
	}

}
