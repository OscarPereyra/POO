package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Vuelo {
	private Date fechaVuelo = null;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	
	public Vuelo() {}
	
	public Vuelo(Date fechaVuelo) {
		super();
		this.fechaVuelo = fechaVuelo;
		// TO DO  ACA HABRIA QUE GENERAR UNA LISTA DE ASIENTOS CON LA CANTIDAD DE ASIENTOS Y TODOS EN ESTADO DISPONIBLE
		
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}
	
	public ArrayList<ArrayList<String>> busquedaAsientoDisponible(){
		ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>();
		
		//TO DO
		
		return resultado;
	}
	
	
}
