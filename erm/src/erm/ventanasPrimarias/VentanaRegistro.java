package erm.ventanasPrimarias;
import java.awt.Dimension; 
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import erm.clasesBasicas.*;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;

import java.awt.BorderLayout;
import java.awt.Color;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre, tfApellidos, tfNombreUsuario, tfEmail;
	private JLabel lbNombre, lbApellidos, lbnomUsuario, lbEmail, lbContrasenia;
	private JPasswordField pfContrasenia;
	private JButton btnRegistrarse, btnAtras;
	private JPanel panelNorte, panelCentro, panelBotonera;
	private TextPrompt tP;
	public static Pattern patronEmail = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	/**
	 * Ventana en la cual el usuario se registra.
	 */

	public VentanaRegistro() throws DBException {

		this.setTitle("Registro");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 545, 409);
		this.setMinimumSize(new Dimension(250, 300));
	
		panelNorte = new JPanel();
		panelBotonera = new JPanel();
		panelCentro = new JPanel();

		lbNombre = new JLabel("Nombre: ");
		lbNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNombre.setBounds(112, 57, 62, 16);
		tfNombre = new JTextField();
		tfNombre.setBounds(295, 56, 170, 20);
		tP = new TextPrompt("Nombre", tfNombre);
		
		lbApellidos = new JLabel("Apellidos: ");
		lbApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbApellidos.setBounds(112, 99, 70, 16);
		tfApellidos = new JTextField();
		tfApellidos.setBounds(295, 98, 170, 20);
		tP = new TextPrompt("Apellidos", tfApellidos);

		lbnomUsuario = new JLabel("Nombre de usuario: ");
		lbnomUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbnomUsuario.setBounds(112, 137, 137, 16);
		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setBounds(295, 136, 170, 20);
		tP = new TextPrompt("Nombre de Usuario", tfNombreUsuario);

		lbEmail = new JLabel("Email: ");
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbEmail.setBounds(112, 175, 45, 16);
		tfEmail = new JTextField();
		tfEmail.setBounds(295, 174, 170, 20);
		tP = new TextPrompt("Email", tfEmail);

		lbContrasenia = new JLabel("Contraseña: ");
		lbContrasenia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbContrasenia.setBounds(112, 213, 85, 16);
		pfContrasenia = new JPasswordField();
		pfContrasenia.setBounds(295, 212, 170, 20);
		tP = new TextPrompt("Contraseña", pfContrasenia);
		panelCentro.setLayout(null);
		
	
		panelCentro.add(lbNombre);
		panelCentro.add(tfNombre);
		panelCentro.add(lbApellidos);
		panelCentro.add(tfApellidos);
		panelCentro.add(lbnomUsuario);
		panelCentro.add(tfNombreUsuario);
		panelCentro.add(lbEmail);
		panelCentro.add(tfEmail);
		panelCentro.add(lbContrasenia);
		panelCentro.add(pfContrasenia);
		getContentPane().add(panelCentro);

		btnAtras = new JButton("Volver");
		btnAtras.setBounds(125, 301, 97, 25);
		btnAtras.addActionListener(e -> {
			VentanaInicial vi = null;
			vi = new VentanaInicial();
			vi.setVisible(true);
			dispose();
		});
		

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(283, 301, 109, 25);
		
		panelBotonera.add(btnAtras);
		panelBotonera.add(btnRegistrarse);
		getContentPane().add(panelBotonera, BorderLayout.SOUTH);

		JLabel lblTitulo = new JLabel("Por favor, rellene todos los campos.");
		lblTitulo.setForeground(new Color(255, 165, 0));
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblTitulo.setBounds(104, 40, 307, 16);
		panelNorte.add(lblTitulo);
		
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		btnRegistrarse.addActionListener(e -> {

			//SACAR DIRECCION IP LOCAL
			InetAddress address;
			String direccionIP = null;
			try {
				address = InetAddress.getLocalHost();
				direccionIP = address.getHostAddress().toString();
			} catch (UnknownHostException e2) {
				e2.printStackTrace();
			}
			
			// compruebar ningun campo en banco
			if (tfNombre.getText().equals("") || tfApellidos.getText().equals("")
					|| tfNombreUsuario.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
			}
			// compruebar que cumple el patron del email
			if (!comprobarPatronEmail(tfEmail.getText(), false)) {
				comprobarPatronEmail(tfEmail.getText(), true);
			} else {
				DBManager modSql = new DBManager();
				
				
				Usuario mod = new Usuario();
				mod.setApellidos(tfApellidos.getText());
				mod.setEmail(tfEmail.getText());
				mod.setNombre(tfNombre.getText());
				mod.setNickname(tfNombreUsuario.getText());
				mod.setContrasenya(pfContrasenia.getText());
				mod.setDireccionIP(direccionIP);
				

				try {
					if (modSql.registrar(mod)) {
						aniadirUsuarioAFichero();
						JOptionPane.showMessageDialog(null, "Registro realizado con exito");
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido registrar");
					}
				} catch (HeadlessException | DBException e2) {
					e2.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Registro Completado");

				VentanaLogIn vL = new VentanaLogIn();
				vL.setVisible(true);
				dispose();
			}
		});

		this.setVisible(true);
	}

	public static boolean comprobarPatronEmail(String email, boolean showErrorWindow) {
		if (patronEmail.matcher(email).matches()) {
			System.out.println(email + "Cumple el patron correctamente");
			return patronEmail.matcher(email).matches();
		} else {
			if (showErrorWindow) {
				JOptionPane.showMessageDialog(null, "El email " + email + " no cumple el patron correctamente");
				System.out.println("El email " + email + " no cumple el patron correctamente");
			}
			return false;
		}
	}

	//metodo que se encarga de escribir en el fichero usuarioRegistrados los usuarios que se registren
	@SuppressWarnings("deprecation")
	public void aniadirUsuarioAFichero() {
	    File file = new File("usuarioRegistrados.txt");
		try{	
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada permite escribir sobre el fichero sin tener que borrarlo
			BufferedWriter bw = new BufferedWriter(fw);
		    DateTimeFormatter dtFecha = DateTimeFormatter.ofPattern("yy/MM/dd");
		    DateTimeFormatter dtHora= DateTimeFormatter.ofPattern("HH:mm:ss");
	    
			bw.write("\n" + tfNombre.getText() + "  " + tfApellidos.getText() + " ha creado un usario con el nombre de "
					+ tfNombreUsuario.getText() + " y con contrasenia " + pfContrasenia.getText()+ " el " + dtFecha.format(LocalDateTime.now()) +" a las " +dtHora.format(LocalDateTime.now()));
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}