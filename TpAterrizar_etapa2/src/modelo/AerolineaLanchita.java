package modelo;

import java.util.ArrayList;

public class AerolineaLanchita implements IAerolineaLanchita{

	@Override
	public ArrayList<ArrayList<String>> asientosDisponibles(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
		Busqueda nuevaBusqueda = new Busqueda();
		nuevaBusqueda.setOrigen(origen);
		nuevaBusqueda.setFechaSalida(fechaSalida);
		nuevaBusqueda.setHoraSalida(horaSalida);
		nuevaBusqueda.setDestino(destino);
		nuevaBusqueda.setFechaLlegada(fechaLlegada);
		nuevaBusqueda.setHoraLlegada(horaLlegada);
		
		Buscador buscador = new Buscador();
		
		return null;
	}

	@Override
	public void comprar(String codigoAsiento) {
		// TODO Auto-generated method stub
		
	}
	

}
