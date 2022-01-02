package erm.ventanasAdministrador;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasSecundarias.VentanaAjustes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaInicioAdmin extends JFrame {
	private JTextField textoUsuario;
	private JPasswordField textoContrasenya;
	private JPanel contentPane;
	
	public VentanaInicioAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("ADMINISTRADOR");
		lblTitulo.setForeground(new Color(255, 165, 0));
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		lblTitulo.setBounds(142, 22, 289, 85);
		getContentPane().add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(134, 145, 119, 25);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasenya.setEnabled(true);
		lblContrasenya.setBounds(134, 208, 119, 25);
		getContentPane().add(lblContrasenya);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(276, 132, 190, 38);
		getContentPane().add(textoUsuario);
		textoUsuario.setColumns(10);
		
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(156, 307, 107, 25);
		btnAtras.addActionListener(e -> {
			// TODO Auto-generated method stub
			VentanaLogIn vl = new VentanaLogIn();
			vl.setVisible(true);
			dispose();

		});
		
		getContentPane().add(btnAtras);
		
		JButton btnEntrar = new JButton("Acceder");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String usuario = textoUsuario.getText();
				String contrasenya = textoContrasenya.getText();
				
				if(usuario.equals("admin")&& contrasenya.equals("admin123")) {

					JOptionPane.showMessageDialog(null, "Bienvenido al modo administrador", "Aceptado", JOptionPane.INFORMATION_MESSAGE);
					VentanaAdmin vl = new VentanaAdmin();
					vl.setVisible(true);
					dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "No has introducido los datos correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEntrar.setBounds(276, 307, 107, 25);
		getContentPane().add(btnEntrar);
		
		textoContrasenya = new JPasswordField();
		textoContrasenya.setBounds(276, 205, 190, 38);
		getContentPane().add(textoContrasenya);
		
		JLabel lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon("imagenes/iconoAdmin.png"));
		lblIconoUsuario.setBounds(59, 121, 40, 49);
		contentPane.add(lblIconoUsuario);
		
		JLabel lblIconoContraseņa = new JLabel("");
		lblIconoContraseņa.setIcon(new ImageIcon("imagenes/iconoContrasenya.png"));
		lblIconoContraseņa.setBounds(71, 208, 40, 25);
		contentPane.add(lblIconoContraseņa);
	}
}
