package modelo;

	import java.util.ArrayList;
	import java.util.Collections;

	public class CriterioOrdenamientoPrecioDescendente extends CriterioOrdenamiento {
		@Override
		public void AplicarCriterio(ArrayList<Asiento> asientos) {
			Collections.sort(asientos, asientos.getPrecio());
			Collections.reverse(asientos);
			}
		}
