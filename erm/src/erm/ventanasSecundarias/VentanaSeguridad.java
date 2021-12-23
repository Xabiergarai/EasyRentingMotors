package erm.ventanasSecundarias;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

import javax.swing.JButton;
import java.awt.SystemColor;

public class VentanaSeguridad extends JFrame {
	//int a = VentanaLogin.getUsuarioId();
	
	private JPasswordField pfActual;
	private JPasswordField pfNueva;
	private JPasswordField pfConfirmarNueva;
	
	public VentanaSeguridad() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 449, 451);
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		
		JLabel lblCambiarContrasenya = new JLabel("Cambiar contrase\u00F1a");
		lblCambiarContrasenya.setForeground(new Color(255, 165, 0));
		lblCambiarContrasenya.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCambiarContrasenya.setBounds(121, 21, 223, 20);
		getContentPane().add(lblCambiarContrasenya);
		
		JLabel lblContrasenyaAntigua = new JLabel("Contrase\u00F1a actual");
		lblContrasenyaAntigua.setBounds(10, 75, 160, 20);
		getContentPane().add(lblContrasenyaAntigua);
		
		pfActual = new JPasswordField();
		pfActual.setBounds(10, 107, 398, 26);
		getContentPane().add(pfActual);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setBounds(10, 158, 160, 20);
		getContentPane().add(lblNuevaContrasea);
		
		pfNueva = new JPasswordField();
		pfNueva.setBounds(10, 189, 398, 26);
		getContentPane().add(pfNueva);
		
		JLabel label = new JLabel("Nueva contrase\u00F1a");
		label.setBounds(10, 243, 160, 20);
		getContentPane().add(label);
		
		pfConfirmarNueva = new JPasswordField();
		pfConfirmarNueva.setBounds(10, 274, 398, 26);
		getContentPane().add(pfConfirmarNueva);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 366, 160, 29);
		getContentPane().add(btnAtras);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(248, 367, 160, 26);
		getContentPane().add(btnCambiar);
		

		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				setVisible(false);
				
			}
		});
		
		/*btnCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				DBManager dbm = new DBManager();
				try {
					dbm.connect();
					Usuario user = dbm.buscarUsuarioId(a);
					if (user.getContrasenya().equals(passwordField.getText()) && passwordField_1.getText().equals(passwordField_2.getText())) {
						user.setContrasenya(passwordField_1.getText());
						dbm.cambiarContrsenya(user);
						JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "Confirmacion", 1);
						passwordField.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Los campos no coinciden o contraseña incorrecta", "Error", 0);
					}
					dbm.disconnect();
				} catch (DBException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		
		*/
	}
}
