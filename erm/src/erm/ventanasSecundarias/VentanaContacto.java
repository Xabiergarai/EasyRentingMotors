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

public class VentanaContacto extends JFrame {
	
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
		
		JLabel lblFutstoregmaileu = new JLabel();
		lblFutstoregmaileu.setText("ERMotors@gmail.eu");
		lblFutstoregmaileu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFutstoregmaileu.setFocusable(false);
		lblFutstoregmaileu.setBounds(166, 77, 240, 41);
		getContentPane().add(lblFutstoregmaileu);
		
		JLabel lblFutstoreInstagram = new JLabel();
		lblFutstoreInstagram.setText("ERMotors Instagram");
		lblFutstoreInstagram.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFutstoreInstagram.setFocusable(false);
		lblFutstoreInstagram.setBounds(166, 152, 300, 41);
		getContentPane().add(lblFutstoreInstagram);
		
		JTextArea txtrconsigueCualquierCamiseta = new JTextArea();
		txtrconsigueCualquierCamiseta.setText("\"Consigue el coche de tus sue\u00F1os a traves de\r\n nuestra pagina, a un precio unico\"");
		txtrconsigueCualquierCamiseta.setOpaque(false);
		txtrconsigueCualquierCamiseta.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrconsigueCualquierCamiseta.setBounds(27, 256, 397, 81);
		getContentPane().add(txtrconsigueCualquierCamiseta);
		
		JButton Volver = new JButton("Atras");
		Volver.setBounds(10, 371, 104, 29);
		getContentPane().add(Volver);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}

		});
		
	
		btnNewButton.setBounds(50, 80, 52, 38);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://www.instagram.com/_futtstore_/?hl=es");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
		});
	
		btnNewButton_1.setBounds(50, 155, 52, 38);
		getContentPane().add(btnNewButton_1);
		
		JButton btnCafe = new JButton("\u00BFUn caf\u00E9?");
		btnCafe.setBounds(285, 371, 121, 29);
		getContentPane().add(btnCafe);
		btnCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://paypal.me/gutiaitor");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
		});
		
		Volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			  VentanaAjustes v1 = new VentanaAjustes();
			  v1.setVisible(true);
			  dispose();
				
			}
			
		});
		
		
	/*	panelInstagram.addAncestorListener((AncestorListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
		}); */
	}
}
