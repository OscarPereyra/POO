package modelo;

import java.util.Date;

public class AsientoDTO {
	private String codigoVuelo;
	private int numeroAsiento;
	private Date fechaSalida;
	private String horaSalida;
	private double precio;
	private TipoClaseAsiento clase;
	private TipoUbicacionAsiento ubicacion;
	private Date fechaLlegada;
	
	public AsientoDTO(String codigoVuelo, int numeroAsiento, Date fechaSalida, String horaSalida, double precio,
			TipoClaseAsiento clase, TipoUbicacionAsiento ubicacion, Date fechaLlegada) {
		this.codigoVuelo = codigoVuelo;
		this.numeroAsiento = numeroAsiento;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.precio = precio;
		this.clase = clase;
		this.ubicacion = ubicacion;
		this.fechaLlegada = fechaLlegada;
	}
	public String getCodigoVuelo() {
		return codigoVuelo;
	}
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}
	public int getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(int numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public TipoClaseAsiento getClase() {
		return clase;
	}
	public void setClase(TipoClaseAsiento clase) {
		this.clase = clase;
	}
	public TipoUbicacionAsiento getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(TipoUbicacionAsiento ubicacion) {
		this.ubicacion = ubicacion;
	}	
}