package vistas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Asiento;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccionExitosa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public AccionExitosa(Asiento asiento,String accion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 15, 15));
		
		JPanel panelMensaje = new JPanel();
		contentPane.add(panelMensaje);
		
		JLabel lblMensaje = new JLabel("El asiento " + asiento.getCodigoAsiento() + " ha sido " + accion + " exitosamente");
		panelMensaje.add(lblMensaje);
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton);
		
		JButton btnSeguirBuscando = new JButton("Seguir buscando");
		btnSeguirBuscando.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnSeguirBuscando.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSeguirBuscando.setHorizontalAlignment(SwingConstants.LEFT);
		panelBoton.add(btnSeguirBuscando);
	}

}
