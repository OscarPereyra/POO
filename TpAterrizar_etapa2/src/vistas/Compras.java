package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Compras extends JFrame {

	private JPanel contentPane;
	private JTable tableCompras;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Compras frame = new Compras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Compras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		GridLayout gl = new GridLayout(3,1,0,0);
		contentPane.setLayout(gl);
		
		JPanel panelCompras = new JPanel();
		contentPane.add(panelCompras);
		panelCompras.setLayout(new GridLayout(1, 2, 15, 15));
		
		JLabel lblComprasDe = new JLabel("Compras de");
		lblComprasDe.setHorizontalAlignment(SwingConstants.CENTER);
		panelCompras.add(lblComprasDe);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelCompras.add(lblNombre);
		
		JScrollPane scrollPaneDatos = new JScrollPane();
		contentPane.add(scrollPaneDatos);
		
		table = new JTable();
		scrollPaneDatos.setViewportView(table);
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton);
		panelBoton.setLayout(new GridLayout(1, 3, 15, 15));
		
		JButton btnCerrar = new JButton("Cerrar");
		panelBoton.add(btnCerrar);
				
		Container cp = getContentPane();
		cp.add(panelCompras, BorderLayout.NORTH);
		cp.add(scrollPaneDatos, BorderLayout.CENTER);
		cp.add(panelBoton, BorderLayout.SOUTH);	
	}
}