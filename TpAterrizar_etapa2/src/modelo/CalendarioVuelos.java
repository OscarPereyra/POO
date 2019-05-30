package modelo;

import java.util.ArrayList;
import java.util.Date;

public class CalendarioVuelos {
	private static final CalendarioVuelos calendarioActual = new CalendarioVuelos();
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	
	public CalendarioVuelos() {
		super();
	}	
	public static CalendarioVuelos obtenerCalendario() {
		return calendarioActual;
	}
	
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
	
	public Vuelo busquedaVueloDisponible(Date fecha) {
		Vuelo vueloDisponible = new Vuelo();
		
		return vueloDisponible;
	}
	
	public ArrayList<ArrayList<String>> busquedaVueloDisponible(Busqueda busqueda){
		ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>();
		
		Vuelo vueloDisponible = this.calendarioActual.busquedaVueloDisponible(String. busqueda.getFechaSalida());
		
		
		
		//if(busqueda.getFechaSalida()!=null) {calendario.stream().forEach((v)->{vueloDisponible = v.get});}
				
		return resultado;
	}
	
	
	
	
}
