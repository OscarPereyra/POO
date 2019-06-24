package vistas;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AccionConError extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AccionConError frame = new AccionConError();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccionConError() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 15, 15));
		
		JPanel panelMensaje = new JPanel();
		contentPane.add(panelMensaje);
		
		JLabel lblMensaje = new JLabel("");
		panelMensaje.add(lblMensaje);
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAceptar.setHorizontalAlignment(SwingConstants.LEFT);
		panelBoton.add(btnAceptar);
	}

}
