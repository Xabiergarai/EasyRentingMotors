package erm.ventanasAdminstrador;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaInicioAdmin extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public VentanaInicioAdmin() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		lblNewLabel.setBounds(124, 27, 327, 85);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(83, 187, 119, 25);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasenya.setEnabled(true);
		lblContrasenya.setBounds(83, 281, 119, 25);
		getContentPane().add(lblContrasenya);
		
		textField = new JTextField();
		textField.setBounds(276, 172, 190, 38);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(276, 268, 190, 38);
		getContentPane().add(textField_1);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(162, 414, 107, 38);
		getContentPane().add(btnAtras);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(293, 414, 107, 38);
		getContentPane().add(btnEntrar);
	}
}
