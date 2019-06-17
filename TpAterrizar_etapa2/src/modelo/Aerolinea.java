package modelo;

import java.text.ParseException;
import java.util.ArrayList;

public abstract class Aerolinea {
	protected double impuestoPasajes;
	protected Fecha fecha = new Fecha();
	protected ArrayList<AsientoReservado> asientosSobreReservados = new ArrayList<AsientoReservado>();
	public abstract void reservar(Usuario usuario,Asiento asiento);
	public abstract void comprar(Usuario usuario,Asiento asiento)throws Exception;
	public abstract ArrayList<Asiento> asientosDisponibles(Busqueda busqueda) throws ParseException;
	protected void limpiarSobreReservas(String codigoAsiento) {
		asientosSobreReservados.removeIf(reserva -> reserva.getAsiento().getCodigoAsiento().equals(codigoAsiento));
	}
	public abstract void transferirReserva(String codigoAsiento);
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
	public Boolean estadoAsiento(String estado) {
		if(estado == "D") {
			return true;
		}
		else if(estado =="R") {
			return false;
		}
		return null;
	}	
	public TipoClaseAsiento tipoAsiento(String clase) {
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
	public TipoUbicacionAsiento ubicacionAsiento(String ubicacion) {
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
