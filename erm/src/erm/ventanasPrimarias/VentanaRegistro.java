package erm.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import erm.clasesBasicas.*;
import erm.clasesBasicas.TextPrompt;
import erm.clasesBasicas.Usuario;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfNombre, tfApellidos, tfNombreUsuario, tfEmail;
	private JPanel panelContenidos;
	private JLabel lbNombre, lbApellidos, lbnomUsuario, lbEmail, lbContrasenia;
	private JPasswordField pfContrasenia;
	private JButton btnRegistrarse, btnAtras;
	private TextPrompt tP;
	public static Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


	/**
	 * Ventana en la cual el usuario se registra
	 */
	
	public VentanaRegistro() throws DBException {

		this.setTitle("Registro");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 545, 409);
		this.setMinimumSize(new Dimension(250, 300));
		
		lbNombre = new JLabel("Nombre: ");
		lbNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNombre.setBounds(104, 87, 74, 16);
		tfNombre = new JTextField();
		tfNombre.setBounds(274, 87, 137, 22);
		tP = new TextPrompt("Nombre", tfNombre);
		getContentPane().setLayout(null);
		getContentPane().add(lbNombre);
		getContentPane().add(tfNombre);

		
		
		lbApellidos = new JLabel("Apellidos: ");
		lbApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbApellidos.setBounds(104, 127, 74, 16);
		tfApellidos = new JTextField();
		tfApellidos.setBounds(274, 127, 137, 22);
		tP = new TextPrompt("Apellidos", tfApellidos);
		getContentPane().add(lbApellidos);
		getContentPane().add(tfApellidos);


		
		
		lbnomUsuario = new JLabel("Nombre de usuario: ");
		lbnomUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbnomUsuario.setBounds(104, 167, 143, 16);
		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setBounds(274, 167, 137, 22);
		tP = new TextPrompt("Nombre de Usuario", tfNombreUsuario);
		getContentPane().add(lbnomUsuario);
		getContentPane().add(tfNombreUsuario);

		
		lbEmail = new JLabel("Email: ");
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbEmail.setBounds(104, 207, 56, 16);
		tfEmail = new JTextField();
		tfEmail.setBounds(274, 207, 137, 22);
		tP = new TextPrompt("Email", tfEmail);
		getContentPane().add(lbEmail);
		getContentPane().add(tfEmail);

		
		lbContrasenia = new JLabel("Contraseña: ");
		lbContrasenia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbContrasenia.setBounds(104, 247, 90, 16);
		pfContrasenia = new JPasswordField();
		pfContrasenia.setBounds(274, 247, 137, 22);
		tP = new TextPrompt("Contraseña", pfContrasenia);
		getContentPane().add(lbContrasenia);
		getContentPane().add(pfContrasenia);

	
		btnAtras = new JButton("Volver");
		btnAtras.setBounds(125, 301, 97, 25);
		btnAtras.addActionListener(e -> {
			VentanaInicial vi = null;
			vi = new VentanaInicial();
			vi.setVisible(true);
			dispose();
		});
		getContentPane().add(btnAtras);

		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(283, 301, 109, 25);
		getContentPane().add(btnRegistrarse);
		
		JLabel lblPorFavorRellene = new JLabel("Por favor, rellene todos los campos.");
		lblPorFavorRellene.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPorFavorRellene.setBounds(104, 40, 307, 16);
		getContentPane().add(lblPorFavorRellene);
		btnRegistrarse.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				// compruebar ningun campo en banco
				if (tfNombre.getText().equals("") || tfNombre.getText().equals("")
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
					mod.setNombre(tfNombre.getName());
					mod.setNomUsuario(tfNombreUsuario.getText());
					mod.setContrasenya(pfContrasenia.getText());

					try {
						if (modSql.registrar(mod)) {
							JOptionPane.showMessageDialog(null, "Registro realizado con exito");
						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido registrar");
						}
					} catch (HeadlessException | DBException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Registro Completado");

					VentanaLogIn vL = new VentanaLogIn();
					vL.setVisible(true);
					dispose();
				}
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
	}

