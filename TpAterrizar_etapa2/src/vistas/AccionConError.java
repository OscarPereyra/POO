package vistas;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Asiento;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccionConError extends JFrame {

	private JPanel contentPane;

	public AccionConError(String descripcionDelError,String accion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 15, 15));
		
		JPanel panelMensaje = new JPanel();
		contentPane.add(panelMensaje);
		
		JLabel lblMensaje = new JLabel("Ha ocurrido un error en su " + accion + " " + descripcionDelError + ". Por favor intente nuevamente");
		panelMensaje.add(lblMensaje);
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnAceptar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAceptar.setHorizontalAlignment(SwingConstants.LEFT);
		panelBoton.add(btnAceptar);
	}

}
