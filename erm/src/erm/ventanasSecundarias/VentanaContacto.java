package erm.ventanasSecundarias;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class VentanaContacto extends JFrame {

	/**
	 * Creamos la ventana
	 */
	
	public VentanaContacto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JLabel lblproblemasdudasContactanos = new JLabel("\u00BFProblemas? \u00BFDudas? Contactanos !!!");
		lblproblemasdudasContactanos.setForeground(new Color(255, 165, 0));
		lblproblemasdudasContactanos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblproblemasdudasContactanos.setBounds(27, 11, 379, 38);
		getContentPane().add(lblproblemasdudasContactanos);

		JLabel lblGmaileu = new JLabel();
		lblGmaileu.setText("ERMotors@gmail.eu");
		lblGmaileu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGmaileu.setFocusable(false);
		lblGmaileu.setBounds(166, 77, 240, 41);
		getContentPane().add(lblGmaileu);

		JLabel lblFutstoreInstagram = new JLabel();
		lblFutstoreInstagram.setText("ERMotors Instagram");
		lblFutstoreInstagram.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFutstoreInstagram.setFocusable(false);
		lblFutstoreInstagram.setBounds(166, 152, 300, 41);
		getContentPane().add(lblFutstoreInstagram);

		JTextArea txtCoche = new JTextArea();
		txtCoche.setText("\"Consigue el coche de tus sue\u00F1os a traves de\r\n nuestra pagina, a un precio unico\"");
		txtCoche.setOpaque(false);
		txtCoche.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtCoche.setBounds(27, 256, 397, 81);
		getContentPane().add(txtCoche);

		JButton btnVolver = new JButton("Atras");
		btnVolver.setBounds(10, 371, 104, 29);
		getContentPane().add(btnVolver);

		JButton btnGmail = new JButton("");
		btnGmail.setBackground(new Color(255, 255, 255));
		btnGmail.setIcon(new ImageIcon("imagenes/iconoGmail.png"));
		btnGmail.setFocusPainted(false);
		btnGmail.setBorderPainted(false);
		btnGmail.setContentAreaFilled(false);
		
		btnGmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI(
									"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
							desktop.browse(uri);
						} catch (URISyntaxException | IOException ex) {
						}
					}
				}

			}

		});

		btnGmail.setBounds(72, 89, 42, 29);
		getContentPane().add(btnGmail);

		JButton btnInstagram = new JButton("");
		btnInstagram.setBackground(new Color(255, 255, 255));
		btnInstagram.setIcon(new ImageIcon("imagenes/iconoInstagram.png"));
		btnInstagram.setFocusPainted(false);
		btnInstagram.setBorderPainted(false);
		btnInstagram.setContentAreaFilled(false);

		btnInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://www.instagram.com/_ermotors_/?hl=es");
							desktop.browse(uri);
						} catch (URISyntaxException | IOException ex) {
						}
					}
				}

			}
		});

		btnInstagram.setBounds(71, 155, 43, 38);
		getContentPane().add(btnInstagram);

		JButton btnCafe = new JButton("\u00BFUn caf\u00E9?");
		btnCafe.setBounds(285, 371, 121, 29);
		getContentPane().add(btnCafe);
		btnCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://paypal.me/gutiaitor");
							desktop.browse(uri);
						} catch (URISyntaxException | IOException ex) {
						}
					}
				}

			}
		});

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes v1 = new VentanaAjustes();
				v1.setVisible(true);
				dispose();

			}

		});
	}
}
