package erm.ventanasVenta;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
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

import erm.webcam.WebcamViewerExample;
import erm.categoriasCoche.Coche;
import erm.clasesBasicas.Venta;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasPrimarias.VentanaPrincipal;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VentanaVenta extends JFrame {

	private JButton btnAtras;
	public static int idVenta;

	public VentanaVenta() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 546);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JLabel lblERM = new JLabel("Ventas");
		lblERM.setForeground(new Color(255, 165, 0));
		lblERM.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 28));
		lblERM.setBounds(172, 11, 93, 60);
		getContentPane().add(lblERM);

		JLabel lblTitulo = new JLabel("Introduce los datos del coche que deseas vender");
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblTitulo.setBounds(21, 70, 373, 28);
		getContentPane().add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(21, 121, 65, 28);
		getContentPane().add(lblNombre);

		JTextArea textoNombre = new JTextArea();
		textoNombre.setTabSize(18);
		textoNombre.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoNombre.setBounds(106, 120, 216, 28);
		getContentPane().add(textoNombre);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoria.setBounds(21, 176, 75, 14);
		getContentPane().add(lblCategoria);

		JTextArea textoCategoria = new JTextArea();
		textoCategoria.setTabSize(18);
		textoCategoria.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textoCategoria.setBounds(106, 168, 216, 28);
		getContentPane().add(textoCategoria);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(21, 251, 46, 14);
		getContentPane().add(lblPrecio);

		JTextPane textoPrecio = new JTextPane();
		textoPrecio.setBounds(106, 248, 223, 25);
		getContentPane().add(textoPrecio);

		JLabel labelEuro = new JLabel("\u20AC");
		labelEuro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEuro.setBounds(357, 248, 33, 20);
		getContentPane().add(labelEuro);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(21, 299, 99, 28);
		getContentPane().add(lblDescripcion);

		JTextArea textoDescripcion = new JTextArea();
		textoDescripcion.setBounds(106, 299, 281, 84);
		getContentPane().add(textoDescripcion);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setBounds(21, 414, 81, 20);
		getContentPane().add(lblImagen);


		// Boton imagen
		JButton btnImagen = new JButton("Imagen");
		btnImagen.setBounds(215, 415, 93, 29);
		getContentPane().add(btnImagen);

		btnImagen.addActionListener(e -> {
			
				JFileChooser fileChooser = new JFileChooser();
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(".")); // Abre el directorio raiz de mi proyecto
				// fc.setCurrentDirectory(new File("src")); //Abre la carpeta src de mi proyecto
				int seleccionado = fc.showOpenDialog(null);
				if (seleccionado == JFileChooser.APPROVE_OPTION) {
					File ficheroSeleccionado = fc.getSelectedFile();
					ficheroSeleccionado.getAbsolutePath();

				}
		});

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String nombre = textoNombre.getText(); 
				String categoria = textoCategoria.getText();
				String precio = textoPrecio.getText();
				
			//	int a = VentanaLogIn.getUsuarioId();
				
				Venta venta = new Venta(nombre, categoria, Double.parseDouble(precio));
				
				DBManager dbm = new DBManager();
					
					try {
						dbm.initBD("EasyRentingMotors.db");
						dbm.insertarVenta(venta);
						dbm.disconnect();
						
					} catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					VentanaPrincipal vp = new VentanaPrincipal();
					setVisible(false);
					vp.setVisible(true);
					
					
					
				
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardar.setBounds(106, 467, 93, 29);
		getContentPane().add(btnGuardar);

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(219, 467, 89, 28);
		getContentPane().add(btnAtras);

		JLabel lblCombustible = new JLabel("Combustible");
		lblCombustible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCombustible.setBounds(21, 212, 134, 14);
		getContentPane().add(lblCombustible);

		JRadioButton rdDiesel = new JRadioButton("Diesel");
		rdDiesel.setBounds(140, 210, 81, 23);
		getContentPane().add(rdDiesel);
		//
		JRadioButton rdGasolina = new JRadioButton("Gasolina");
		rdGasolina.setBounds(239, 210, 81, 23);
		getContentPane().add(rdGasolina);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdGasolina);
		grupo.add(rdDiesel);
		

		JButton btnCamara = new JButton("Camara");
		btnCamara.setBounds(112, 415, 93, 29);
		getContentPane().add(btnCamara);

		btnCamara.addActionListener(e -> {
			
				WebcamViewerExample wc = new WebcamViewerExample();
				wc.run();  
				
		
		});

		btnAtras.addActionListener(e -> {
			
				VentanaVentasInformacion v4 = new VentanaVentasInformacion();
				v4.setVisible(true);
				dispose();

		});

	}

	// METODO PARA SACAR IDVENTA
	public static int getVentaId() {
		return idVenta;
	}
}