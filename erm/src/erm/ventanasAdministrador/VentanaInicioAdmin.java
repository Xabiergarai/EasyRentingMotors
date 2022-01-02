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
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBounds(5, 60, 547, 248);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("ADMINISTRADOR");
		lblTitulo.setForeground(new Color(255, 165, 0));
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));

		JPanel panelNorte = new JPanel();
		panelNorte.setBounds(5, 5, 547, 54);
		panelNorte.add(lblTitulo);
		contentPane.add(panelNorte);
		panelCentro.setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(139, 73, 67, 25);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCentro.add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setBounds(139, 142, 100, 25);
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasenya.setEnabled(true);
		panelCentro.add(lblContrasenya);
		
		textoUsuario = new JTextField();
		textoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textoUsuario.setBounds(278, 61, 172, 37);
		panelCentro.add(textoUsuario);
		
		
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(e -> {
			// TODO Auto-generated method stub
			VentanaLogIn vl = new VentanaLogIn();
			vl.setVisible(true);
			dispose();

		});
		
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
		
		textoContrasenya = new JPasswordField();
		textoContrasenya.setBounds(278, 130, 172, 37);
		panelCentro.add(textoContrasenya);
		
		JLabel lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setBounds(72, 61, 39, 37);
		lblIconoUsuario.setIcon(new ImageIcon("imagenes/iconoAdmin.png"));
		panelCentro.add(lblIconoUsuario);
		
		JLabel lblIconoContraseņa = new JLabel("");
		lblIconoContraseņa.setBounds(82, 142, 39, 25);
		lblIconoContraseņa.setIcon(new ImageIcon("imagenes/iconoContrasenya.png"));
		panelCentro.add(lblIconoContraseņa);
		
		JPanel panelBotonera = new JPanel();
		panelBotonera.setBounds(5, 309, 547, 33);
		panelBotonera.add(btnAtras);
		panelBotonera.add(btnEntrar);
		contentPane.add(panelBotonera);
	}
}
