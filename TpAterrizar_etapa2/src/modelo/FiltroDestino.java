package modelo;

import java.util.ArrayList;

public class FiltroDestino extends Filtro {
		private String destino;
		public void Filtro (String destino) {
			this.destino = destino;
		}
		@Override
		public void aplicarFiltro(ArrayList<Asiento> asientos) {
				if(destino!=null) {asientos.removeIf(asiento -> !(asiento.getDestino().equals(destino)));}
		}			
}