package viewModel;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.Aerolinea;
import modelo.AerolineaLanchita;
import modelo.Asiento;
import modelo.Buscador;
import modelo.Busqueda;
import modelo.LanchitaDummy;
import modelo.Usuario;

public class BuscarViewModel {
	private Buscador buscador;
	private Usuario usuario;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	private Asiento asientoSeleccionado;

	public Asiento getAsientoSeleccionado() {
		return asientoSeleccionado;
	}

	public void setAsientoSeleccionado(Asiento asientoSeleccionado) {
		this.asientoSeleccionado = asientoSeleccionado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BuscarViewModel(Usuario usuario) {
		this.usuario = usuario;
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(new AerolineaLanchita(new LanchitaDummy()));
		this.buscador = new Buscador(aerolineas);
	}

	public void buscar(String destino, String origen, String fecha) throws ParseException{
		Busqueda busqueda = new Busqueda(origen, fecha, "", destino, "", "", null, null, null, null);
		this.asientos = buscador.busqueda(usuario, busqueda);
	}
	
	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void comprar(Asiento asientoSeleccionado) throws Exception {
		usuario.comprar(asientoSeleccionado);
	}
	
	public void reservar(Asiento asientoSeleccionado) throws Exception {
		usuario.reservarAsiento(asientoSeleccionado);
	}
}
