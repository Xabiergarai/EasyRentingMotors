package erm.ventanasAdministrador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import erm.clasesBasicas.Usuario;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textNickname;
	private JTextField textDireccionIP;
	private JTextField textEmail;
	private JTextField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarUsuario frame = new VentanaAgregarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAgregarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo usuario");
		lblNuevoUsuario.setForeground(new Color(255, 165, 0));
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNuevoUsuario.setBounds(106, 45, 230, 39);
		contentPane.add(lblNuevoUsuario);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(270, 137, 48, 32);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setBounds(325, 139, 48, 32);
		contentPane.add(textId);
		textId.setColumns(10); 
	
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(32, 137, 88, 32);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(152, 139, 96, 32);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellidos.setBounds(32, 197, 88, 32);
		contentPane.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(152, 199, 96, 32);
		contentPane.add(textApellidos);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(32, 258, 88, 32);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(152, 260, 96, 32);
		contentPane.add(textEmail);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContraseña.setBounds(32, 369, 88, 32);
		contentPane.add(lblContraseña);
		
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(152, 371, 96, 32);
		contentPane.add(textPass);
		
		 JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNickname.setBounds(32, 313, 88, 32);
		contentPane.add(lblNickname);
		
		textNickname = new JTextField();
		textNickname.setColumns(10);
		textNickname.setBounds(152, 315, 96, 32);
		contentPane.add(textNickname);
		
		JLabel lblDireccionIP = new JLabel("Direccion IP");
		lblDireccionIP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccionIP.setBounds(32, 424, 88, 32);
		contentPane.add(lblDireccionIP);
		
		textDireccionIP = new JTextField();
		textDireccionIP.setColumns(10);
		textDireccionIP.setBounds(152, 426, 96, 32);
		contentPane.add(textDireccionIP); 
	
		 JButton btnAgregarCoche = new JButton("AGREGAR");
		btnAgregarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String Id = textId.getText();
				int id = Integer.parseInt(Id);
				String nombre = textNombre.getText();
				String apellidos = textApellidos.getText();
				String nickname = textNickname.getText();
				String contrasenya = textPass.getText();
				String email = textEmail.getText();
				String direccionIP = textDireccionIP.getText();
				
				 Usuario u = new Usuario(id,nombre,apellidos,nickname,email,contrasenya,direccionIP);
				System.out.println(u);
			} 
		}); 
		btnAgregarCoche.setForeground(Color.WHITE);
		btnAgregarCoche.setBackground(new Color(255, 165, 0));
		btnAgregarCoche.setBounds(152, 535, 132, 50);
		contentPane.add(btnAgregarCoche);
		
		btnAgregarCoche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						DBManager.insertarUsuario(textId.getText(),textNombre.getText(),textApellidos.getText(), textNickname.getText(), textEmail.getText(), textPass.getText(),textDireccionIP.getText());
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				setVisible(false);
				VentanaGestionUsuarios vu = new VentanaGestionUsuarios();
				vu.setVisible(true);
				
			}
		}); 
		
	}
}