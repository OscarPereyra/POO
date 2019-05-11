package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Buscador {
	public Array busqueda(String origen,String destino,String fecha) {
		AerolineaLanchita fideo = new  AerolineaLanchita();
		ArrayList<> resultadoBusqueda = new ArrayList<>();
		resultadoBusqueda = fideo.asientosDisponibles(origen,fecha,null,destino,null,null);
		
		return null;
		
	}
	public Array busqueda(String origen,String destino,String fecha,String clase) {
		AerolineaLanchita fideo = new  AerolineaLanchita();
		ArrayList<> resultadoBusqueda = new ArrayList<>();
		resultadoBusqueda = fideo.asientosDisponibles(origen,fecha,null,destino,null,null);
		
		return null;
		
	}

}
