package modelo;

public class Asiento {
	private String codigoAsiento;
	private Double precio;
	private TipoClaseAsiento clase;
	private TipoUbicacionAsiento ubicacion;
	private Boolean estadoReservado;
	
	public Asiento(String codigoAsiento,Double precio,TipoClaseAsiento clase,TipoUbicacionAsiento ubicacion,Boolean estado) {
		this.codigoAsiento = codigoAsiento;
		this.precio = precio;
		this.clase = clase;
		this.ubicacion = ubicacion;
		this.estadoReservado = estado;
	}
	public String getCodigoAsiento() {
		return codigoAsiento;
	}
	public void setCodigoAsiento(String codigoAsiento) {
		this.codigoAsiento = codigoAsiento;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
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
	public Boolean getEstadoReservado() {
		return estadoReservado;
	}
	public void setEstadoReservado(Boolean estado) {
		this.estadoReservado = estado;
	}
}
