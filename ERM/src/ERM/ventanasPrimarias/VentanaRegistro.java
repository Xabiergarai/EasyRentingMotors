package ERM.ventanasPrimarias;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingUtilities;
import ERM.clasesBasicas.*;
import ERM.dataBase.DBException;
import ERM.dataBase.DBManager;




public class VentanaRegistro extends JFrame {
	
	/**
	 * Ventana en la cual el usuario se registra
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre, tfApellidos, tfNombreUsuario, tfEmail;
	private JPanel panelContenidos;
	private JLabel lbNombre, lbApellidos, lbnomUsuario, lbEmail,lbContrasenia, lbConfirmarContrasenia;
	private JPasswordField pfContrasenia, pfConfirmarContrasenia;
	private JButton btnRegistrarse, btnAtras;
	private TextPrompt tP;
	public static Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		
	
	public VentanaRegistro() throws DBException {
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
				tfNombre = new JTextField();
				tP = new TextPrompt("Nombre", tfNombre);

				lbApellidos= new JLabel("Apellidos: ");
				tfApellidos = new JTextField();
				tP = new TextPrompt("Apellidos", tfApellidos);

				lbnomUsuario = new JLabel("Nombre de usuario: ");
				tfNombreUsuario = new JTextField();
				tP = new TextPrompt("Nombre de Usuario", tfNombreUsuario);
				

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
				panelCentralSup.add(tfNombre);
				panelCentralSup.add(lbApellidos);
				panelCentralSup.add(tfApellidos);
				panelCentralSup.add(lbnomUsuario);
				panelCentralSup.add(tfNombreUsuario);
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
				btnAtras.addActionListener(e->{
					VentanaInicial vi = null;
					vi = new VentanaInicial();
					vi.setVisible(true);
					dispose();				
				});
				
				
				panelInferiorCentral.add(btnAtras);

				btnRegistrarse = new JButton("Registrarse");
				btnRegistrarse.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Object boton = e.getSource();
						//comprobar el email y nongun campo en banco
				
							if (tfNombre.getText().equals("") || tfNombre.getText().equals("")|| tfNombreUsuario.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
							}					 
							
							if(!comprobarPatronEmail(tfEmail.getText(), false)) {
								comprobarPatronEmail(tfEmail.getText(), true);
							}
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
				});
						
				panelInferiorCentral.add(btnRegistrarse);					
				this.setVisible(true);

	}
	
	
	public static boolean comprobarPatronEmail(String email, boolean showErrorWindow) {
		if(patronEmail.matcher(email).matches()) {
			System.out.println(email + "Cumple el patron correctamente");
			return patronEmail.matcher(email).matches();
		}else {
			if(showErrorWindow) {
				JOptionPane.showMessageDialog(null, "El email " + email + " no cumple el patron correctamente" );
				System.out.println("El email " + email + " no cumple el patron correctamente");
			}
			return false;
		}
	}
	
	 public static void main(String[] args) {

	        SwingUtilities.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                try {
						new VentanaRegistro();
					} catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }); 
	    }
}