package modelo;

import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase,ubicacion(V-C-P),estado(R-D)]
public class Buscador {
	/*public Array busqueda(String origen,String destino,String fecha) {
		AerolineaLanchita fideo = new  AerolineaLanchita();
		ArrayList<String> resultadoBusqueda = new ArrayList<String>();
		resultadoBusqueda = fideo.asientosDisponibles(origen,fecha,null,destino,null,null);
		
		return null;
		
	}*/
	public ArrayList<ArrayList<String>> busqueda(String origen,String fechaSalida, String horaSalida,String destino,String fechaLlegada,String horaLlegada,String clase,String ubicacion) {
		AerolineaLanchita fideo = new  AerolineaLanchita();
		ArrayList<ArrayList<String>> resultadoBusqueda = new ArrayList<ArrayList<String>>();
		resultadoBusqueda = fideo.asientosDisponibles(origen,fechaSalida,horaSalida,destino,fechaLlegada,horaLlegada);
		
		return resultadoBusqueda;
	}
	
	private ArrayList<ArrayList<String>> filtrarBusqueda(ArrayList<ArrayList<String>> asientos, String clase, String ubicacion){
		ArrayList<ArrayList<String>> filtrados = null;
		if(clase!=null) {
			//filtrados = asientos.stream().filter(asiento -> asiento.get(2).equals(clase)).toArray();
			//Ese filter anda para el culo, no se como hacer que devuelva el mismo tipo de la lista
		}
		if(ubicacion!=null) {
			//filtrados = asientos.stream().filter(asiento -> asiento.get(3).equals(ubicacion)).;
			//Ese filter anda para el culo, no se como hacer que devuelva el mismo tipo de la lista
		}
		return filtrados;
	}
}
