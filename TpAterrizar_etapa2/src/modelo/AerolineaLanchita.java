package modelo;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

public class AerolineaLanchita extends Aerolinea{
	IAerolineaLanchita lanchita;
	Fecha fecha = new Fecha();
	
	public AerolineaLanchita(IAerolineaLanchita lanchita) {
		this.lanchita = lanchita;
	}
	@Override
	void reservar(Usuario usuario, Asiento asiento) {
		if(asiento.getEstadoReservado()) {
			asientosSobreReservados.add(new AsientoReservado(asiento,usuario));
		}
		else {
			lanchita.reservar(asiento.getCodigoAsiento(),usuario.getDNI());
			asiento.setEstadoReservado(true);
		}
	}

	@Override
	void comprar(Usuario usuario, Asiento asiento) {
		try {
			lanchita.comprar(asiento.getCodigoAsiento());
			limpiarSobreReservas(asiento.getCodigoAsiento());
		}
		catch (AsientoLanchitaNoDisponibleException e) {
			System.out.println("Error al comprar el asiento");
		}
	}

	@Override
	ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) {
		ArrayList<ArrayList<String>> resultadoBusqueda = lanchita.asientosDisponibles(busqueda.getOrigen(),busqueda.getFechaSalida(),busqueda.getHoraSalida(),busqueda.getDestino(),busqueda.getFechaLlegada(),busqueda.getHoraLlegada());
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		resultadoBusqueda.forEach(asiento -> {
			try {
				asientosDisponibles.add(parsearAsiento(asiento));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
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
	
	protected void limpiarSobreReservas(String codigoAsiento) {
		asientosSobreReservados.removeIf(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento));
	}
	
	private Asiento parsearAsiento(ArrayList<String> asiento) throws ParseException{
		String codigoAsiento = asiento.get(0);
		Double precio = Double.parseDouble(asiento.get(1));
		TipoClaseAsiento clase = tipoAsiento(asiento.get(2));
		TipoUbicacionAsiento ubicacion = ubicacionAsiento(asiento.get(3));
		Boolean estadoReservado = estadoAsiento(asiento.get(4));
		Date fechaSalida = (Date) fecha.convertirALatinoamericano(asiento.get(5)) ;
		Date fechaLlegada = (Date) fecha.convertirALatinoamericano(asiento.get(6));
		return new Asiento(codigoAsiento,precio,clase,ubicacion,estadoReservado,fechaSalida,fechaLlegada,this);
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
