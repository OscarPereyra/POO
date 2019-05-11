package modelo;

//import java.lang.reflect.Array;
import java.util.ArrayList;

public interface AerolineaLanchita {
	public ArrayList asientosDisponibles(String origen,String fechaSalida,String horaSalida,String destino,String fechaLlegada,String horaLlegada);
	public void comprar(String codigoAsiento);
}
