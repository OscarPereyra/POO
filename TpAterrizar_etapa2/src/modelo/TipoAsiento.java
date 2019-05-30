package modelo;

public class TipoAsiento {
	private String codigoAsiento;
	private Double precio;
	private TipoClaseAsiento clase;
	private UbicacionAsiento ubicacion;
	private String estado;
	public TipoAsiento(String codigoAsiento,Double precio,TipoClaseAsiento clase,UbicacionAsiento ubicacion,String estado) {
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
	public TipoClaseAsiento getClase() {
		return clase;
	}
	public void setClase(TipoClaseAsiento clase) {
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
