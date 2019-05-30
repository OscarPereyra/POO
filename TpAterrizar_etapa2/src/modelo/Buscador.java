package modelo;

import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class Buscador {
	private double recargoUsuarioNoPago = 20;
	public ArrayList<ArrayList<String>> busqueda(Usuario usuario,String origen,String fechaSalida, String horaSalida,String destino,String fechaLlegada,String horaLlegada,TipoClaseAsiento clase,UbicacionAsiento ubicacion) {
		AerolineaLanchita aerolinea = new  AerolineaLanchita();
		ArrayList<TipoAsiento> asientosDisp = new ArrayList<TipoAsiento>();
		ArrayList<ArrayList<String>> resultadoBusqueda = new ArrayList<ArrayList<String>>();
		resultadoBusqueda = aerolinea.asientosDisponibles(origen,fechaSalida,horaSalida,destino,fechaLlegada,horaLlegada);
		resultadoBusqueda.forEach(asiento -> asientosDisp.add(parsearAsiento(asiento)));
		asientosDisp.forEach(asiento -> actualizarPrecioTotal(asiento, aerolinea,usuario));
		filtrarPorClase(asientosDisp,clase);
		filtrarPorUbicacion(asientosDisp,ubicacion);
		if(!usuario.esVip()) {asientosDisp.removeIf(asiento -> esSuperOferta(asiento,aerolinea));}
		return resultadoBusqueda;
	}
	
	public void comprarAsiento(TipoAsiento asiento,IAerolineaLanchita aerolinea,Usuario usuario) {
		aerolinea.comprar(asiento.getCodigoAsiento());
		usuario.comprar(asiento.getPrecio());		
	}
	
	private void filtrarPorClase(ArrayList<TipoAsiento> asientos,TipoClaseAsiento clase) {
		if(clase!=null) {asientos.removeIf(asiento -> asiento.getClase().equals(clase));}
	}
	
	private void filtrarPorUbicacion(ArrayList<TipoAsiento> asientos,UbicacionAsiento ubicacion) {
		if(ubicacion!=null) {asientos.removeIf(asiento -> asiento.getUbicacion().equals(ubicacion));}
	}
	
	private TipoAsiento parsearAsiento(ArrayList<String> asiento){
		String codigoAsiento = asiento.get(0);
		Double precio = Double.parseDouble(asiento.get(1));
		TipoClaseAsiento clase = tipoAsiento(asiento.get(2));
		UbicacionAsiento ubicacion = ubicacionAsiento(asiento.get(3));
		String estado = asiento.get(4);
		return new TipoAsiento(codigoAsiento,precio,clase,ubicacion,estado);
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
	
	private UbicacionAsiento ubicacionAsiento(String ubicacion) {
		switch (ubicacion){
		case "V":
			return UbicacionAsiento.VENTANILLA;
		case "C":
			return UbicacionAsiento.CENTRO;
		case "P":
			return UbicacionAsiento.PASILLO;
		default:
			return null;
		}
	}
	
	private boolean esSuperOferta(TipoAsiento asiento, IAerolineaLanchita aerolinea) {
		return ((asiento.getClase().equals(TipoClaseAsiento.PRIMERA) && asiento.getPrecio()<8000)||(asiento.getClase().equals(TipoClaseAsiento.EJECUTIVA) && asiento.getPrecio()<4000));
	}
	
	private void actualizarPrecioTotal(TipoAsiento asiento,IAerolineaLanchita aerolinea,Usuario usuario) {
		if(usuario.esPago()) {
			asiento.setPrecio(asiento.getPrecio()*aerolinea.getImpuesto());
		}
		else {
			asiento.setPrecio((asiento.getPrecio()*aerolinea.getImpuesto())+recargoUsuarioNoPago);
		}
	}
}
