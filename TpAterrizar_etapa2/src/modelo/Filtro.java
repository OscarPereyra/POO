package modelo;

import java.util.ArrayList;
//pasarle la busqueda completa, patron command
public abstract class Filtro {
	public abstract void aplicarFiltro(ArrayList<Asiento> asientos);
}