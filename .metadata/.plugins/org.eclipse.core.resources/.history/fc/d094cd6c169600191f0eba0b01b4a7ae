package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AccionExitosa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccionExitosa frame = new AccionExitosa();
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
	public AccionExitosa() {
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
		
		JButton btnSeguirBuscando = new JButton("Seguir buscando");
		btnSeguirBuscando.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSeguirBuscando.setHorizontalAlignment(SwingConstants.LEFT);
		panelBoton.add(btnSeguirBuscando);
	}

}
