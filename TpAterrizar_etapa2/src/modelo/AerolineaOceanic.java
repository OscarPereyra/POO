package modelo;

import java.text.ParseException;
import java.util.ArrayList;

import excepciones.DestinosIgualesException;

public class AerolineaOceanic extends Aerolinea{
	public IAerolineaOceanic oceanic;
	
	public AerolineaOceanic(IAerolineaOceanic oceanic) {
		this.oceanic = oceanic;
		this.nombre = "Oceanic";
	}
	public String formatoCiudad(String ciudad) {
		String codigo="";
		if((ciudad.length()==2)&&(ciudad != "LA") ) {
			codigo = ciudad.concat("_");
		}else if(ciudad == "LA") {
			codigo = "SLA";
		}
		return codigo;
	}
	public ArrayList<Asiento> convertirListaAsientosDTOaAsientos(ArrayList<AsientoDTO> disponibles) throws ParseException {
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		disponibles.forEach(asiento -> {
			try {
				asientosDisponibles.add(asiento.convertirAsientoDTOAAsiento(this));
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
	public void reservar(Usuario usuario, Asiento asiento) {
		System.out.println("entro en reservar");
		System.out.println("estado reservado? "+oceanic.estaReservado(asiento.getVuelo(),asiento.numeroAsiento()));
		System.out.println("estado reservar? "+oceanic.reservar(usuario.getDNI(), asiento.getVuelo(), asiento.numeroAsiento()));
		if(oceanic.estaReservado(asiento.getVuelo(),asiento.numeroAsiento())) {
			asientosSobreReservados.add(new AsientoReservado(asiento,usuario));
			System.out.println("fue a sobrereserva");
		}else {
			System.out.println("Entro al else");
			if(oceanic.reservar(usuario.getDNI(), asiento.getVuelo(), asiento.numeroAsiento())) {
				System.out.println("intento de reserva");
				asiento.setEstadoReservado(true);
			}
		}
	}
	@Override
	public void comprar(Usuario usuario, Asiento asiento) {
		if(oceanic.comprarSiHayDisponibilidad(usuario.getDNI(), asiento.getVuelo(),asiento.numeroAsiento())) {
			limpiarSobreReservas(asiento.getCodigoAsiento());
		}
	}
	@Override
	public ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) throws ParseException, DestinosIgualesException{
		validarParametros(busqueda);
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		ArrayList<AsientoDTO> disponibles = new ArrayList<AsientoDTO>();
		if(busquedaSoloPorOrigen(busqueda)) {
			String origen = formatoCiudad(busqueda.getOrigen());
			disponibles = oceanic.asientosDisponiblesParaOrigen(origen, busqueda.getFechaSalida());
			asientosDisponibles = convertirListaAsientosDTOaAsientos(disponibles);			
		}else if(busquedaPorOrigenDestino(busqueda)) {
			String origen = formatoCiudad(busqueda.getOrigen());
			String destino = formatoCiudad(busqueda.getDestino());
			disponibles = oceanic.asientosDisponiblesParaOrigenYDestino(origen, busqueda.getFechaSalida(), destino);
			asientosDisponibles = convertirListaAsientosDTOaAsientos(disponibles);
		}		
		return asientosDisponibles;
	}
	@Override
	public void transferirReserva(String codigoAsiento) {
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
