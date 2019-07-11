package vistas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Asiento;
import viewModel.BuscarTableModel;
import viewModel.BuscarViewModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class Buscar extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOrigen;
	private JTextField textFecha;
	private JTextField textDestino0;
	private JTable tableBuscar;
	private BuscarViewModel modelo;

	public Buscar(BuscarViewModel modelo) {
		this.modelo = modelo;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panelErrores = new JPanel();
		contentPane.add(panelErrores);
		
		JTextPane textPaneErrores = new JTextPane();
		textPaneErrores.setEditable(false);
		panelErrores.add(textPaneErrores);
		
		JPanel panelFiltros = new JPanel();
		contentPane.add(panelFiltros, BorderLayout.CENTER);
		panelFiltros.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelOrigenFecha = new JPanel();
		panelFiltros.add(panelOrigenFecha);
		panelOrigenFecha.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelOrigen = new JPanel();
		panelOrigenFecha.add(panelOrigen);
		
		JLabel lblOrigen = new JLabel("Origen:");
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		panelOrigen.add(lblOrigen);
		
		textOrigen = new JTextField();
		textOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		panelOrigen.add(textOrigen);
		textOrigen.setColumns(10);
		
		JPanel panelFecha = new JPanel();
		panelOrigenFecha.add(panelFecha);
		
		JLabel lblFecha = new JLabel("Fecha:");
		panelFecha.add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFecha.add(textFecha);
		textFecha.setColumns(10);
		
		JPanel panelBuscqueda = new JPanel();
		panelOrigenFecha.add(panelBuscqueda);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					modelo.buscar(textDestino0.getText(),textOrigen.getText(), textFecha.getText());
					BuscarTableModel mod = new BuscarTableModel(modelo.getAsientos());
					tableBuscar.setModel(mod);
			        tableBuscar.revalidate();
			        tableBuscar.repaint();
			        tableBuscar.clearSelection();
			        mod.fireTableDataChanged();
				} catch (ParseException | ExceptionOrigenInvalido | ExceptionDestinoInvalido e) {
					textPaneErrores.setText(e.getMessage());
				}
			}
		});
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		panelBuscqueda.add(btnBuscar);
		
		JPanel panelDestino = new JPanel();
		panelFiltros.add(panelDestino, BorderLayout.CENTER);
		panelDestino.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelDestino.add(panel);
		
		JLabel labelDestino = new JLabel("Destino:");
		labelDestino.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelDestino);
		
		textDestino0 = new JTextField();
		textDestino0.setHorizontalAlignment(SwingConstants.RIGHT);
		textDestino0.setColumns(10);
		panel.add(textDestino0);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		tableBuscar = new JTable();
		scrollPane.setViewportView(tableBuscar);
		tableBuscar.setModel(new BuscarTableModel());
		tableBuscar.getSelectionModel().addListSelectionListener(e -> onSeleccionar());
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new GridLayout(1, 3, 15, 15));
		
		JButton btnComprar = new JButton("Comprar");
		panelBotones.add(btnComprar);
		btnComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					modelo.comprar(modelo.getAsientoSeleccionado());
					AccionExitosa comproBien = new AccionExitosa(modelo.getAsientoSeleccionado(),"comprado");
					comproBien.setVisible(true);
					modelo.setAsientoSeleccionado(null);
				} catch (Exception e) {	
					AccionConError comproMal = new AccionConError("Error al realizar la compra","compra");
					comproMal.setVisible(true);
				}
			} 
		});
		btnComprar.setBounds(100, 100, 100, 40);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					modelo.reservar(modelo.getAsientoSeleccionado());
				} catch (Exception e) {	
					AccionConError reservoMal = new AccionConError("Error al realizar la reserva","reserva");
					reservoMal.setVisible(true);
				}
			} 
		});
		panelBotones.add(btnReservar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					dispose();
				} 	
		});
		panelBotones.add(btnCerrar);
	}
	
	private void onSeleccionar() {
		int row = tableBuscar.convertRowIndexToModel(tableBuscar.getSelectedRow());
        if(row > -1) {
            BuscarTableModel model = (BuscarTableModel) tableBuscar.getModel();
            Asiento seleccionado = model.getRowAt(row);
            modelo.setAsientoSeleccionado(seleccionado);
        }
	}
}