package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField textOrigen;
	private JTextField textFecha;
	private JTextField textDestino0;
	private JTable table;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panelErrores = new JPanel();
		contentPane.add(panelErrores);
		
		JTextPane textPaneErrores = new JTextPane();
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
		
		table_1 = new JTable();
		scrollPane.add(table_1);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new GridLayout(1, 3, 15, 15));
		
		JButton btnComprar = new JButton("Comprar");
		panelBotones.add(btnComprar);
		btnComprar.setBounds(100, 100, 100, 40);
		
		JButton btnReservar = new JButton("Reservar");
		panelBotones.add(btnReservar);
		
		JButton btnCerrar = new JButton("Cerrar");
		panelBotones.add(btnCerrar);
	}
}