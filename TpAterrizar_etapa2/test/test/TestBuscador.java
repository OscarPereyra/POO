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
		Busqueda busqueda = new Busqueda(null,null, null, null, null,null,null,null, null, null);
		ArrayList<Asiento> asientosEncontrados = buscador.busqueda(usuario, busqueda);
		System.out.println(asientosLanchita.size());
		System.out.println(asientosEncontrados.size());
		System.out.println(new LanchitaDummy().getAsientos().size());
		Assert.assertEquals("La busqueda no acepta atributos nulos",new LanchitaDummy().getAsientos().size(),asientosEncontrados.size());
	}
	
	/*private ArrayList<ArrayList<String>> lanchitaAsientos(){
		ArrayList<ArrayList<String>> asientosLanchita = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> asiento1 = new ArrayList<String>();
		ArrayList<String> asiento2 = new ArrayList<String>();
		
		asiento1.add("EC0344-42");
		asiento1.add("56500.60");
		asiento1.add("P");
		asiento1.add("P");
		asiento1.add("D");
		asiento1.add("18/06/2019");
		asiento1.add("25/06/2019");
		
		asiento2.add("EC0344-66");
		asiento2.add("12000.30");
		asiento2.add("P");
		asiento2.add("P");
		asiento2.add("D");
		asiento2.add("18/06/2019");
		asiento2.add("25/06/2019");

		asientosLanchita.add(asiento1);
		asientosLanchita.add(asiento2);
		return asientosLanchita;
	}
	private ArrayList<Asiento> AsientosEsperados(){
		ArrayList<Asiento> asientosEsperados = new ArrayList<Asiento>();
		Asiento asiento1 = new Asiento("EC0344-42",56500.60,TipoClaseAsiento.PRIMERA,TipoUbicacionAsiento.PASILLO,true,18062019,25062019,new Aerolinea(mockLanchita));
		Asiento asiento2 = new Asiento("EC0344-66",12000.30,TipoClaseAsiento.PRIMERA,TipoUbicacionAsiento.PASILLO,true,18062019,25062019);

		asientosEsperados.add(asiento1);
		asientosEsperados.add(asiento2);
		return asientosEsperados;
	}*/
}

