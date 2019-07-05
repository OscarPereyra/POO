package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import dummys.LanchitaDummy;
import modelo.Aerolinea;
import modelo.AerolineaLanchita;
import modelo.Asiento;
import modelo.Buscador;
import modelo.Busqueda;
import modelo.IAerolineaLanchita;
import modelo.TipoClaseAsiento;
import modelo.TipoUbicacionAsiento;
import modelo.Usuario;
import modelo.UsuarioEstandar;

public class TestBuscador {
	
	@Test
	public void busqueda_SeEnvianAtributosNullABusquedaYNoFiltraNada() throws ParseException {
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = new Buscador(aerolineas);
		ArrayList<ArrayList<String>> asientosLanchita = new LanchitaDummy().getAsientos();
		when(mockLanchita.asientosDisponibles(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosLanchita);
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		Busqueda busqueda = new Busqueda("","", "", "", "","",null,null, null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario, busqueda);
		Assert.assertEquals("La busqueda no acepta atributos nulos",new LanchitaDummy().getAsientos().size(),asientosEncontrados.size());
	}
	
0
}

