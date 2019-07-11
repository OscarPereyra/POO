package modelo;

import java.text.ParseException;
import java.util.Date;

public class AsientoDTO {
	private String codigoVuelo;
	private int numeroAsiento;
	private Date fechaSalida;
	private String horaSalida;
	private Double precio;
	private TipoClaseAsiento clase;
	private TipoUbicacionAsiento ubicacion;
	private Date fechaLlegada;
	private String horaLlegada;
	private boolean estadoReservado;
	private boolean estadoCompra;

	public AsientoDTO(String codigoVuelo, int numeroAsiento, Date fechaSalida, String horaSalida, Double precio,
			TipoClaseAsiento clase, TipoUbicacionAsiento ubicacion, Date fechaLlegada,String horaLlegada) {
		this.codigoVuelo = codigoVuelo;
		this.numeroAsiento = numeroAsiento;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.precio = precio;
		this.clase = clase;
		this.ubicacion = ubicacion;
		this.fechaLlegada = fechaLlegada;
		this.horaLlegada = horaLlegada;
		this.estadoReservado = false;
		this.estadoCompra = false;
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
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public Boolean getEstadoReservado() {
		return estadoReservado;
	}
	public void setEstadoReservado(Boolean estadoReservado) {
		this.estadoReservado = estadoReservado;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public boolean isEstadoCompra() {
		return estadoCompra;
	}
	public void setEstadoCompra(boolean estadoCompra) {
		this.estadoCompra = estadoCompra;
	}
	public void setEstadoReservado(boolean estadoReservado) {
		this.estadoReservado = estadoReservado;
	}

	public Asiento convertirAsientoDTOAAsiento(AsientoDTO asientoDTO,Aerolinea aerolinea) throws ParseException {
		if(asientoDTO.getCodigoVuelo()!="") {
			String codigoAsiento = asientoDTO.getCodigoVuelo().concat("-"+Integer.toString(asientoDTO.getNumeroAsiento()));
			return new Asiento(codigoAsiento,asientoDTO.getPrecio(),asientoDTO.getClase(),asientoDTO.getUbicacion(),false,asientoDTO.getFechaSalida(),asientoDTO.getFechaLlegada(),aerolinea);
		}else {
			return null;		
		}
	}
}