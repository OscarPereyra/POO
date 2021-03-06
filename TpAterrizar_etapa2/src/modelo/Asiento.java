package modelo;

import java.util.Date;

public class Asiento {
	private String codigoAsiento;
	private Double precio;
	private TipoClaseAsiento clase;
	private TipoUbicacionAsiento ubicacion;
	private Boolean estadoReservado;
	private Date fechaSalida;
	private Date fechaLlegada;
	private Aerolinea aerolinea;
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getFechallegada() {
		return fechaLlegada;
	}
	public void setFechallegada(Date fechallegada) {
		this.fechaLlegada = fechallegada;
	}
	public Asiento(String codigoAsiento,Double precio,TipoClaseAsiento clase,TipoUbicacionAsiento ubicacion,Boolean estado,Date fechaSalida,Date fechaLlegada,Aerolinea aerolinea) {
		this.codigoAsiento = codigoAsiento;
		this.precio = precio;
		this.clase = clase;
		this.ubicacion = ubicacion;
		this.estadoReservado = estado;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.aerolinea = aerolinea;
	}
	public void actualizarPrecioTotal(Usuario usuario) {
		precio += (precio * +aerolinea.getImpuestoPasajes())+usuario.getRecargoUsuario();
	}	
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	public String getCodigoAsiento() {
		return codigoAsiento;
	}
	public String getVuelo() {
		return getCodigoAsiento().substring(0, 5);
	}
	public int numeroAsiento() {
		return Integer.parseInt(getCodigoAsiento().substring(7));
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
	public Long getTiempoDeVuelo() {
		return null;
	}
	public Object getDestino() {
		// TODO Auto-generated method stub
		return null;
	}
}
