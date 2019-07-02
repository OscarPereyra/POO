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
import vistas.AccionExitosa;
import vistas.Sobrereserva;

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
		this.buscador = Buscador.getInstance(aerolineas);
	}

	public void buscar(String destino, String origen, String fecha) throws ParseException{
		Busqueda busqueda = new Busqueda(origen, fecha, "", destino, "", "", null, null, null, null);
		this.asientos = buscador.busqueda(usuario, busqueda);
	}
	
	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void comprar(Asiento asientoSeleccionado) throws Exception {
		if (asientoSeleccionado!=null) {
			usuario.comprar(asientoSeleccionado);
		}
		else {
			System.out.println("Seleccione un asiento");
		}
		
	}
	
	public void reservar(Asiento asientoSeleccionado) throws Exception {
		if(asientoSeleccionado.getEstadoReservado()) {
			Sobrereserva sobrereserva = new Sobrereserva(asientoSeleccionado);
			sobrereserva.setVisible(true);
		}
		else {
			usuario.reservarAsiento(asientoSeleccionado);
			AccionExitosa reservoBien = new AccionExitosa(asientoSeleccionado,"reservado");
			reservoBien.setVisible(true);
		}
		
	}
}
