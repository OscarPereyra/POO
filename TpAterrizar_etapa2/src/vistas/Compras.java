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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Compras extends JFrame {

	private JPanel contentPane;
	private JTable tableCompras;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		setContentPane(contentPane);
		GridLayout gl = new GridLayout(3,1,0,0);
		contentPane.setLayout(gl);
		
		JPanel panelCompras = new JPanel();
		contentPane.add(panelCompras);
		panelCompras.setLayout(new GridLayout(1, 1, 15, 15));
		
		JButton btnCerrar = new JButton("Cerrar");
		panelCompras.add(btnCerrar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelCompras.add(lblNombre);
		
		JLabel lblComprasDe = new JLabel("Compras de");
		contentPane.add(lblComprasDe);
		lblComprasDe.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton);
		panelBoton.setLayout(new GridLayout(1, 1, 15, 15));
		cp.add(panelBoton, BorderLayout.SOUTH);		
		
		JScrollPane scrollPaneDatos = new JScrollPane();
		panelBoton.add(scrollPaneDatos);
		
		table = new JTable();
		scrollPaneDatos.setViewportView(table);
		
		Container cp = getContentPane();
		cp.add(panelCompras, BorderLayout.NORTH);
	}
}