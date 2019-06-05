package modelo;

import java.sql.Date;
import java.text.ParseException;
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
	private Asiento convertir(AsientoDTO asientoDTO) throws ParseException {
		String codigoAsiento = asientoDTO.getCodigoVuelo().concat(Integer.toString(asientoDTO.getNumeroAsiento()));
		return new Asiento(codigoAsiento,asientoDTO.getPrecio(),asientoDTO.getClase(),asientoDTO.getUbicacion(),false,(Date) fecha.convertirALatinoamericano(asientoDTO.getFechaSalida()),asientoDTO.getFechaLlegada());		
	}	
//completar la sobrereserva
	@Override
	void reservar(Usuario usuario, Asiento asiento) {
		if(!oceanic.estaReservado(asiento.getVuelo(),asiento.numeroAsiento())) {
			oceanic.reservar(usuario.getDNI(), asiento.getVuelo(), asiento.numeroAsiento());
		}		
	}
//completar la compra
	@Override
	void comprar(Usuario usuario, Asiento asiento) {
		oceanic.comprarSiHayDisponibilidad(usuario.getDNI(), asiento.getVuelo(),asiento.numeroAsiento());		
	}
//corregir el e.print
	@Override
	ArrayList<Asiento> asientosDisponibles(String origen, String fechaSalida, String horaSalida, String destino,
			String fechaLlegada, String horaLlegada) {
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		ArrayList<AsientoDTO> disponibles = null;
		if((origen!=null) && (fechaSalida!=null) && (destino==null)) {
			origen = formatoCiudad(origen);
			disponibles = oceanic.asientosDisponiblesParaOrigen(origen, fechaSalida);
			disponibles.forEach(asiento -> {
				try {
					asientosDisponibles.add(convertir(asiento));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
			
		}else if((origen!=null) && (fechaSalida!=null) && (destino!=null)) {
			origen = formatoCiudad(origen);
			destino = formatoCiudad(destino);
			disponibles = oceanic.asientosDisponiblesParaOrigenYDestino(origen, fechaSalida, destino);
			disponibles.forEach(asiento -> {
				try {
					asientosDisponibles.add(convertir(asiento));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
		}		
		return asientosDisponibles;
	}

	@Override
	void transferirReserva(String codigoAsiento) {
		// TODO Auto-generated method stub
		
	}
	
}
