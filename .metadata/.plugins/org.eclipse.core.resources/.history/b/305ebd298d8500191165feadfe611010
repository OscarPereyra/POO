package modelo;

public class AerolineaLanchita extends Aerolinea{
	IAerolineaLanchita aerolinea;
	@Override
	void reservar(Usuario usuario, Asiento asiento) {
		if(asiento.getEstadoReservado()) {
			asientosReservados.add(new AsientoReservado(asiento,usuario));
		}
		else {
			aerolinea.reservar(asiento.getCodigoAsiento(),usuario.getDNI());
		}
	}

	@Override
	void comprar(Usuario usuario, Asiento asiento) {
		
	}

	@Override
	void asientosDisponibles() {
		
	}

}
