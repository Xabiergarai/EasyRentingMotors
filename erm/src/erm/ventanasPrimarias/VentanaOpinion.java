package erm.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;

public class VentanaOpinion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpinion frame = new VentanaOpinion();
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
	public VentanaOpinion() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 559);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelOpiniones = new JPanel();
		panelOpiniones.setBackground(SystemColor.menu);
		panelOpiniones.setBounds(15, 11, 366, 439);
		contentPane.add(panelOpiniones);
		panelOpiniones.setLayout(null);
		
		
		
		JButton button = new JButton("Atras");
		button.setBounds(15, 466, 161, 29);
		contentPane.add(button);
		
		JButton btnNuevoComentario = new JButton("Nuevo comentario");
		btnNuevoComentario.setBounds(205, 466, 176, 29);
		contentPane.add(btnNuevoComentario);
		
		 Font fuente = new Font("Serief",Font.BOLD,14);		
        
		
		try {
			Class.forName("org.sqlite.JDBC");
					
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD2");
			Statement stmt = conn.createStatement();
			
				
			//Recuperar datos, consultas
			ResultSet rs = stmt.executeQuery("SELECT idUsuario, titulo, descripcion FROM opinion");
			
			int cont = 16;
			int contS = 0;
	
			ArrayList<JPanel> paneles = new ArrayList<JPanel>();
			
			while (rs.next()) {
				
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");

			
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setBounds(15, cont, 351, 95);
				panelOpiniones.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblLabeltitulo = new JLabel(titulo);
				lblLabeltitulo.setFont(fuente);
				
				lblLabeltitulo.setBounds(15, 16, 321, 20);
				panel_1.add(lblLabeltitulo);
				
				JLabel labelOpinion = new JLabel(descripcion);
				labelOpinion.setBounds(15, 41, 321, 38);
				panel_1.add(labelOpinion);
			
				
				cont = cont + 105;
				contS++;
			}
			
			stmt.close();
			conn.close();
					
				} catch (ClassNotFoundException e1) {
					System.out.println("No se ja podido cargar el driver");
					e1.printStackTrace();
				}catch (SQLException e1) {
					System.out.println("No se ha podido conectar a BD");
					e1.printStackTrace();
				}
		
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*VentanaVentasEInformacion vp = new VentanaVentasEInformacion();
				vp.setVisible(true);
				setVisible(false);*/
				
			}
		});
		btnNuevoComentario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*VentanaCrearOpinion vco = new VentanaCrearOpinion();
				vco.setVisible(true);
				setVisible(false);*/
				
			}
		});
	}
}
