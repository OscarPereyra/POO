package modelo;

import java.util.ArrayList;

public class Sistema {
	private double recargoUsuarioNoPago = 20;
	private CalendarioVuelos calendarioVuelos = CalendarioVuelos.obtenerCalendario();
	
	public ArrayList<ArrayList<String>> buscarAsientos(Usuario usuario,Busqueda busqueda){
		ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>();
		
		usuario.agregarBusqueda(busqueda);
		
		resultado = calendarioVuelos.busquedaVueloDisponible(busqueda);
		
		return resultado;		
	}
	
}
