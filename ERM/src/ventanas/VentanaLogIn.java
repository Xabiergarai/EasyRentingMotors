package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clasesBasicas.Usuario;

public class VentanaLogIn extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JCheckBox cb;
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	public  JTextField tfEmail;
	private JPasswordField pfContrasenia;
	private JLabel lbEmail;
	private JLabel lblContrasenia;
	private JPanel panelContenidos;
	private JLabel lb;
	public Usuario u;
	private JMenu menuUsuario;
	
	
	public VentanaLogIn() {
		this.setTitle("Easy Renting Motors");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 250);
		this.setMinimumSize(new Dimension(250, 250));
		
		
		
		panelContenidos = new JPanel();
		panelContenidos.setBackground(Color.WHITE);
		setContentPane(panelContenidos);
		panelContenidos.setLayout(new BorderLayout(15, 15));
		
		
	}

}
