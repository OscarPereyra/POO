package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Fecha;
import modelo.Usuario;
import modelo.UsuarioEstandar;
import viewModel.BuscarViewModel;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new UsuarioEstandar("Alejandro","40135297");
	Fecha parserFecha = new Fecha();
	private JPanel contentPane;
	
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
		
		JLabel lblNombre = new JLabel(usuario.getNombre());
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
		btnCompras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Operacion vistaCompras = new Operacion(usuario,usuario.getCompras(),"Compras");
				vistaCompras.setVisible(true);
			}
		});
		panelBotones.add(btnCompras);
		
		JButton btnReservas = new JButton("Ver reservas");
		btnReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Operacion vistaReservas = new Operacion(usuario,usuario.getReservas(),"Resevas");
				vistaReservas.setVisible(true);
			}
		});
		panelBotones.add(btnReservas);
		
		JButton btnAsientos = new JButton("Buscar Asientos");
		btnAsientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Buscar vistaBuscar = new Buscar(new BuscarViewModel(usuario));
				vistaBuscar.setVisible(true);
			}
		});
		panelBotones.add(btnAsientos);
	}
	
}
