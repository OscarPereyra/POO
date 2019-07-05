package dummys;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.AsientoDTO;
import modelo.Fecha;
import modelo.TipoClaseAsiento;
import modelo.TipoUbicacionAsiento;

public class OceanicDummy {
	private ArrayList<AsientoDTO> asientos;
	private Fecha fecha = new Fecha();
	
	public OceanicDummy() throws ParseException
	{
		this.asientos = new ArrayList<AsientoDTO>();
		crearVuelo("123");
        crearVuelo("753");
        crearVuelo("954");
        crearVuelo("742");
		
	}
	private void crearVuelo(String codigoVuelo) throws ParseException
	{
		for(int nAsiento = 1; nAsiento <= 300 ; nAsiento++)
        {
        	for(nAsiento = 1; nAsiento <= 48 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 35000.0D, TipoClaseAsiento.PRIMERA, TipoUbicacionAsiento.VENTANILLA, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 2; nAsiento <= 48 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 35000.0D, TipoClaseAsiento.PRIMERA, TipoUbicacionAsiento.CENTRO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
          		asientos.add(asiento);
          	}
        	for(nAsiento = 3; nAsiento <= 48 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 35000.0D, TipoClaseAsiento.PRIMERA, TipoUbicacionAsiento.PASILLO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
          		asientos.add(asiento);
          	}
        	for(nAsiento = 49; nAsiento <= 198 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.VENTANILLA, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 50; nAsiento <= 198 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.CENTRO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 51; nAsiento <= 198 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.PASILLO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 199; nAsiento <= 300 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.EJECUTIVA, TipoUbicacionAsiento.VENTANILLA, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 200; nAsiento <= 300 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.EJECUTIVA, TipoUbicacionAsiento.CENTRO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 201; nAsiento <= 300 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0 "+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.EJECUTIVA, TipoUbicacionAsiento.PASILLO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}		          
          }
	}

}
