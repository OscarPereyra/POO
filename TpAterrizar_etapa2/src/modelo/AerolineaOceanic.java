package modelo;

import java.text.ParseException;
import java.util.ArrayList;

public class AerolineaOceanic extends Aerolinea{
	IAerolineaOceanic oceanic;
	
	public String formatoCiudad(String ciudad) {
		String codigo="";
		if((ciudad.length()==2)&&( ciudad.toCharArray()[2] != '_') ) {
			codigo = ciudad.concat("_");
		}else if(ciudad == "LA") {
			codigo = "SLA";
		}
		return codigo;
	}
	private Asiento convertir(AsientoDTO asientoDTO) throws ParseException {
		String codigoAsiento = asientoDTO.getCodigoVuelo().concat(Integer.toString(asientoDTO.getNumeroAsiento()));
		return new Asiento(codigoAsiento,asientoDTO.getPrecio(),asientoDTO.getClase(),asientoDTO.getUbicacion(),false,fecha.convertirALatinoamericano(asientoDTO.getFechaSalida()),asientoDTO.getFechaLlegada(),this);		
	}
	private ArrayList<Asiento> convertirLista(ArrayList<AsientoDTO> disponibles) throws ParseException {
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		disponibles.forEach(asiento -> {
			try {
				asientosDisponibles.add(convertir(asiento));
			} catch (ParseException e) {
				System.out.println("Error al convertir");
			}
		});
		return asientosDisponibles;
	}
	private boolean busquedaSoloPorOrigen(Busqueda busqueda) {
		return ((busqueda.getOrigen()!=null) && (busqueda.getFechaSalida()!=null) && (busqueda.getDestino()==null));
	}
	private boolean busquedaPorOrigenDestino(Busqueda busqueda) {
		return ((busqueda.getOrigen()!=null) && (busqueda.getFechaSalida()!=null) && (busqueda.getDestino()!=null));
	}
	@Override
	void reservar(Usuario usuario, Asiento asiento) {
		if(oceanic.estaReservado(asiento.getVuelo(),asiento.numeroAsiento())) {
			asientosSobreReservados.add(new AsientoReservado(asiento,usuario));
		}else {
			if(oceanic.reservar(usuario.getDNI(), asiento.getVuelo(), asiento.numeroAsiento())) {
				asiento.setEstadoReservado(true);
			}
		}
	}
	@Override
	void comprar(Usuario usuario, Asiento asiento) {
		if(oceanic.comprarSiHayDisponibilidad(usuario.getDNI(), asiento.getVuelo(),asiento.numeroAsiento())) {
			limpiarSobreReservas(asiento.getCodigoAsiento());
		}
	}
	@Override
	ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) throws ParseException {
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		ArrayList<AsientoDTO> disponibles = null;
		if(busquedaSoloPorOrigen(busqueda)) {
			String origen = formatoCiudad(busqueda.getOrigen());
			disponibles = oceanic.asientosDisponiblesParaOrigen(origen, busqueda.getFechaSalida());
			asientosDisponibles = convertirLista(disponibles);			
		}else if(busquedaPorOrigenDestino(busqueda)) {
			String origen = formatoCiudad(busqueda.getOrigen());
			String destino = formatoCiudad(busqueda.getDestino());
			disponibles = oceanic.asientosDisponiblesParaOrigenYDestino(origen, busqueda.getFechaSalida(), destino);
			asientosDisponibles = convertirLista(disponibles);
		}		
		return asientosDisponibles;
	}
	@Override
	void transferirReserva(String codigoAsiento) {
		ArrayList<AsientoReservado> reservasFiltradas = (ArrayList<AsientoReservado>) asientosSobreReservados.stream().filter(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento));
		String dni = reservasFiltradas.get(0).getUsuario().getDNI();
		String vuelo = reservasFiltradas.get(0).getAsiento().getVuelo();
		int asiento = reservasFiltradas.get(0).getAsiento().numeroAsiento();
		if(!reservasFiltradas.isEmpty()) {
			oceanic.reservar(dni, vuelo, asiento);
			asientosSobreReservados.remove(reservasFiltradas.get(0));
		}
	}
	
}
