package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridLayout gl = new GridLayout(3,1,0,0);
		contentPane.setLayout(gl);
		
		JPanel panelSaludo = new JPanel();
		contentPane.add(panelSaludo);
		panelSaludo.setLayout(new GridLayout(1, 4, 15, 15));
		
		JLabel lblVacio_1 = new JLabel("");
		panelSaludo.add(lblVacio_1);
		
		JLabel lblHola = new JLabel("Hola");
		lblHola.setHorizontalAlignment(SwingConstants.CENTER);
		panelSaludo.add(lblHola);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelSaludo.add(lblNombre);
		
		JLabel lblVacio_2 = new JLabel("");
		lblVacio_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelSaludo.add(lblVacio_2);
		
		JPanel panelPregunta = new JPanel();
		contentPane.add(panelPregunta);
		panelPregunta.setLayout(new GridLayout(1, 0, 15, 15));
		
		JLabel lblPregunta = new JLabel("\u00BFQue desea hacer?");
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		panelPregunta.add(lblPregunta);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones);
		panelBotones.setLayout(new GridLayout(1, 3, 15, 15));
		
		JButton btnCompras = new JButton("Ver Compras");
		panelBotones.add(btnCompras);
		
		JButton btnReservas = new JButton("Ver reservas");
		panelBotones.add(btnReservas);
		
		JButton btnAsientos = new JButton("Buscar Asientos");
		panelBotones.add(btnAsientos);
	}
}
