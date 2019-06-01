package modelo;

public class Busqueda {
	private String origen;
	private String fechaSalida; 
	private String horaSalida;
	private String destino;
	private String fechaLlegada; 
	private String horaLlegada;
	private TipoClaseAsiento clase = null;
	private TipoUbicacionAsiento ubicacion = null;	
		
	public Busqueda(String origen, String fechaSalida, String horaSalida, String destino, String fechaLlegada,String horaLlegada, TipoClaseAsiento clase, TipoUbicacionAsiento ubicacion) {
		this.origen = origen;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.destino = destino;
		this.fechaLlegada = fechaLlegada;
		this.horaLlegada = horaLlegada;
		this.clase = clase;
		this.ubicacion = ubicacion;
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
