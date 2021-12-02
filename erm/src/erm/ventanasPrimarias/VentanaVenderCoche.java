package erm.ventanasPrimarias;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;


import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextPane;

import erm.webcam.WebcamViewer;

import erm.ventanasSecundarias.VentanaVentasInformacion;

public class VentanaVenderCoche extends JFrame{
	private JButton btnAtras;
	public static int idVenta;
	
	
	
	public VentanaVenderCoche() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 546);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);
		
		JLabel lblERM = new JLabel("Easy Renting Motors");
		lblERM.setForeground(new Color(255, 165, 0));
		lblERM.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblERM.setBounds(99, 11, 223, 60);
		getContentPane().add(lblERM);
		
		JLabel lblNewLabel = new JLabel("Introduce los datos del coche que deseas vender");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(35, 82, 373, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 121, 65, 28);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea textoEquipo = new JTextArea();
		textoEquipo.setTabSize(18);
		textoEquipo.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoEquipo.setBounds(106, 120, 216, 28);
		getContentPane().add(textoEquipo);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(21, 160, 81, 28);
		getContentPane().add(lblNewLabel_2);
		
		JTextArea textoTemporada = new JTextArea();
		textoTemporada.setTabSize(18);
		textoTemporada.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoTemporada.setBounds(106, 158, 216, 28);
		getContentPane().add(textoTemporada);
		
		JLabel lblNewLabel_3 = new JLabel("Marca");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(21, 204, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea textoTalla = new JTextArea();
		textoTalla.setTabSize(18);
		textoTalla.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoTalla.setBounds(106, 201, 216, 28);
		getContentPane().add(textoTalla);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(21, 251, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JTextPane textoPrecio = new JTextPane();
		textoPrecio.setBounds(106, 240, 223, 25);
		getContentPane().add(textoPrecio);
		
		JLabel label_1 = new JLabel("\u20AC");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(343, 245, 33, 20);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(21, 295, 110, 28);
		getContentPane().add(lblNewLabel_5);
		
		JTextArea textoDescripcion = new JTextArea();
		textoDescripcion.setBounds(116, 279, 281, 84);
		getContentPane().add(textoDescripcion);
		
		JLabel lblNewLabel_6 = new JLabel("Imagen");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(21, 414, 81, 20);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnCamara = new JButton("Camara");
		btnCamara.setBounds(112, 415, 93, 29);
		getContentPane().add(btnCamara);
		
	
		btnCamara.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WebcamViewer wc = new WebcamViewer();
				wc.run();  
				
			}
		});
		
		JButton btnImagen = new JButton("Imagen");
		btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImagen.setBounds(215, 415, 93, 29);
		getContentPane().add(btnImagen);
		//BOTON IMAGEN 
				btnImagen.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFileChooser fileChooser = new JFileChooser();
						JFileChooser fc = new JFileChooser();
						fc.setCurrentDirectory(new File(".")); //Abre el directorio raiz de mi proyecto
						//fc.setCurrentDirectory(new File("src")); //Abre la carpeta src de mi proyecto
						int seleccionado = fc.showOpenDialog(null);
						if(seleccionado == JFileChooser.APPROVE_OPTION) {
							File ficheroSeleccionado = fc.getSelectedFile();
							ficheroSeleccionado.getAbsolutePath();
						
						}
					}
				});

		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//int idUsuario;
			String equipo; 
			//String temporada;
			String talla;
			String precio;
			//String descripcion;
			
			//int a = VentanaLogin.getUsuarioId();
			
			//idUsuario = a;
			equipo = textoEquipo.getText();
			//temporada = textoTemporada.getText();
			talla = textoTalla.getText();
		    precio = textoPrecio.getText();
			//descripcion = textoDescripcion.getText();
			
		
			
            VentanaPrincipal va = new VentanaPrincipal();
			setVisible(false);
			va.setVisible(true);
			
			
			}
		}); 
		
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(106, 467, 93, 29);
		getContentPane().add(btnGuardar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(219, 467, 89, 28);
		getContentPane().add(btnAtras);
		
			
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVentasInformacion v4 = new VentanaVentasInformacion();
				v4.setVisible(true);
				dispose();
				
			}
				
			});
		
		
		
	}
		//METODO PARA SACAR IDVENTA
		public static int getVentaId(){
			return idVenta;
			}
		
	
	

	}

