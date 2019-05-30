package modelo;

import java.util.ArrayList;

public class AerolineaLanchita implements IAerolineaLanchita{
	private final double impuesto = 0.15;
			
	@Override
	public ArrayList<ArrayList<String>> asientosDisponibles(String origen, String fechaSalida, String horaSalida,String destino, String fechaLlegada, String horaLlegada) {
		
		Busqueda nuevaBusqueda = new Busqueda(origen,fechaSalida,horaSalida,destino,fechaLlegada,horaLlegada);
				
		Buscador buscador = new Buscador();
		Usuario nuevo = new UsuarioEstandar();
		buscador.busqueda(nuevo, nuevaBusqueda);
		return null;
	}

	@Override
	public void comprar(String codigoAsiento) {
		// TODO Auto-generated method stub
		
	}

	public double getImpuesto() {
		return impuesto;
	}
	

}
