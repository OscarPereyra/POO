package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Window;

import modelo.Usuario;
import viewModel.ComprasTableModel;
import viewModel.ReservasTableModel;
import viewModel.ReservasViewModel;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Reservas extends JFrame {

	private JPanel contentPane;
	private JTable tableReservas;
	private Usuario usuario;

	public Reservas() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		GridLayout gl = new GridLayout(3,1,0,0);
		contentPane.setLayout(gl);
		
		JPanel panelReservas = new JPanel();
		contentPane.add(panelReservas);
		panelReservas.setLayout(new GridLayout(1, 2, 15, 15));
		
		JLabel lblReservasDe = new JLabel("Reservas de " );
		lblReservasDe.setHorizontalAlignment(SwingConstants.CENTER);
		panelReservas.add(lblReservasDe);
		
		JLabel lblNombre = new JLabel(usuario.getNombre());
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelReservas.add(lblNombre);
		
		JScrollPane scrollPaneDatos = new JScrollPane();
		contentPane.add(scrollPaneDatos);
		
		tableReservas = new JTable();
		scrollPaneDatos.setViewportView(tableReservas);
		tableReservas.setModel(new ReservasTableModel(modelo));
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton);
		panelBoton.setLayout(new GridLayout(1, 3, 15, 15));
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					dispose();
				} 	
		});
		panelBoton.add(btnCerrar);
				
		Container cp = getContentPane();
		cp.add(panelReservas, BorderLayout.NORTH);
		cp.add(scrollPaneDatos, BorderLayout.CENTER);
		cp.add(panelBoton, BorderLayout.SOUTH);
	}
}