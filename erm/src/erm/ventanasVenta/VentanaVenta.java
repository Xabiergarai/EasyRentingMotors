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
import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasAdministrador.VentanaGestionStock;
import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasPrimarias.VentanaPrincipal;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

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
		textoNombre.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textoNombre.setBounds(106, 120, 107, 28);
		getContentPane().add(textoNombre);
		

		JTextArea textoId = new JTextArea();
		textoId.setBounds(270, 127, 59, 20);
		getContentPane().add(textoId);
		textoId.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoria.setBounds(21, 170, 75, 20);
		getContentPane().add(lblCategoria);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(21, 212, 46, 14);
		getContentPane().add(lblPrecio);

		JTextPane textoPrecio = new JTextPane();
		textoPrecio.setBounds(106, 212, 107, 25);
		getContentPane().add(textoPrecio);

		JLabel labelEuro = new JLabel("\u20AC");
		labelEuro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEuro.setBounds(223, 209, 33, 20);
		getContentPane().add(labelEuro);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(21, 245, 99, 28);
		getContentPane().add(lblMarca);

		JTextArea textoMarca = new JTextArea();
		textoMarca.setBounds(106, 248, 107, 28);
		getContentPane().add(textoMarca);

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

		

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(219, 467, 89, 28);
		getContentPane().add(btnAtras);

		JLabel lblCombustible = new JLabel("Combustible");
		lblCombustible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCombustible.setBounds(21, 344, 134, 14);
		getContentPane().add(lblCombustible);

		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(239, 130, 49, 14);
		getContentPane().add(lblId);
		
		
		JLabel lblFecha = new JLabel("F.Matriculacion");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(21, 300, 134, 14);
		getContentPane().add(lblFecha);
		
		JTextArea textoFecha = new JTextArea();
		textoFecha.setText("");
		textoFecha.setBounds(150, 297, 115, 20);
		getContentPane().add(textoFecha);
		textoFecha.setColumns(10);
		
		JTextArea textoCombustible = new JTextArea();
		textoCombustible.setBounds(150, 341, 115, 20);
		getContentPane().add(textoCombustible);
		textoCombustible.setColumns(10);

		
		String[] opciones = {"Categoria A","Categoria B","Categoria C","Categoria D"};
		JComboBox comboBox = new JComboBox(opciones);
		comboBox.setBounds(106, 175, 115, 20);
		getContentPane().add(comboBox);
		

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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String id = textoId.getText();
                String nombre = textoNombre.getText();
                String categoria = comboBox.getSelectedItem().toString();
                String marca = textoMarca.getText();
                String precio = textoPrecio.getText();
                String fecha_matriculacion = textoFecha.getText();    
                String combustible = textoCombustible.getText();
                

                if (categoria.equals("Categoria A")) {
                    try {
						DBManager.insertarCategoriaA(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaPrincipal vp = new VentanaPrincipal();
                    vp.setVisible(true);
                    setVisible(false);
                } 

                if (categoria.equals("Categoria B")) {
                    try {
						DBManager.insertarCategoriaB(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaPrincipal vp = new VentanaPrincipal();
                    vp.setVisible(true);
                    setVisible(false);
                } 

                if (categoria.equals("Categoria C")) {
                    try {
						DBManager.insertarCategoriaC(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaPrincipal vp = new VentanaPrincipal();
                    vp.setVisible(true);
                    setVisible(false);
                } 

                if (categoria.equals("Categoria D")) {
                    try {
						DBManager.insertarCategoriaD(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaPrincipal vp = new VentanaPrincipal();
                    vp.setVisible(true);
                    setVisible(false);
                }  

                JOptionPane.showMessageDialog(null, "Se ha registrado tu venta correctamente");

            } 
        });
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardar.setBounds(106, 467, 93, 29);
		getContentPane().add(btnGuardar);
		
	
	}

	// METODO PARA SACAR IDVENTA
	public static int getVentaId() {
		return idVenta;
	}
}
