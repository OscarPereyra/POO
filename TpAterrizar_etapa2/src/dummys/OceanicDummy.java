package dummys;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import modelo.Asiento;
import modelo.AsientoDTO;
import modelo.Fecha;
import modelo.IAerolineaOceanic;
import modelo.TipoClaseAsiento;
import modelo.TipoUbicacionAsiento;

public class OceanicDummy implements IAerolineaOceanic{
	private ArrayList<AsientoDTO> asientos;

	private Map<String, String> diccionarioDestinos;
	
	public ArrayList<AsientoDTO> getAsientos() {
		return asientos;
	}
	public void setAsientos(ArrayList<AsientoDTO> asientos) {
		this.asientos = asientos;
	}
	private Fecha fecha = new Fecha();
	
	public OceanicDummy() throws ParseException
	{

        this.diccionarioDestinos = new HashMap();
        diccionarioDestinos.put("ARG", "123");
        diccionarioDestinos.put("BRZ", "753");
        diccionarioDestinos.put("ESP", "954");
        diccionarioDestinos.put("COL", "742");
        
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
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 35000.0D, TipoClaseAsiento.PRIMERA, TipoUbicacionAsiento.VENTANILLA, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 2; nAsiento <= 48 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 35000.0D, TipoClaseAsiento.PRIMERA, TipoUbicacionAsiento.CENTRO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
          		asientos.add(asiento);
          	}
        	for(nAsiento = 3; nAsiento <= 48 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 35000.0D, TipoClaseAsiento.PRIMERA, TipoUbicacionAsiento.PASILLO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
          		asientos.add(asiento);
          	}
        	for(nAsiento = 49; nAsiento <= 198 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.VENTANILLA, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 50; nAsiento <= 198 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.CENTRO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 51; nAsiento <= 198 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.TURISTA, TipoUbicacionAsiento.PASILLO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 199; nAsiento <= 300 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.EJECUTIVA, TipoUbicacionAsiento.VENTANILLA, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 200; nAsiento <= 300 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.EJECUTIVA, TipoUbicacionAsiento.CENTRO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}
        	for(nAsiento = 201; nAsiento <= 300 ; nAsiento+=3)
          	{
        		AsientoDTO asiento = new AsientoDTO("EC0"+codigoVuelo, nAsiento, fecha.convertirALatinoamericano("18/06/2019"), "00:00", 14000.0D, TipoClaseAsiento.EJECUTIVA, TipoUbicacionAsiento.PASILLO, fecha.convertirALatinoamericano("25/06/2019"),"00:00");
        		asientos.add(asiento);
          	}		          
          }
	}
	@Override
	public ArrayList<AsientoDTO> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida) {
		return (ArrayList<AsientoDTO>) this.asientos
                .stream()
                .filter(asiento -> (asiento.getEstadoReservado()==false) &&(asiento.isEstadoCompra()==false))
                .collect(Collectors.toList());
	}
	@Override
	public ArrayList<AsientoDTO> asientosDisponiblesParaOrigenYDestino(String codigoOrigenOceanic, String fechaSalida,
			String codigoDestinoOceanic) {
		return (ArrayList<AsientoDTO>) this.asientos
                .stream()
                .filter(asiento -> ((asiento.getCodigoVuelo().substring(3,5)== codigoDestinoOceanic)&&(asiento.getEstadoReservado()==false)))
                .collect(Collectors.toList());
	}
	@Override
	public boolean estaReservado(String codigoDeVuelo, int numeroDeAsiento) {
		AsientoDTO asiento = this.getAsiento(codigoDeVuelo, numeroDeAsiento);
		return asiento.getEstadoReservado();
	}
	@Override
	public boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, int numeroDeAsiento) {
		AsientoDTO asiento = this.getAsiento(codigoVuelo, numeroDeAsiento);
		AsientoDTO compra = asiento;
		boolean operacion = false;
		if(!asiento.isEstadoCompra()) {
			this.asientos.remove(asiento);
			this.asientos.add(compra);
			operacion = true;
		}
		return operacion;
		
	}
	@Override
	public boolean reservar(String dni, String codigoVuelo, int numeroDeAsiento) {
		AsientoDTO asiento = this.getAsiento(codigoVuelo, numeroDeAsiento);
		AsientoDTO asientoReservado = asiento;
		asientoReservado.setEstadoReservado(true);
		boolean operacion = false;
		if(!asiento.getEstadoReservado()) {
			this.asientos.remove(asiento);
			this.asientos.add(asientoReservado);
			operacion = true;
		}
		return operacion;
	}
    private AsientoDTO getAsiento(String codigoAsiento, int numeroDeAsiento) {
        return this.asientos
                    .stream()
                    .filter(x ->  ( (x.getCodigoVuelo().equals(codigoAsiento)) && (x.getNumeroAsiento() == numeroDeAsiento)))
                    .collect(Collectors.toList()).get(0);
    }
}
