package erm.ventanasAdministrador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import erm.clasesBasicas.Usuario;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaLogIn;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class VentanaAgregarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textNickname;
	private JTextField textEmail;
	private JTextField textPass;
	public static Pattern patronEmail = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


	/**
	 * Create the frame.
	 */
	public VentanaAgregarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo usuario");
		lblNuevoUsuario.setForeground(new Color(255, 165, 0));
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNuevoUsuario.setBounds(106, 45, 230, 39);
		contentPane.add(lblNuevoUsuario);
	
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(69, 137, 88, 32);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(192, 139, 190, 32);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidos.setBounds(69, 197, 88, 32);
		contentPane.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(192, 199, 190, 32);
		contentPane.add(textApellidos);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(69, 258, 88, 32);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(192, 260, 190, 32);
		contentPane.add(textEmail);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContraseña.setBounds(69, 369, 88, 32);
		contentPane.add(lblContraseña);
		
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(192, 371, 190, 32);
		contentPane.add(textPass);
		
		 JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNickname.setBounds(69, 313, 88, 32);
		contentPane.add(lblNickname);
		
		textNickname = new JTextField();
		textNickname.setColumns(10);
		textNickname.setBounds(192, 315, 190, 32);
		contentPane.add(textNickname);
	
		 JButton btnAgregarUsuario = new JButton("AGREGAR");
		 btnAgregarUsuario.addActionListener(e -> {
				
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
				if (textNombre.getText().equals("") || textApellidos.getText().equals("")
						|| textNickname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
				}
				
				// compruebar que cumple el patron del email
				if (!comprobarPatronEmail(textEmail.getText(), false)) {
					comprobarPatronEmail(textEmail.getText(), true);
				} else {
					DBManager modSql = new DBManager();
					
					
					Usuario mod = new Usuario();
					mod.setApellidos(textApellidos.getText());
					mod.setEmail(textEmail.getText());
					mod.setNombre(textNombre.getText());
					mod.setNickname(textNickname.getText());
					mod.setContrasenya(textPass.getText());
					mod.setDireccionIP(direccionIP);
					

					try {
						if (modSql.registrar(mod)) {
							aniadirUsuarioAFichero();
							JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido insertar");
						}
					} catch (HeadlessException | DBException e2) {
						e2.printStackTrace();
					}
					

					JOptionPane.showMessageDialog(null, "Usuario insertado");

					VentanaGestionUsuarios vg = new VentanaGestionUsuarios();
					vg.setVisible(true);
					dispose();
			} 
		}); 
		 	
		 this.setVisible(true);
		
		btnAgregarUsuario.setForeground(Color.WHITE);
		btnAgregarUsuario.setBackground(new Color(255, 165, 0));
		btnAgregarUsuario.setBounds(152, 466, 132, 50);
		contentPane.add(btnAgregarUsuario);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAdmin va = new VentanaAdmin();
				va.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtras);
		
	
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
		public void aniadirUsuarioAFichero() {
		    File file = new File("usuarioRegistrados.txt");
			try{	
				FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada permite escribir sobre el fichero sin tener que borrarlo
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("\n" + textNombre.getText() + "  " + textApellidos.getText() + " ha iniciado sesion con el usuario "
						+ textNickname.getText() + " con contrasenia " + textPass.getText());
				
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
}