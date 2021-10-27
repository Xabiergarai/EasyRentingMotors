package ERM.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import ERM.clasesBasicas.*;



public class VentanaRegistro extends JFrame {
	
	private JTextField tPNombre;
	private JTextField tfApellidos;
	private JTextField tPNombreUsuario;
	private JTextField tfEmail;
	private JPanel panelContenidos;
	private JLabel lbNombre;
	private JLabel lbApellidos;
	private JLabel lbnomUsuario;
	private JLabel lbEmail;
	private JLabel lbContrasenia;
	private JLabel lbConfirmarContrasenia;
	private JPasswordField pfContrasenia;
	private JPasswordField pfConfirmarContrasenia;
	private JButton btnRegistrarse;
	private JButton btnAtras;
	private TextPrompt tP;

	
	
	
	
	
	
	public VentanaRegistro() {
		this.setTitle("Registro");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 100);
		this.setMinimumSize(new Dimension(250, 300));
		
		        // panel principal  	
				panelContenidos = new JPanel();
				panelContenidos.setBackground(Color.WHITE);
				setContentPane(panelContenidos);
				panelContenidos.setLayout(new BorderLayout(15, 15));

		      //Panel Central que contendra todo
				JPanel panelCentral = new JPanel();
				panelCentral.setBackground(Color.WHITE);
				panelCentral.setLayout(new BorderLayout(0, 0));
				panelContenidos.add(panelCentral, BorderLayout.CENTER);

				// central superior panel
				JPanel panelCentralSup = new JPanel();
				panelCentralSup.setBackground(Color.WHITE);
				panelCentralSup.setLayout(new GridLayout(6, 2, 5, 15));

				panelCentral.add(panelCentralSup, BorderLayout.NORTH);
		
				lbNombre = new JLabel("Nombre: ");
				tPNombre = new JTextField();
				tP = new TextPrompt("Nombre", tPNombre);

				lbApellidos= new JLabel("Apellidos: ");
				tfApellidos = new JTextField();
				tP = new TextPrompt("Apellidos", tfApellidos);

				lbnomUsuario = new JLabel("Nombre de usuario: ");
				tPNombreUsuario = new JTextField();
				tP = new TextPrompt("Nombre de Usuario", tPNombreUsuario);
				

				lbEmail = new JLabel("Email: ");
				tfEmail = new JTextField();
				tP = new TextPrompt("Email", tfEmail);

				lbContrasenia = new JLabel("Contraseña: ");
				pfContrasenia = new JPasswordField();
				tP = new TextPrompt("Contraseña", pfContrasenia);

				lbConfirmarContrasenia = new JLabel("");
				pfConfirmarContrasenia = new JPasswordField();
				tP = new TextPrompt("Confirmar contraseña", pfConfirmarContrasenia);

				panelCentralSup.add(lbNombre);
				panelCentralSup.add(tPNombre);
				panelCentralSup.add(lbApellidos);
				panelCentralSup.add(tfApellidos);
				panelCentralSup.add(lbnomUsuario);
				panelCentralSup.add(tPNombreUsuario);
				panelCentralSup.add(lbEmail);
				panelCentralSup.add(tfEmail);
				panelCentralSup.add(lbContrasenia);
				panelCentralSup.add(pfContrasenia);
				
				// Panel Inferior
				JPanel panelInferior = new JPanel();
				panelInferior.setBackground(Color.WHITE);
				panelInferior.setLayout(new BorderLayout(0, 0));
				panelCentral.add(panelInferior, BorderLayout.SOUTH);

				JPanel panelInferiorCentral = new JPanel();
				panelInferiorCentral.setBackground(Color.WHITE);
				panelInferiorCentral.setLayout(new GridLayout(1, 2, 5, 0));
				panelInferior.add(panelInferiorCentral, BorderLayout.CENTER);

				btnAtras = new JButton("Volver");
				/*
				 * 
				 * 
				 * 
				 * 
				 * Funcionalidad boton volver
				 * 
				 * 
				 * 
				 * 
				 */
				

				panelInferiorCentral.add(btnAtras);

				btnRegistrarse = new JButton("Registrarse");
				/*
				 * 
				 * 
				 * 
				 * 
				 * 
				 * Funcionalidad boton Registrarse
				 * 
				 * 
				 * 
				 * 
				 * 
				 */
		
				panelInferiorCentral.add(btnRegistrarse);

			
		
				this.setVisible(true);

	}

	
	
	 public static void main(String[] args) {

	        SwingUtilities.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                new VentanaRegistro();
	            }
	        }); 
	    }
}
