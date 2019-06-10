package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Sobrereserva extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobrereserva frame = new Sobrereserva();
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
	public Sobrereserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 15, 15));
		
		JPanel panelMensajeAsiento = new JPanel();
		contentPane.add(panelMensajeAsiento);
		
		JLabel lblMensajeAsiento = new JLabel("");
		panelMensajeAsiento.add(lblMensajeAsiento);
		
		JPanel panelPregunta = new JPanel();
		contentPane.add(panelPregunta);
		
		JLabel lblPregunta = new JLabel("\u00BFQue desea hacer?");
		panelPregunta.add(lblPregunta);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones);
		
		JButton btnSobrereservar = new JButton("Sobrereservar");
		panelBotones.add(btnSobrereservar);
		
		JButton btnSeguirBuscando = new JButton("Seguir buscando");
		panelBotones.add(btnSeguirBuscando);
	}

}
