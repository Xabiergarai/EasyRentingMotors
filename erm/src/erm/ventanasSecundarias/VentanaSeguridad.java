package erm.ventanasSecundarias;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

import erm.clasesBasicas.Usuario;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaLogIn;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class VentanaSeguridad extends JFrame {
	int a = VentanaLogIn.getUsuarioId();
	
	private JPasswordField pfActual;
	private JPasswordField pfNueva;
	private JPasswordField pfConfirmarNueva;
	private JPanel panelNorte, panelCentro, panelBotonera;
	
	public VentanaSeguridad() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 449, 379);
		getContentPane().setBackground(SystemColor.menu);
		
		panelNorte = new JPanel();
		panelBotonera = new JPanel();
		panelCentro = new JPanel();
		
		JLabel lblCambiarContrasenya = new JLabel("Cambiar contrase\u00F1a");
		lblCambiarContrasenya.setForeground(new Color(255, 165, 0));
		lblCambiarContrasenya.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		lblCambiarContrasenya.setBounds(128, 23, 223, 20);
		panelNorte.add(lblCambiarContrasenya);
		
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelCentro.setLayout(null);
		
		JLabel lblContrasenyaAntigua = new JLabel("Contrase\u00F1a actual");
		lblContrasenyaAntigua.setBounds(10, 50, 165, 14);
		panelCentro.add(lblContrasenyaAntigua);
		
		pfActual = new JPasswordField();
		pfActual.setBounds(185, 44, 208, 20);
		panelCentro.add(pfActual);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setBounds(10, 114, 139, 14);
		panelCentro.add(lblNuevaContrasea);
		
		pfNueva = new JPasswordField();
		pfNueva.setBounds(185, 111, 208, 20);
		panelCentro.add(pfNueva);
		
		JLabel label = new JLabel("Confirmar nueva contrase\u00F1a");
		label.setBounds(10, 177, 165, 14);
		panelCentro.add(label);
		
		pfConfirmarNueva = new JPasswordField();
		pfConfirmarNueva.setBounds(185, 174, 208, 20);
		panelCentro.add(pfConfirmarNueva);
		
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 366, 160, 29);
		panelBotonera.add(btnAtras);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(248, 367, 160, 26);
		panelBotonera.add(btnCambiar);
		
		getContentPane().add(panelBotonera, BorderLayout.SOUTH);

		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				DBManager dbm = new DBManager();
				try {
					
					dbm.initBD("EasyRentingMotors.db");
					Usuario user = dbm.buscarUsuarioId(a);
					if (user.getContrasenya().equals(pfActual.getText()) && pfNueva.getText().equals(pfConfirmarNueva.getText())) {
						user.setContrasenya(pfNueva.getText());
						dbm.cambiarContrasenya(user);
						JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
						pfActual.setText("");
						pfNueva.setText("");
						pfConfirmarNueva.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Los campos no coinciden o contraseña incorrecta", "Error", 0);
					}
					dbm.disconnect();
				} catch (DBException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		
	}
}
