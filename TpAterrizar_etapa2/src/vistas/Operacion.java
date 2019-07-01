package vistas;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;
import modelo.Asiento;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import viewModel.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Operacion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableCompras;
	
	public Operacion(Usuario usuario,ArrayList<Asiento> asientos, String operacion) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		
		JLabel lblComprasDe = new JLabel(operacion + " de " + usuario.getNombre());
		lblComprasDe.setHorizontalAlignment(SwingConstants.CENTER);
		panelCompras.add(lblComprasDe);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelCompras.add(lblNombre);
		
		JScrollPane scrollPaneDatos = new JScrollPane();
		contentPane.add(scrollPaneDatos);
		
		tableCompras = new JTable();
		scrollPaneDatos.setViewportView(tableCompras);
		tableCompras.setModel(new OperacionTableModel(asientos));
		
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
		cp.add(panelCompras, BorderLayout.NORTH);
		cp.add(scrollPaneDatos, BorderLayout.CENTER);
		cp.add(panelBoton, BorderLayout.SOUTH);	
		
		
	}

}