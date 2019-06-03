package modelo;

import java.util.ArrayList;

public abstract class Aerolinea {
	protected double impuestoPasajes;
	protected ArrayList<AsientoReservado> asientosSobreReservados = new ArrayList<AsientoReservado>();
	abstract void reservar(Usuario usuario,Asiento asiento);
	abstract void comprar(Usuario usuario,Asiento asiento);
	abstract ArrayList<Asiento> asientosDisponibles(String origen, String fechaSalida, String horaSalida, String destino, String fechaLlegada, String horaLlegada);
	abstract void actualizarSobreReservas(String codigoAsiento);
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
