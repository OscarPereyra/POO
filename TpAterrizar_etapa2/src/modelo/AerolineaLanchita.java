package modelo;

import java.util.ArrayList;

public class AerolineaLanchita extends Aerolinea{
	IAerolineaLanchita lanchita;
	@Override
	void reservar(Usuario usuario, Asiento asiento) {
		if(asiento.getEstadoReservado()) {
			asientosSobreReservados.add(new AsientoReservado(asiento,usuario));
		}
		else {
			lanchita.reservar(asiento.getCodigoAsiento(),usuario.getDNI());
			asientosSobreReservados.add(new AsientoReservado(asiento,usuario));
		}
	}

	@Override
	void comprar(Usuario usuario, Asiento asiento) {
		try {
			lanchita.comprar(asiento.getCodigoAsiento());
			usuario.comprar(asiento.getPrecio());
			limpiarSobreReservas(asiento.getCodigoAsiento());
		}
		catch (AsientoLanchitaNoDisponibleException e) {
			System.out.println("Error al comprar el asiento");
		}
	}

	@Override
	ArrayList<Asiento> asientosDisponibles(String origen, String fechaSalida, String horaSalida, String destino, String fechaLlegada, String horaLlegada) {
		ArrayList<ArrayList<String>> resultadoBusqueda = lanchita.asientosDisponibles(horaLlegada, horaLlegada, horaLlegada, horaLlegada, horaLlegada, horaLlegada);
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		resultadoBusqueda.forEach(asiento -> asientosDisponibles.add(parsearAsiento(asiento)));
		return asientosDisponibles;
	}
	
	@Override
	void transferirReserva(String codigoAsiento) {
		ArrayList<AsientoReservado> reservasFiltradas = (ArrayList<AsientoReservado>) asientosSobreReservados.stream().filter(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento));
		if(!reservasFiltradas.isEmpty()) {
			lanchita.reservar(reservasFiltradas.get(0).getAsiento().getCodigoAsiento(), reservasFiltradas.get(0).getUsuario().getDNI());
			asientosSobreReservados.remove(reservasFiltradas.get(0));
		}
	}
	
	private void limpiarSobreReservas(String codigoAsiento) {
		asientosSobreReservados.removeIf(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento));
	}
	
	private Asiento parsearAsiento(ArrayList<String> asiento){
		String codigoAsiento = asiento.get(0);
		Double precio = Double.parseDouble(asiento.get(1));
		TipoClaseAsiento clase = tipoAsiento(asiento.get(2));
		TipoUbicacionAsiento ubicacion = ubicacionAsiento(asiento.get(3));
		Boolean estadoReservado = estadoAsiento(asiento.get(4));
		return new Asiento(codigoAsiento,precio,clase,ubicacion,estadoReservado);
	}
	
	private Boolean estadoAsiento(String estado) {
		if(estado == "D") {
			return true;
		}
		else if(estado =="R") {
			return false;
		}
		return null;
	}
	
	private TipoClaseAsiento tipoAsiento(String clase) {
		switch (clase){
		case "T":
			return TipoClaseAsiento.TURISTA;
		case "E":
			return TipoClaseAsiento.EJECUTIVA;
		case "P":
			return TipoClaseAsiento.PRIMERA;
		default:
			return null;
		}
	}
	
	private TipoUbicacionAsiento ubicacionAsiento(String ubicacion) {
		switch (ubicacion){
		case "V":
			return TipoUbicacionAsiento.VENTANILLA;
		case "C":
			return TipoUbicacionAsiento.CENTRO;
		case "P":
			return TipoUbicacionAsiento.PASILLO;
		default:
			return null;
		}
	}
}
