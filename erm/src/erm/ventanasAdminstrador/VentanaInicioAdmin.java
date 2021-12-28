package erm.ventanasAdminstrador;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasSecundarias.VentanaAjustes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class VentanaInicioAdmin extends JFrame {
	private JTextField textoUsuario;
	private JPasswordField textoContrasenya;
	private JPanel contentPane;
	
	public VentanaInicioAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("ADMINISTRADOR");
		lblTitulo.setForeground(new Color(255, 140, 0));
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 40));
		lblTitulo.setBounds(124, 27, 327, 85);
		getContentPane().add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(83, 187, 119, 25);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasenya.setEnabled(true);
		lblContrasenya.setBounds(83, 281, 119, 25);
		getContentPane().add(lblContrasenya);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(276, 172, 190, 38);
		getContentPane().add(textoUsuario);
		textoUsuario.setColumns(10);
		
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(162, 414, 107, 38);
		btnAtras.addActionListener(e -> {
			// TODO Auto-generated method stub
			VentanaLogIn vl = new VentanaLogIn();
			vl.setVisible(true);
			dispose();

		});
		

		getContentPane().add(btnAtras);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(293, 414, 107, 38);
		getContentPane().add(btnEntrar);
		
		textoContrasenya = new JPasswordField();
		textoContrasenya.setBounds(276, 269, 190, 38);
		getContentPane().add(textoContrasenya);
	}
}
