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
import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasPrimarias.VentanaPrincipal;

import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;

public class VentanaPerfil extends JFrame{
	
	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textPais;
	private JTextField textTelefono;
	private JTextField textMisDatos;
	
	public VentanaPerfil() {
		
		int contBarra = 0;
		int idUsuario = VentanaLogIn.getUsuarioId();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 522);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);
		
		JLabel lblMiCuenta = new JLabel("MI CUENTA");
		lblMiCuenta.setForeground(new Color(255, 165, 0));
		lblMiCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMiCuenta.setBounds(151, 11, 147, 40);
		getContentPane().add(lblMiCuenta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 82, 66, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(36, 107, 89, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(36, 132, 76, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setBounds(36, 157, 46, 14);
		getContentPane().add(lblPais);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(36, 182, 76, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblMisDatos = new JLabel("Mis datos");
		lblMisDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMisDatos.setBounds(26, 57, 126, 14);
		getContentPane().add(lblMisDatos);
		
		textField = new JTextField();
		textField.setBounds(172, 79, 201, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(172, 104, 201, 20);
		getContentPane().add(textNombre);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(172, 129, 201, 20);
		getContentPane().add(textApellidos);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(172, 154, 201, 20);
		getContentPane().add(textDireccion);
		
		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setBounds(172, 179, 201, 20);
		getContentPane().add(textPais);
		
		JLabel lblDetallesCompra = new JLabel("Detalles de la cuenta");
		lblDetallesCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDetallesCompra.setBounds(26, 220, 157, 14);
		getContentPane().add(lblDetallesCompra);
		
		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setBounds(36, 245, 76, 14);
		getContentPane().add(lblMail);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setBounds(26, 270, 76, 14);
		getContentPane().add(lblContrasenya);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(172, 242, 201, 20);
		getContentPane().add(textTelefono);
		
		textMisDatos = new JTextField();
		textMisDatos.setColumns(10);
		textMisDatos.setBounds(172, 267, 201, 20);
		getContentPane().add(textMisDatos);
		
		JLabel lblNewLabel_9 = new JLabel("Forma de pago");
		lblNewLabel_9.setBounds(28, 316, 138, 14);
		getContentPane().add(lblNewLabel_9);
		
		JButton btnTarjeta = new JButton("TARJETA");
		btnTarjeta.setBounds(284, 312, 89, 23);
		getContentPane().add(btnTarjeta);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(e -> {
			
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				dispose();
		});
		
		btnAtras.setBounds(26, 394, 126, 23);
		getContentPane().add(btnAtras);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios\r\n");
		btnGuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				JOptionPane.showMessageDialog(null, "¡Enhorabuena! Ya estas registrado", "Cuenta creada", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnGuardarCambios.setBounds(259, 394, 138, 23);
		getContentPane().add(btnGuardarCambios);
		

		
	}
}