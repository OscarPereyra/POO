package modelo;

import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

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
			//No se como hacer el filtrado de los asientos
		}
		if(ubicacion!=null) {
			//filtrados = asientos.stream().filter(asiento -> asiento.get(3).equals(ubicacion)).;
			//No se como hacer el filtrado de los asientos
		}
		return filtrados;
	}
	
	private boolean esSuperOferta(ArrayList<String> asiento, AerolineaLanchita aerolinea) {
		return ((asiento.get(2).equals("P") && precioTotal(asiento,aerolinea)<8000)||(asiento.get(2).equals("E") && precioTotal(asiento,aerolinea)<4000));
	}
	
	private double precioTotal(ArrayList<String> asiento,AerolineaLanchita aerolinea) {
		return (Double.parseDouble(asiento.get(1)))*(1+aerolinea.porcentajeImpuestos);
		//Falta considerar el si es el usuario tiene cuenta paga o no (recargo de $20 si no es pago)
	}
}
