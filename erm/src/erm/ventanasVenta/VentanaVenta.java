package erm.ventanasVenta;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import erm.ventanasPrimarias.VentanaInicial;
import erm.ventanasPrimarias.VentanaLogIn;
import erm.ventanasPrimarias.VentanaPrincipal;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class VentanaVenta extends JFrame {

	private JButton btnAtras;
	public static int idVenta;
	private JPanel panelNorte, panelCentro, panelBotonera;

	/**
	 * Desde donde se ejecuta la aplicación
	 * 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaVenta() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 452);
		getContentPane().setBackground(new Color(245, 245, 245));

		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelBotonera = new JPanel();
		panelNorte.setLayout(new GridLayout(0, 1));
		panelBotonera.setLayout(new GridLayout(0, 2));

		JLabel lblERM = new JLabel("Ventas");
		lblERM.setHorizontalAlignment(SwingConstants.CENTER);
		lblERM.setForeground(new Color(255, 165, 0));
		lblERM.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 28));
		lblERM.setBounds(301, 11, 93, 60);
		panelNorte.add(lblERM);

		JLabel lblTitulo = new JLabel("Introduce los datos del coche que deseas vender");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblTitulo.setBounds(179, 70, 373, 28);
		panelNorte.add(lblTitulo);

		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelCentro.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(315, 45, 93, 34);
		panelCentro.add(lblNombre);

		JTextArea textoNombre = new JTextArea();
		textoNombre.setTabSize(18);
		textoNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoNombre.setBounds(424, 52, 148, 22);
		panelCentro.add(textoNombre);

		JTextArea textoId = new JTextArea();
		textoId.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoId.setBounds(148, 97, 111, 22);
		panelCentro.add(textoId);
		textoId.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoria.setBounds(63, 45, 99, 34);
		panelCentro.add(lblCategoria);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(315, 132, 64, 27);
		panelCentro.add(lblPrecio);

		JTextPane textoPrecio = new JTextPane();
		textoPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoPrecio.setBounds(424, 132, 148, 22);
		panelCentro.add(textoPrecio);

		JLabel labelEuro = new JLabel("\u20AC");
		labelEuro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEuro.setBounds(582, 125, 37, 34);
		panelCentro.add(labelEuro);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(315, 90, 77, 29);
		panelCentro.add(lblMarca);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(37, 282, 0, 0);
		panelCentro.add(lblFoto);

		JTextArea textoMarca = new JTextArea();
		textoMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoMarca.setBounds(424, 90, 148, 22);
		panelCentro.add(textoMarca);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImagen.setBounds(63, 135, 77, 34);

		panelCentro.add(lblImagen);

		// Boton imagen
		JButton btnImagen = new JButton("Imagen");
		btnImagen.setBounds(148, 143, 111, 22);
		panelCentro.add(btnImagen);

		btnImagen.addActionListener(e -> {

			JFileChooser fileChooser = new JFileChooser();
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File(".")); // Abre el directorio raiz de mi proyecto
			// fc.setCurrentDirectory(new File("src")); //Abre la carpeta src de mi proyecto
			int seleccionado = fc.showOpenDialog(null);
			if (seleccionado == JFileChooser.APPROVE_OPTION) {
				File ficheroSeleccionado = fc.getSelectedFile();
				ImageIcon im = new ImageIcon(ficheroSeleccionado.getAbsolutePath());
				im.setDescription(ficheroSeleccionado.getAbsolutePath());
				lblFoto.setIcon(im);

			}
		});
		
		JLabel lblCombustible = new JLabel("Combustible");
		lblCombustible.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCombustible.setBounds(315, 162, 93, 34);
		panelCentro.add(lblCombustible);

		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(63, 87, 37, 40);
		panelCentro.add(lblId);

		JLabel lblFecha = new JLabel("F.Matriculacion");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(315, 199, 111, 34);
		panelCentro.add(lblFecha);

		JTextArea textoFecha = new JTextArea();
		textoFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoFecha.setText("");
		textoFecha.setBounds(424, 206, 148, 22);
		panelCentro.add(textoFecha);
		textoFecha.setColumns(10);

		JTextArea textoCombustible = new JTextArea();
		textoCombustible.setFont(new Font("Tahoma", Font.BOLD, 11));
		textoCombustible.setBounds(424, 169, 148, 22);
		panelCentro.add(textoCombustible);
		textoCombustible.setColumns(10);

		String[] opciones = { "Categoria A", "Categoria B", "Categoria C", "Categoria D" };

		JComboBox comboBox = new JComboBox(opciones);
		panelCentro.add(comboBox);
		comboBox.setBounds(148, 56, 111, 22);

		JButton btnCamara = new JButton("Camara");
		btnCamara.setBounds(148, 176, 111, 22);
		panelCentro.add(btnCamara);

		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		

		btnCamara.addActionListener(e -> {

			WebcamViewerExample wc = new WebcamViewerExample();
			wc.run();

		});

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textoId.getText().equals("") || textoNombre.getText().equals("") || textoMarca.getText().equals("")
						|| textoPrecio.getText().equals("") || textoFecha.getText().equals("")
						|| textoCombustible.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
				} else {
					String id = textoId.getText();
					String nombre = textoNombre.getText();
					String categoria = comboBox.getSelectedItem().toString();
					String marca = textoMarca.getText();
					String precio = textoPrecio.getText();
					String fecha_matriculacion = textoFecha.getText();
					String combustible = textoCombustible.getText();
					ImageIcon im = (ImageIcon) lblFoto.getIcon();
					String rutaFoto = im.getDescription();

					if (categoria.equals("Categoria A")) {
						try {
							DBManager.insertarCategoriaA(id, nombre, categoria, marca, fecha_matriculacion, combustible,
									precio, rutaFoto);
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
							DBManager.insertarCategoriaB(id, nombre, categoria, marca, fecha_matriculacion, combustible,
									precio, rutaFoto);
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
							DBManager.insertarCategoriaC(id, nombre, categoria, marca, fecha_matriculacion, combustible,
									precio, rutaFoto);
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
							DBManager.insertarCategoriaD(id, nombre, categoria, marca, fecha_matriculacion, combustible,
									precio, rutaFoto);
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
			}
		});

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setBounds(242, 361, 89, 28);
		panelBotonera.add(btnAtras);

		btnAtras.addActionListener(e -> {

			VentanaVentasInformacion v4 = new VentanaVentasInformacion();
			v4.setVisible(true);
			dispose();

		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardar.setBounds(341, 361, 93, 29);
		panelBotonera.add(btnGuardar);
		getContentPane().add(panelBotonera, BorderLayout.SOUTH);

	}

	// METODO PARA SACAR IDVENTA
	public static int getVentaId() {
		return idVenta;
	}
}
