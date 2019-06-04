package modelo;

import java.util.ArrayList;

public class AerolineaOceanic extends Aerolinea{
	IAerolineaOceanic oceanic;
	
	public String formatoCiudad(String ciudad) {
		String codigo="";
		if((ciudad.length()==2)&&( ciudad.toCharArray()[2] != '_') ) {
			codigo = ciudad.concat("_");
		}else if(ciudad == "LA") {
			codigo = "SLA";
		}
		return codigo;
	}
	
	public ArrayList<AsientoDTO> asientosDisponiblesPorOrigen(String origen, String fechaSalida){
		ArrayList<AsientoDTO> disponibles = null;
		if((origen!=null) && (fechaSalida!=null)) {
			origen = formatoCiudad(origen);
			disponibles = oceanic.asientosDisponiblesParaOrigen(origen, fechaSalida);
		}			
		return disponibles;		
	}
	
	public ArrayList<AsientoDTO> asientosDisponiblesPorOrigenYDestino(String origen, String fechaSalida, String destino){
		ArrayList<AsientoDTO> disponibles = null;
		if((origen!=null) && (fechaSalida!=null) && (destino!=null)) {
			origen = formatoCiudad(origen);
			destino = formatoCiudad(destino);
			disponibles = oceanic.asientosDisponiblesParaOrigenYDestino(origen, fechaSalida, destino);
		}			
		return disponibles;		
	}

	@Override
	void reservar(Usuario usuario, Asiento asiento) {
		if(!oceanic.estaReservado(asiento.getVuelo(),asiento.numeroAsiento())) {
			oceanic.reservar(usuario.getDNI(), asiento.getVuelo(), asiento.numeroAsiento());
		}		
	}

	@Override
	void comprar(Usuario usuario, Asiento asiento) {
		oceanic.comprarSiHayDisponibilidad(usuario.getDNI(), asiento.getVuelo(),asiento.numeroAsiento());		
	}

	@Override
	ArrayList<Asiento> asientosDisponibles(String origen, String fechaSalida, String horaSalida, String destino,
			String fechaLlegada, String horaLlegada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void transferirReserva(String codigoAsiento) {
		// TODO Auto-generated method stub
		
	}
	
}
