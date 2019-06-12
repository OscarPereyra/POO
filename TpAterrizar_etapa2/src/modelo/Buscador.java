package modelo;

import java.text.ParseException;
import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class Buscador {	
	private Double recargoUsuarioNoPago = 20.0;
	private ArrayList<Aerolinea> aerolineas;
	
	public Buscador(ArrayList<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}
	//lista de aerolineas para todo el buscador YA ESTA
	//recorrer todas las aerolineas y buscar los asientos disponibles de todas las aerolineas interfaz en comun YA ESTA
	public ArrayList<Asiento> busqueda(Usuario usuario,Busqueda busqueda) {
		ArrayList<Asiento> asientosDisp = new ArrayList<Asiento>();
		//pasarle solo busqueda YA ESTA
		//test de asientos disponibles con atributos nulos
		aerolineas.forEach(aerolinea -> {
			try {
				asientosDisp.addAll(aerolinea.asientosDisponibles(busqueda));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		asientosDisp.forEach(asiento -> asiento.actualizarPrecioTotal(usuario));
		busqueda.getFiltros().forEach(filtro -> filtro.aplicarFiltro(asientosDisp));
		/*filtrarPorClase(asientosDisp,busqueda.getClase());
		filtrarPorUbicacion(asientosDisp,busqueda.getUbicacion());
		filtrarPorPrecio(asientosDisp, busqueda.getPrecioMin(), busqueda.getPrecioMax());*/
		if(!usuario.esVip()) {asientosDisp.removeIf(asiento -> esSuperOferta(asiento));}
		usuario.agregarBusqueda(busqueda);
		return asientosDisp;
	}
	//mover comprar y reservar a usuario, YA ESTA	
	public void transferirReserva(String codigoAsiento) {
		aerolineas.forEach(aerolinea -> aerolinea.transferirReserva(codigoAsiento));
	}
		
	private boolean esSuperOferta(Asiento asiento) {
		return ((asiento.getClase().equals(TipoClaseAsiento.PRIMERA) && asiento.getPrecio()<8000)||(asiento.getClase().equals(TipoClaseAsiento.EJECUTIVA) && asiento.getPrecio()<4000));
	}
}
