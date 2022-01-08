package erm.ventanasSecundarias;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import erm.clasesBasicas.Usuario;
import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasPrimarias.VentanaPrincipal;

import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import javax.swing.JFormattedTextField;

public class VentanaPerfil extends JFrame{
	
	private JPanel contentPane;
	
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textNickname;
	private JTextField textCorreo;
	private JTextField textContrasenya;
	private JTextField textDireccionIP;
	private JPanel panelNorte, panelCentro, panelBotonera;
	
	public VentanaPerfil(Usuario u) {
		
		int contBarra = 0;
		int idUsuario = VentanaLogIn.getUsuarioId();
		
		panelBotonera = new JPanel();
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 522);
		getContentPane().setBackground(new Color(245, 245, 245));
		
		JLabel lblMiCuenta = new JLabel("MI CUENTA");
		lblMiCuenta.setForeground(new Color(255, 165, 0));
		lblMiCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMiCuenta.setBounds(151, 11, 147, 40);
		panelNorte.add(lblMiCuenta);
		
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelCentro.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(55, 58, 96, 14);
		panelCentro.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(55, 83, 96, 14);
		panelCentro.add(lblApellidos);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(55, 108, 96, 14);
		panelCentro.add(lblNickname);
		
		JLabel lblMisDatos = new JLabel("Mis datos");
		lblMisDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMisDatos.setBounds(11, 22, 119, 14);
		panelCentro.add(lblMisDatos);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(161, 55, 193, 20);
		panelCentro.add(textNombre);
		textNombre.setColumns(10);
		textNombre.setText(u.getNombre());
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setColumns(10);
		textApellidos.setBounds(161, 80, 193, 20);
		panelCentro.add(textApellidos);
		textApellidos.setText(u.getApellidos());
		
		textNickname = new JTextField();
		textNickname.setEditable(false);
		textNickname.setColumns(10);
		textNickname.setBounds(161, 105, 193, 20);
		panelCentro.add(textNickname);
		textNickname.setText(u.getNickname());
		
		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setBounds(55, 277, 96, 14);
		panelCentro.add(lblMail);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setBounds(55, 314, 96, 14);
		panelCentro.add(lblContrasenya);
		
		textCorreo = new JTextField();
		textCorreo.setEditable(false);
		textCorreo.setColumns(10);
		textCorreo.setBounds(161, 277, 193, 20);
		panelCentro.add(textCorreo);
		textCorreo.setText(u.getEmail());
		
		JLabel lblDetallesCompra = new JLabel("Detalles de la cuenta");
		lblDetallesCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetallesCompra.setBounds(11, 237, 269, 14);
		panelCentro.add(lblDetallesCompra);
		
		textContrasenya = new JTextField();
		textContrasenya.setEditable(false);
		textContrasenya.setColumns(10);
		textContrasenya.setBounds(161, 314, 193, 20);
		panelCentro.add(textContrasenya);
		textContrasenya.setText(u.getContrasenya());
		
		JLabel lblDireccionIP = new JLabel("Direccion IP");
		lblDireccionIP.setBounds(55, 133, 96, 14);
		panelCentro.add(lblDireccionIP);
		
		textDireccionIP = new JTextField();
		textDireccionIP.setEditable(false);
		textDireccionIP.setColumns(10);
		textDireccionIP.setBounds(161, 130, 193, 20);
		panelCentro.add(textDireccionIP);
		textDireccionIP.setText(u.getDireccionIP());
		
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(e -> {
			
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				dispose();
		});
		
		btnAtras.setBounds(26, 394, 126, 23);
		panelBotonera.add(btnAtras);
		
		getContentPane().add(panelBotonera, BorderLayout.SOUTH);
		
		
		

		
	}
}