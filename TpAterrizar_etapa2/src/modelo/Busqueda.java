package modelo;

import java.util.ArrayList;

public class Busqueda {
	private String origen;
	private String fechaSalida; 
	private String horaSalida;
	private String destino;
	private String fechaLlegada; 
	private String horaLlegada;
	private Double precioMin;
	private Double precioMax;
	private ArrayList<TipoClaseAsiento> clases = null;
	private TipoUbicacionAsiento ubicacion = null;
	private ArrayList<Filtro> filtros;
		
	public Busqueda(String origen, String fechaSalida, String horaSalida, String destino, String fechaLlegada,String horaLlegada, ArrayList<TipoClaseAsiento> clases, TipoUbicacionAsiento ubicacion,ArrayList<Filtro> filtros) {
		this.origen = origen;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.destino = destino;
		this.fechaLlegada = fechaLlegada;
		this.horaLlegada = horaLlegada;
		this.clases = clases;
		this.ubicacion = ubicacion;
		this.filtros = filtros;
	}
	
	public ArrayList<Filtro> getFiltros() {
		return filtros;
	}

	public void setFiltros(ArrayList<Filtro> filtros) {
		this.filtros = filtros;
	}

	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public ArrayList<TipoClaseAsiento> getClases() {
		return clases;
	}

	public void setClase(ArrayList<TipoClaseAsiento> clases) {
		this.clases = clases;
	}

	public TipoUbicacionAsiento getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(TipoUbicacionAsiento ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Double getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(Double precioMin) {
		if(precioMin!=null){
			this.precioMin = precioMin;
		}else {
			this.precioMin = 0.0;
		}		
	}
	
	public Double getPrecioMax() {
		return precioMax;
	}
	
	public void setPrecioMax(Double precioMax) {
		if(precioMax!=null){
			this.precioMax = precioMax;
		}else {
			this.precioMax = -1.0;
		}
	}
	
}
