package modelo;

import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class Buscador {	
	private Double recargoUsuarioNoPago = 20.0;
	private ArrayList<Aerolinea> aerolineas;
	//lista de aerolineas para todo el buscador
	//recorrer todas las aerolineas y buscar los asientos disponibles de todas las aerolineas interfaz en comun
	public ArrayList<Asiento> busqueda(Usuario usuario,Busqueda busqueda) {
		ArrayList<Asiento> asientosDisp = new ArrayList<Asiento>();
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		//pasarle solo busqueda
		//test de asientos disponibles con atributos nulos
		asientosDisp = aerolineas.asientosDisponibles(busqueda);
		asientosDisp.forEach(asiento -> actualizarPrecioTotal(asiento, aerolinea,usuario));
		busqueda.getFiltros().forEach(filtro -> filtro.aplicarFiltro());
		/*filtrarPorClase(asientosDisp,busqueda.getClase());
		filtrarPorUbicacion(asientosDisp,busqueda.getUbicacion());
		filtrarPorPrecio(asientosDisp, busqueda.getPrecioMin(), busqueda.getPrecioMax());*/
		if(!usuario.esVip()) {asientosDisp.removeIf(asiento -> esSuperOferta(asiento,aerolinea));}
		usuario.agregarBusqueda(busqueda);
		return asientosDisp;
	}
	//mover comprar y reservar a usuario
	public void comprarAsiento(Asiento asiento,Aerolinea aerolinea,Usuario usuario) throws Exception {
		aerolinea.comprar(usuario,asiento);
	}
	
	public void reservarAsiento(Asiento asiento,Usuario usuario,Aerolinea aerolinea) {
		aerolinea.reservar(usuario, asiento);
	}
	
	public void transferirReserva(Aerolinea aerolinea,String codigoAsiento) {
		aerolinea.transferirReserva(codigoAsiento);
	}
		
	private boolean esSuperOferta(Asiento asiento, Aerolinea aerolinea) {
		return ((asiento.getClase().equals(TipoClaseAsiento.PRIMERA) && asiento.getPrecio()<8000)||(asiento.getClase().equals(TipoClaseAsiento.EJECUTIVA) && asiento.getPrecio()<4000));
	}
	
	
	//esto lo deberia hacer el asiento
	private void actualizarPrecioTotal(Asiento asiento,Aerolinea aerolinea,Usuario usuario) {
		if(usuario.esPago()) {
			asiento.setPrecio(asiento.getPrecio()+(asiento.getPrecio()*aerolinea.getImpuestoPasajes()));
		}
		else {
			asiento.setPrecio((asiento.getPrecio()+(asiento.getPrecio()*aerolinea.getImpuestoPasajes())+recargoUsuarioNoPago));
		}
	}
}
