package erm.ventanasPrimarias;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import erm.dataBase.*;
import erm.clasesBasicas.Usuario;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasAdministrador.VentanaAdmin;
import erm.ventanasAdministrador.VentanaInicioAdmin;

import java.awt.EventQueue;
import javax.swing.SwingConstants;

public class VentanaLogIn extends JFrame {
	public static int idUsuario;
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panelCentro, panelBase, panelBotonera;
	private JLabel usuario, contrasenia;
	private JButton btnEntrar, btnSalir, btnRegistrar, btnAdmin, btnFavoritos;
	public static String nick;
	private JLabel lblTitulo;
	private JTextField txtNombre;
	private JPasswordField txtContrasenia;
	private JButton btnMostrarContraseña;

	/**
	 * Create the frame
	 */
	public VentanaLogIn() {
		super();

		setBounds(100, 100, 571, 384);
		setTitle("Inicio de sesion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setExtendedState(MAXIMIZED_BOTH);

		panelCentro = new JPanel();
		panelCentro.setBounds(0, 58, 557, 244);
		
		// panelCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, true));

		panelBase = new JPanel();
		panelBase.setBounds(0, 0, 557, 59);
		// panelBase.setBackground(Color.DARK_GRAY);

		panelBotonera = new JPanel();
		panelBotonera.setBounds(0, 303, 557, 33);
		// panelBotonera.setBackground(Color.DARK_GRAY);

		getContentPane().add(panelCentro, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		getContentPane().add(panelBase);
		
		lblTitulo = new JLabel("INICIO DE SESI\u00D3N");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 165, 0));
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		panelBase.add(lblTitulo);
		getContentPane().add(panelBotonera);


		btnEntrar = new JButton();
		btnEntrar.setToolTipText("Pulsa para iniciar sesion");
		btnEntrar.setText("Iniciar sesi\u00F3n");
		panelBotonera.add(btnEntrar);

		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setToolTipText("Modo administrador");
		panelBotonera.add(btnAdmin);

		btnAdmin.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(null, "¡Acceso restringido para el equipo de administración!", "Acceso restringido", JOptionPane.WARNING_MESSAGE);
			VentanaInicioAdmin v2 = new VentanaInicioAdmin();
			v2.setVisible(true);
			dispose();
		});

		btnRegistrar = new JButton();
		btnRegistrar.setToolTipText("Pulsa para registrarte");
		btnRegistrar.setText("Registro");
		panelBotonera.add(btnRegistrar);

		btnRegistrar.addActionListener(e -> {
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

		btnSalir = new JButton();
		btnSalir.setToolTipText("Pulsa para salir");
		btnSalir.setText("Salir");
		panelBotonera.add(btnSalir);
		panelCentro.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(148, 76, 67, 25);
		panelCentro.add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasenya.setEnabled(true);
		lblContrasenya.setBounds(148, 158, 100, 25);
		panelCentro.add(lblContrasenya);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(272, 66, 163, 35);
		panelCentro.add(txtNombre);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(272, 157, 163, 35);
		panelCentro.add(txtContrasenia);
		
		
		JLabel lblIconoUsuario = new JLabel("");
		lblIconoUsuario.setIcon(new ImageIcon("imagenes/iconoUsuario.png"));
		lblIconoUsuario.setBounds(65, 52, 40, 49);
		panelCentro.add(lblIconoUsuario);
		
		JLabel lblIconoContraseña = new JLabel("");
		lblIconoContraseña.setIcon(new ImageIcon("imagenes/iconoContrasenya.png"));
		lblIconoContraseña.setBounds(76, 158, 40, 25);
		panelCentro.add(lblIconoContraseña);
		
		JCheckBox cbMostrarContraseña = new JCheckBox("Mostrar contrase\u00F1a");
		cbMostrarContraseña.setBounds(272, 199, 163, 23);
		panelCentro.add(cbMostrarContraseña);
		
		cbMostrarContraseña.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	txtContrasenia.setEchoChar((char)0); 
		        	//checkbox has been selected
		            //do something...
		        } else {//checkbox has been deselected
		        	txtContrasenia.setEchoChar('*'); 
		        };
		    }

		});
		
		btnSalir.addActionListener(e -> {
			VentanaInicial vi = null;
			vi = new VentanaInicial();
			vi.setVisible(true);
			dispose();

		});

		btnEntrar.addActionListener(e -> {
			// TODO Auto-generated method stub
			DBManager conexion = new DBManager();

			String nick = txtNombre.getText();
			String contrasenia = txtContrasenia.getText();

			try {

				conexion.initBD("EasyRentingMotors.db");

				if (conexion.loginUsuario(nick, contrasenia) == true) {

					idUsuario = conexion.obtenerId(nick);
					JOptionPane.showMessageDialog(null, "BIENVENIDO A EASY RENTING MOTORS", "BIENVENIDO",
							JOptionPane.INFORMATION_MESSAGE);
					VentanaPrincipal vi = new VentanaPrincipal();
					setVisible(false);
					vi.setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesion", "Error", 0);
					txtNombre.setText("");
					txtContrasenia.setText("");
				}

				conexion.disconnect();

			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

	}

	private void setEchoChar(char c) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Este metodo se encarga de vaciar los campos
	 */
	public void vaciarCampos() {
		txtNombre.setText("");
		txtContrasenia.setText("");
	}

	/**
	 * Este metodo sirve para alinear campos
	 * 
	 * @param cont
	 * @param etiqueta
	 * @param campo
	 */

	void posicionaLinea(Container cont, String etiqueta, Component campo) {
		JPanel tempPanel = new JPanel();
		tempPanel.setOpaque(false);
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // se hace un flow ajustado a la izquierda
		JLabel l = new JLabel(etiqueta);
		l.setPreferredSize(new Dimension(250, 50));
		l.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		l.setForeground(Color.BLACK);
		tempPanel.add(l);
		tempPanel.add(campo);
		cont.add(tempPanel);
	}

	// carga en el fichero properties el usuario y contrasenia que inicie sesion
	public void cargarProperties() {
		FileOutputStream fos = null;
		File configFile = null;

		try {
			configFile = new File("config.properties");
			fos = new FileOutputStream(configFile);

			Properties propConfig = new Properties();
			propConfig.setProperty("username", txtNombre.getText());
			propConfig.setProperty("password", txtContrasenia.getText());
			propConfig.store(fos, "Configuracion del programa");
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// METODO GET ID USUARIO
	public static int getUsuarioId() {
		return idUsuario;
	}
}
