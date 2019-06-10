package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Reservas extends JFrame {

	private JPanel contentPane;
	private JTable tableReservas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Reservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblComprasDe = new JLabel("Reservas de");
		lblComprasDe.setHorizontalAlignment(SwingConstants.CENTER);
		panelReservas.add(lblComprasDe);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelReservas.add(lblNombre);
		
		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos);
		
		tableReservas = new JTable();
		panelDatos.add(tableReservas);
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton);
		panelBoton.setLayout(new GridLayout(1, 3, 15, 15));
		
		JButton btnCerrar = new JButton("Cerrar");
		panelBoton.add(btnCerrar);
				
		Container cp = getContentPane();
		cp.add(panelReservas, BorderLayout.NORTH);
		cp.add(panelDatos, BorderLayout.CENTER);
		cp.add(panelBoton, BorderLayout.SOUTH);
	}
}