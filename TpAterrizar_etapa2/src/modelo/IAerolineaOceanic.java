package modelo;

import java.util.ArrayList;

public interface IAerolineaOceanic {
	public ArrayList<AsientoDTO> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida);
	public ArrayList<AsientoDTO> asientosDisponiblesParaOrigenYDestino(String codigoOrigenOceanic, String fechaSalida, String codigoDestinoOceanic);
	public boolean estaReservado(String codigoDeVuelo, int numeroDeAsiento);
	public boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, int numeroDeAsiento);
	public boolean reservar(String dni, String codigoVuelo, int numeroDeAsiento);
	
}
