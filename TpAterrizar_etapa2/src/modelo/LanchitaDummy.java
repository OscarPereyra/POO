package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LanchitaDummy implements IAerolineaLanchita {
	    private ArrayList<ArrayList<String>> asientos;
	    private Map<String, String> diccionarioDestinos;

	    public LanchitaDummy() {

	        this.diccionarioDestinos = new HashMap();
	        diccionarioDestinos.put("ARG", "123");
	        diccionarioDestinos.put("BRZ", "753");
	        diccionarioDestinos.put("ESP", "954");
	        diccionarioDestinos.put("COL", "742");

	        this.asientos = new ArrayList<ArrayList<String>>();
	        ArrayList<String> asiento1 = new ArrayList<String>();
			ArrayList<String> asiento2 = new ArrayList<String>();
			
			asiento1.add("EC0 123-42");
			asiento1.add("56500.60");
			asiento1.add("T");
			asiento1.add("V");
			asiento1.add("D");
			asiento1.add("18/06/2019");
			asiento1.add("25/06/2019");
			
			asiento2.add("EC0 742-66");
			asiento2.add("12000.30");
			asiento2.add("P");
			asiento2.add("P");
			asiento2.add("D");
			asiento2.add("18/06/2019");
			asiento2.add("25/06/2019");

			asientos.add(asiento1);
			asientos.add(asiento2);
	  	    }

	    @Override
	    public ArrayList<ArrayList<String>> asientosDisponibles(String origen,String fechaSalida,String horaSalida,String destino,String fechaLlegada,String horaLlegada) {
	        return (ArrayList<ArrayList<String>>) this.asientos
	                .stream()
	                .filter(x -> contiene(x, destino) && (x.get(4).equals("D") || x.get(4).equals("R")))
	                .collect(Collectors.toList());
	    }

	    private boolean contiene(ArrayList<String> asiento, String destino) {
	        return asiento.get(0).contains("EC0 " + this.diccionarioDestinos.getOrDefault(destino, "XXX"));
	    }

	    @Override
	    public void comprar(String codigoAsiento) throws AsientoLanchitaNoDisponibleException {
	        ArrayList<String> asiento = getAsiento(codigoAsiento);
	        if(estaDisponible(asiento)) {
	            actualizarRegistro(asiento, "C");
	        } else {
	            throw new AsientoLanchitaNoDisponibleException("Asiento no disponible");
	        }
	    }

	    private void actualizarRegistro(ArrayList<String> asiento, String nuevoEstado) {
	        ArrayList<String> asientoActualizado = new ArrayList<String>();
	        asientoActualizado.add(asiento.get(0));
	        asientoActualizado.add(asiento.get(1));
	        asientoActualizado.add(asiento.get(2));
	        asientoActualizado.add(asiento.get(3));
	        asientoActualizado.add(nuevoEstado);
	        asientoActualizado.add(asiento.get(5));
	        asientoActualizado.add(asiento.get(6));
	        this.asientos.remove(asiento);
	        this.asientos.add(asientoActualizado);
	    }

	    private boolean estaDisponible(ArrayList<String> asiento) {
	        return asiento.get(4).equals("D");
	    }

	    private ArrayList<String> getAsiento(String codigoAsiento) {
	        return this.asientos
	                    .stream()
	                    .filter(x -> x.get(0).equals(codigoAsiento))
	                    .collect(Collectors.toList())
	                    .get(0);
	    }

	    @Override
	    public void reservar(String codigoAsiento, String dni) throws AsientoLanchitaNoDisponibleException {
	        ArrayList<String> asiento = getAsiento(codigoAsiento);
	        if(estaDisponible(asiento)) {
	            actualizarRegistro(asiento, "R");
	        } else {
	            throw new AsientoLanchitaNoDisponibleException("Asiento no disponible");
	        }
	    }

	    private boolean estaReservado(ArrayList<String> asiento) {
	        return asiento.get(4).equals("R");
	    }

	    private boolean estaReservado(String codigoAsiento) {
	        ArrayList<String> asiento = getAsiento(codigoAsiento);
	        return estaReservado(asiento);
	    }
	}

