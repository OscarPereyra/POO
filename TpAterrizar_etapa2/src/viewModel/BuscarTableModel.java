package viewModel;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modelo.Asiento;
import modelo.Fecha;
import modelo.TipoClaseAsiento;
import modelo.TipoUbicacionAsiento;

public class BuscarTableModel extends AbstractTableModel  {
	Fecha parserFecha = new Fecha();
	ArrayList<Asiento> asientos;
	String[] columnas = {"Aerolinea","Codigo Vuelo","Codigo Asiento","Precio","Ubicacion","Clase"};
	Class[] clases = {String.class,String.class,String.class,Double.class,TipoUbicacionAsiento.class,TipoClaseAsiento.class};
	
	public BuscarTableModel() {
		this.asientos = new ArrayList<Asiento>();
	}
	
	public BuscarTableModel(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}
	
	@Override
	public int getColumnCount() {
		return clases.length;
	}

	@Override
	public int getRowCount() {
		return asientos.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Asiento asiento = getRowAt(row);
        switch (column) {
            case 0:
                return asiento.getAerolinea().getNombre();
            case 1:
                String codigoVuelo = asiento.getCodigoAsiento().split("-")[0];
                return codigoVuelo;
            case 2:
                String codigoAsiento = asiento.getCodigoAsiento().split("-")[1];
                return codigoAsiento;
            case 3:
                return asiento.getPrecio();
            case 4:
                return asiento.getUbicacion();
            case 5:
                return asiento.getClase();
            default:
                return "";
        }
	}
	
	public Asiento getRowAt(int posicion) {
        try {
            return asientos.get(posicion);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
	
	public String getColumnName(int columna) {
		return columnas[columna];
	}

}
