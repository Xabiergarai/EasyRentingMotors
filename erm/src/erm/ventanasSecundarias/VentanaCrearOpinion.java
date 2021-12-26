package erm.ventanasSecundarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import erm.clasesBasicas.Opinion;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasPrimarias.VentanaPrincipal;

import java.awt.SystemColor;

public class VentanaCrearOpinion extends JFrame {
	
	private JTextField textTitulo;
	private JTextField textDesc;
	public static Connection con;
	public static String nombreBD = "EasyRentingMotors.db";
	public static int idOpinion;
	static PrintStream log;
	Logger logger = Logger.getLogger("LOGGER");
	
	public VentanaCrearOpinion() {
		
    int idU = VentanaLogIn.getUsuarioId();
	logger.log(Level.INFO, "Ventana inicializada");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 522);
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		
		JLabel lblOpinion = new JLabel("Dejanos tu opinion acerca de tu\r\n compra ");
		lblOpinion.setForeground(new Color(255, 165, 0));
		lblOpinion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOpinion.setBounds(10, 0, 424, 107);
		getContentPane().add(lblOpinion);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(30, 97, 65, 20);
		getContentPane().add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(30, 130, 343, 26);
		getContentPane().add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(30, 185, 106, 26);
		getContentPane().add(lblDescripcion);
		
		textDesc = new JTextField();
		textDesc.setBounds(30, 222, 343, 83);
		getContentPane().add(textDesc);
		textDesc.setColumns(10);
		
		JCheckBox cbxOpinion = new JCheckBox("Permites a ERMotors hacer publica tu opinion");
		cbxOpinion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxOpinion.setBackground(SystemColor.menu);
		cbxOpinion.setBounds(30, 340, 343, 23);
		getContentPane().add(cbxOpinion);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				dispose();
				
			}
		});
		btnAtras.setBounds(30, 416, 106, 23);
		getContentPane().add(btnAtras);
		
		JButton btnGuardar = new JButton("Guardar\r\n");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por tu opinión", "Correcto", 1);
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(261, 416, 112, 23);
		getContentPane().add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager dbm = new DBManager();
				try {
					int idUsuario = idU;
					String titulo = textTitulo.getText();
					String descripcion = textDesc.getText();
					
					con = DBManager.initBD(nombreBD);
					Opinion opinion = new Opinion(idUsuario, titulo, descripcion);
					DBManager.insertarOpinion(opinion);
					DBManager.disconnect();
					
					VentanaOpinion vo = new VentanaOpinion();
					vo.setVisible(true);
					dispose();
					
				} catch (DBException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
	
	
}
