package modelo;

import java.text.ParseException;
import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

import vistas.ExceptionDestinoInvalido;
import vistas.ExceptionOrigenInvalido;

public class Buscador {
	private static Buscador buscador = null;
	private ArrayList<Aerolinea> aerolineas;
	
	public Buscador(ArrayList<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}
	public static Buscador getInstance(ArrayList<Aerolinea> aerolineas) {
		if (buscador == null) {
            buscador = new Buscador(aerolineas);
		}
        return buscador;
	}
	
	public ArrayList<Asiento> busqueda(Usuario usuario,Busqueda busqueda)throws ParseException, ExceptionDestinoInvalido, ExceptionOrigenInvalido {
		ArrayList<Asiento> asientosDisp = new ArrayList<Asiento>();
		aerolineas.forEach(aerolinea -> {
			try {
				asientosDisp.addAll(aerolinea.asientosDisponibles(busqueda));
			} catch (ParseException | ExceptionDestinoInvalido| ExceptionOrigenInvalido  e) {
				e.getMessage();
			}
		});
		asientosDisp.forEach(asiento -> asiento.actualizarPrecioTotal(usuario));
		if(busqueda.getFiltros()!=null)busqueda.getFiltros().forEach(filtro -> filtro.aplicarFiltro(asientosDisp));
		if(!usuario.esVip())asientosDisp.removeIf(asiento -> esSuperOferta(asiento));
		if(busqueda.getCriterios()!=null)busqueda.getCriterios().forEach(criterio -> criterio.aplicarCriterio(asientosDisp));
		usuario.agregarBusqueda(busqueda);
		return asientosDisp;
	}
	
	public void transferirReserva(String codigoAsiento) {
		aerolineas.forEach(aerolinea -> aerolinea.transferirReserva(codigoAsiento));
	}
		
	private boolean esSuperOferta(Asiento asiento) { 
		return ((asiento.getClase().equals(TipoClaseAsiento.PRIMERA) && asiento.getPrecio()<8000)||(asiento.getClase().equals(TipoClaseAsiento.EJECUTIVA) && asiento.getPrecio()<4000));
	}	
}