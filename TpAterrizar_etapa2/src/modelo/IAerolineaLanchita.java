package modelo;

import java.util.ArrayList;

import excepciones.AsientoLanchitaNoDisponibleException;

public interface IAerolineaLanchita {
	public ArrayList<ArrayList<String>> asientosDisponibles(String origen,String fechaSalida,String horaSalida,String destino,String fechaLlegada,String horaLlegada);
	public void comprar(String codigoAsiento)throws AsientoLanchitaNoDisponibleException;
	public void reservar(String codigo, String dni)throws AsientoLanchitaNoDisponibleException;
}
