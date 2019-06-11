package modelo;

import java.text.ParseException;
import java.util.ArrayList;

public abstract class Aerolinea {
	protected double impuestoPasajes;
	protected Fecha fecha = new Fecha();
	protected ArrayList<AsientoReservado> asientosSobreReservados = new ArrayList<AsientoReservado>();
	abstract void reservar(Usuario usuario,Asiento asiento);
	abstract void comprar(Usuario usuario,Asiento asiento)throws Exception;
	abstract ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) throws ParseException;
	protected void limpiarSobreReservas(String codigoAsiento) {
		asientosSobreReservados.removeIf(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento));
	}
	abstract void transferirReserva(String codigoAsiento);
	public double getImpuestoPasajes() {
		return impuestoPasajes;
	}
	public void setImpuestoPasajes(double impuestoPasajes) {
		this.impuestoPasajes = impuestoPasajes;
	}
	public ArrayList<AsientoReservado> getAsientosReservados() {
		return asientosSobreReservados;
	}
	public void setAsientosReservados(ArrayList<AsientoReservado> asientosReservados) {
		this.asientosSobreReservados = asientosReservados;
	}
}
