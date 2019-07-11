package modelo;

import java.util.Date;
import java.util.stream.Collectors;

import excepciones.AsientoLanchitaNoDisponibleException;
import excepciones.DestinosIgualesException;

import java.text.ParseException;
import java.util.ArrayList;

public class AerolineaLanchita extends Aerolinea{
	public IAerolineaLanchita lanchita;
	public AerolineaLanchita(IAerolineaLanchita lanchita) {
		this.lanchita = lanchita;
		this.nombre = "Lanchita";
	}
	@Override
	public void reservar(Usuario usuario, Asiento asiento) {
		if(asiento.getEstadoReservado()) {
			asientosSobreReservados.add(new AsientoReservado(asiento,usuario));
		}
		else {
			try {
				lanchita.reservar(asiento.getCodigoAsiento(),usuario.getDNI());
				asiento.setEstadoReservado(true);
			} catch (AsientoLanchitaNoDisponibleException e) {
				System.out.println("Error para reservar");
			}
		}
	}
	@Override
	public void comprar(Usuario usuario, Asiento asiento) {
		try {
			lanchita.comprar(asiento.getCodigoAsiento());
			limpiarSobreReservas(asiento.getCodigoAsiento());
		}
		catch (AsientoLanchitaNoDisponibleException e) {
			System.out.println("Error al comprar el asiento");
		}
	}
	@Override
	public ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) throws DestinosIgualesException, ParseException {
		validarParametros(busqueda);
		ArrayList<ArrayList<String>> resultadoBusqueda = lanchita.asientosDisponibles(busqueda.getOrigen(),busqueda.getFechaSalida(),busqueda.getHoraSalida(),busqueda.getDestino(),busqueda.getFechaLlegada(),busqueda.getHoraLlegada());
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		resultadoBusqueda.forEach(asiento -> {
			try {
				asientosDisponibles.add(parsearAsiento(asiento));
			} catch (ParseException e) {
			}
		});
		return asientosDisponibles;
	}	
	@Override
	public void transferirReserva(String codigoAsiento) {
		ArrayList<AsientoReservado> reservasFiltradas = (ArrayList<AsientoReservado>) asientosSobreReservados.stream().filter(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento)).collect(Collectors.toList());
		if(!reservasFiltradas.isEmpty()) {
			try {
				lanchita.reservar(reservasFiltradas.get(0).getAsiento().getCodigoAsiento(), reservasFiltradas.get(0).getUsuario().getDNI());
			} catch (AsientoLanchitaNoDisponibleException e) {
				System.out.println("Error para reservar");
			}
			asientosSobreReservados.remove(reservasFiltradas.get(0));
		}
	}	
	@Override
	protected void limpiarSobreReservas(String codigoAsiento) {
		asientosSobreReservados.removeIf(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento));
	}	
	private Asiento parsearAsiento(ArrayList<String> asiento) throws ParseException{
		String codigoAsiento = asiento.get(0);
		Double precio = Double.parseDouble(asiento.get(1));
		TipoClaseAsiento clase = tipoAsiento(asiento.get(2));
		TipoUbicacionAsiento ubicacion = ubicacionAsiento(asiento.get(3));
		Boolean estadoReservado = estadoAsiento(asiento.get(4));
		Date fechaSalida = fecha.convertirALatinoamericano(asiento.get(5));
		Date fechaLlegada = fecha.convertirALatinoamericano(asiento.get(6));
		return new Asiento(codigoAsiento,precio,clase,ubicacion,estadoReservado,fechaSalida,fechaLlegada,this);
	}	
}
