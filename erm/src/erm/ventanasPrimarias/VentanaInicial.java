package erm.ventanasPrimarias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.*;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import erm.dataBase.DBException;

public class VentanaInicial extends JFrame {

	/**
	 * Desde donde se ejecuta la aplicación
	 * 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public VentanaInicial() {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 638, 639);

		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.addActionListener(e -> {
			VentanaRegistro vr = null;
			try {
				vr = new VentanaRegistro();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vr.setVisible(true);
			dispose();
		});

		btnRegistro.setBounds(317, 518, 284, 48);
		getContentPane().add(btnRegistro);

		JLabel lblTitulo = new JLabel("EASY RENTING MOTORS");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Algerian", Font.BOLD, 40));
		lblTitulo.setBounds(23, 28, 564, 71);
		getContentPane().add(lblTitulo);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBorderPainted(true);
		btnLogin.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(null, "Introduzca sus credenciales", "login",
					JOptionPane.INFORMATION_MESSAGE);
			VentanaLogIn vi = null;
			vi = new VentanaLogIn();
			vi.setVisible(true);
			

			dispose();

		});

		btnLogin.setBounds(23, 518, 284, 48);
		getContentPane().add(btnLogin);

		JLabel lblBienvenido = new JLabel("\u00A1BIENVENID@ AL MEJOR CONCESIONARIO DEL MUNDO!");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Zilla Slab", Font.ITALIC, 18));
		lblBienvenido.setBounds(23, 110, 554, 14);
		getContentPane().add(lblBienvenido);

		JLabel lblLogo1 = new JLabel("Logo");
		lblLogo1.setBounds(160, 210, 313, 246);
		ImageIcon ico = new ImageIcon("imagenes/logo.png");
		ImageIcon img = new ImageIcon(
		ico.getImage().getScaledInstance(lblLogo1.getWidth(), lblLogo1.getHeight(), Image.SCALE_SMOOTH));
		lblLogo1.setIcon(img);
		getContentPane().add(lblLogo1);

	}
}
