package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Asiento;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobrereserva extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Sobrereserva(Asiento asiento) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 15, 15));
		
		JPanel panelMensajeAsiento = new JPanel();
		contentPane.add(panelMensajeAsiento);
		
		JLabel lblMensajeAsiento = new JLabel("El asiento " + asiento.getCodigoAsiento() + " ya se encuentra reservado");
		panelMensajeAsiento.add(lblMensajeAsiento);
		
		JPanel panelPregunta = new JPanel();
		contentPane.add(panelPregunta);
		
		JLabel lblPregunta = new JLabel("\u00BFQue desea hacer?");
		panelPregunta.add(lblPregunta);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones);
		
		JButton btnSobrereservar = new JButton("Sobrereservar");
		btnSobrereservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccionExitosa reservoBien = new AccionExitosa(asiento,"sobrereservado");
				reservoBien.setVisible(true);
				dispose();
			}
		});
		panelBotones.add(btnSobrereservar);
		
		JButton btnSeguirBuscando = new JButton("Seguir buscando");
		btnSeguirBuscando.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panelBotones.add(btnSeguirBuscando);
	}

}
