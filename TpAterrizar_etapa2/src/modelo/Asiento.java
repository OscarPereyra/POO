package modelo;

public class Asiento {
	private String codigoAsiento;
	private Double precio;
	private ClaseAsiento clase;
	private UbicacionAsiento ubicacion;
	private String estado;
	public Asiento(String codigoAsiento,Double precio,ClaseAsiento clase,UbicacionAsiento ubicacion,String estado) {
		this.codigoAsiento = codigoAsiento;
		this.precio = precio;
		this.clase = clase;
		this.ubicacion = ubicacion;
		this.estado = estado;
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
	public ClaseAsiento getClase() {
		return clase;
	}
	public void setClase(ClaseAsiento clase) {
		this.clase = clase;
	}
	public UbicacionAsiento getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(UbicacionAsiento ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
