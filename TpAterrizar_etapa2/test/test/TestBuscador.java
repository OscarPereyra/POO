package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.stubbing.OngoingStubbing;

import com.sun.jmx.snmp.InetAddressAcl;

import dummys.LanchitaDummy;
import dummys.OceanicDummy;
import modelo.Aerolinea;
import modelo.AerolineaLanchita;
import modelo.AerolineaOceanic;
import modelo.Asiento;
import modelo.AsientoDTO;
import modelo.Buscador;
import modelo.Busqueda;
import modelo.IAerolineaLanchita;
import modelo.IAerolineaOceanic;
import modelo.TipoClaseAsiento;
import modelo.TipoUbicacionAsiento;
import modelo.Usuario;
import modelo.UsuarioEstandar;
import vistas.ExceptionDestinoInvalido;
import vistas.ExceptionOrigenInvalido;

public class TestBuscador {
	
	@Test
	public void busqueda_ParaLanchitaSeEnvianAtributosNullABusquedaYNoFiltraNada() throws ParseException, ExceptionDestinoInvalido, ExceptionOrigenInvalido {
		IAerolineaLanchita mockLanchita = mock(IAerolineaLanchita.class);
		AerolineaLanchita aerolineaLanchita = new AerolineaLanchita(mockLanchita);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaLanchita);
		Buscador buscador = Buscador.getInstance(aerolineas);
		ArrayList<ArrayList<String>> asientosLanchita = new LanchitaDummy().getAsientos();
		when(mockLanchita.asientosDisponibles(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosLanchita);
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		Busqueda busqueda = new Busqueda("","", "", "", "","",null,null, null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario, busqueda);
		Assert.assertEquals("La busqueda no acepta atributos nulos",new LanchitaDummy().getAsientos().size(),asientosEncontrados.size());
	}
	@Test
	public void busqueda_ParaOceanicSeEnvianAtributosNullABusquedaYNoFiltraNada() throws ParseException, ExceptionDestinoInvalido, ExceptionOrigenInvalido {
		IAerolineaOceanic mockOceanic = mock(IAerolineaOceanic.class);
		AerolineaOceanic aerolineaOceanic = new AerolineaOceanic(mockOceanic);
		ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
		aerolineas.add(aerolineaOceanic);
		Buscador buscador = new Buscador(aerolineas);
		ArrayList<AsientoDTO> asientosOceanic = new OceanicDummy().getAsientos();
		when(mockOceanic.asientosDisponiblesParaOrigen(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(asientosOceanic);
		UsuarioEstandar usuario = new UsuarioEstandar("Alejando","40135297");
		Busqueda busqueda = new Busqueda("","", "", "", "","",null,null, null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario, busqueda);
		System.out.println(new OceanicDummy().getAsientos().size());
		System.out.println(asientosEncontrados.size());
		System.out.println(asientosOceanic.size());
		Assert.assertEquals("La busqueda no acepta atributos nulos",0,asientosEncontrados.size());
	}
}

