package ERM.ventanasPrimarias;

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

import ERM.clasesBasicas.Usuario;

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
	private JLabel lb;
	public Usuario u;
	private JMenu menuUsuario;
	
	
	public VentanaLogIn() {
		this.setTitle("Easy Renting Motors");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 616, 423);
		this.setMinimumSize(new Dimension(250, 250));
		
		
	}
}
