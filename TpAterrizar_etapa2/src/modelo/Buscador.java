package modelo;

import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class Buscador {
	private double recargoUsuarioNoPago = 20;
		
	public ArrayList<ArrayList<String>> busqueda(Usuario usuario,Busqueda busqueda) {
		AerolineaLanchita aerolinea = new  AerolineaLanchita();
		ArrayList<Asiento> asientosDisp = new ArrayList<Asiento>();
		ArrayList<ArrayList<String>> resultadoBusqueda = new ArrayList<ArrayList<String>>();
		resultadoBusqueda = aerolinea.asientosDisponibles(busqueda.getOrigen(),busqueda.getFechaSalida(),busqueda.getHoraSalida(),busqueda.getDestino(),busqueda.getFechaLlegada(),busqueda.getHoraLlegada());
		resultadoBusqueda.forEach(asiento -> asientosDisp.add(parsearAsiento(asiento)));
		asientosDisp.forEach(asiento -> actualizarPrecioTotal(asiento, aerolinea,usuario));
		if(!usuario.esVip()) {asientosDisp.removeIf(asiento -> esSuperOferta(asiento,aerolinea));}
		return resultadoBusqueda;
	}
	
	public ArrayList<ArrayList<String>> busqueda(Usuario usuario,Busqueda busqueda,TipoClaseAsiento clase,TipoUbicacionAsiento ubicacion) {
		AerolineaLanchita aerolinea = new  AerolineaLanchita();
		ArrayList<Asiento> asientosDisp = new ArrayList<Asiento>();
		ArrayList<ArrayList<String>> resultadoBusqueda = new ArrayList<ArrayList<String>>();
		resultadoBusqueda = aerolinea.asientosDisponibles(busqueda.getOrigen(),busqueda.getFechaSalida(),busqueda.getHoraSalida(),busqueda.getDestino(),busqueda.getFechaLlegada(),busqueda.getHoraLlegada());
		resultadoBusqueda.forEach(asiento -> asientosDisp.add(parsearAsiento(asiento)));
		asientosDisp.forEach(asiento -> actualizarPrecioTotal(asiento, aerolinea,usuario));
		filtrarPorClase(asientosDisp,clase);
		filtrarPorUbicacion(asientosDisp,ubicacion);
		if(!usuario.esVip()) {asientosDisp.removeIf(asiento -> esSuperOferta(asiento,aerolinea));}
		return resultadoBusqueda;
	}
	
	public void comprarAsiento(Asiento asiento,IAerolineaLanchita aerolinea,Usuario usuario) {
		aerolinea.comprar(asiento.getCodigoAsiento());
		usuario.comprar(asiento.getPrecio());		
	}
	
	private void filtrarPorClase(ArrayList<Asiento> asientos,TipoClaseAsiento clase) {
		if(clase!=null) {asientos.removeIf(asiento -> asiento.getClase().equals(clase));}
	}
	
	private void filtrarPorUbicacion(ArrayList<Asiento> asientos,TipoUbicacionAsiento ubicacion) {
		if(ubicacion!=null) {asientos.removeIf(asiento -> asiento.getUbicacion().equals(ubicacion));}
	}
	
	private Asiento parsearAsiento(ArrayList<String> asiento){
		String codigoAsiento = asiento.get(0);
		Double precio = Double.parseDouble(asiento.get(1));
		TipoClaseAsiento clase = tipoAsiento(asiento.get(2));
		TipoUbicacionAsiento ubicacion = ubicacionAsiento(asiento.get(3));
		EstadoAsiento estado = null;
		if(asiento.get(4) == "D") {
			estado = new AsientoDisponible();
		}
		else if(asiento.get(4)=="R") {
			estado = new AsientoReservado();
		}
		return new Asiento(codigoAsiento,precio,clase,ubicacion,estado);
	}
	
	private TipoClaseAsiento tipoAsiento(String clase) {
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
	
	private TipoUbicacionAsiento ubicacionAsiento(String ubicacion) {
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
	
	private boolean esSuperOferta(Asiento asiento, IAerolineaLanchita aerolinea) {
		return ((asiento.getClase().equals(TipoClaseAsiento.PRIMERA) && asiento.getPrecio()<8000)||(asiento.getClase().equals(TipoClaseAsiento.EJECUTIVA) && asiento.getPrecio()<4000));
	}
	
	private void actualizarPrecioTotal(Asiento asiento,AerolineaLanchita aerolinea,Usuario usuario) {
		if(usuario.esPago()) {
			asiento.setPrecio(asiento.getPrecio()+(asiento.getPrecio()*aerolinea.getImpuesto()));
		}
		else {
			asiento.setPrecio((asiento.getPrecio()+(asiento.getPrecio()*aerolinea.getImpuesto())+recargoUsuarioNoPago));
		}
	}
}
