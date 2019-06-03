package modelo;

import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class Buscador {	
	private Double recargoUsuarioNoPago = 20.0;
	
	public ArrayList<Asiento> busqueda(Aerolinea aerolinea,Usuario usuario,Busqueda busqueda) {
		ArrayList<Asiento> asientosDisp = new ArrayList<Asiento>();
		asientosDisp = aerolinea.asientosDisponibles(busqueda.getOrigen(),busqueda.getFechaSalida(),busqueda.getHoraSalida(),busqueda.getDestino(),busqueda.getFechaLlegada(),busqueda.getHoraLlegada());
		asientosDisp.forEach(asiento -> actualizarPrecioTotal(asiento, aerolinea,usuario));
		filtrarPorClase(asientosDisp,busqueda.getClase());
		filtrarPorUbicacion(asientosDisp,busqueda.getUbicacion());
		if(!usuario.esVip()) {asientosDisp.removeIf(asiento -> esSuperOferta(asiento,aerolinea));}
		return asientosDisp;
	}
	
	public void comprarAsiento(Asiento asiento,Aerolinea aerolinea,Usuario usuario)throws AsientoLanchitaNoDisponibleException {
		aerolinea.comprar(usuario,asiento);
	}
	
	public void reservarAsiento(Asiento asiento,Usuario usuario,Aerolinea aerolinea) {
		aerolinea.reservar(usuario, asiento);
	}
	
	public void transferirReserva(Aerolinea aerolinea,String codigoAsiento) {
		aerolinea.actualizarSobreReservas(codigoAsiento);
	}
	
	private void filtrarPorClase(ArrayList<Asiento> asientos,TipoClaseAsiento clase) {
		if(clase!=null) {asientos.removeIf(asiento -> asiento.getClase().equals(clase));}
	}
	
	private void filtrarPorUbicacion(ArrayList<Asiento> asientos,TipoUbicacionAsiento ubicacion) {
		if(ubicacion!=null) {asientos.removeIf(asiento -> asiento.getUbicacion().equals(ubicacion));}
	}
	
	private boolean esSuperOferta(Asiento asiento, Aerolinea aerolinea) {
		return ((asiento.getClase().equals(TipoClaseAsiento.PRIMERA) && asiento.getPrecio()<8000)||(asiento.getClase().equals(TipoClaseAsiento.EJECUTIVA) && asiento.getPrecio()<4000));
	}
	
	private void actualizarPrecioTotal(Asiento asiento,Aerolinea aerolinea,Usuario usuario) {
		if(usuario.esPago()) {
			asiento.setPrecio(asiento.getPrecio()+(asiento.getPrecio()*aerolinea.getImpuestoPasajes()));
		}
		else {
			asiento.setPrecio((asiento.getPrecio()+(asiento.getPrecio()*aerolinea.getImpuestoPasajes())+recargoUsuarioNoPago));
		}
	}
}
