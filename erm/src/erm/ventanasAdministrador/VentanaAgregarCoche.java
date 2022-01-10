package erm.ventanasAdministrador;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaAgregarCoche extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textMarca;
	private JTextField textFecha_Matriculacion;
	private JTextField textCombustible;
	private JTextField textPrecio;
	

	/**
	 * Create the frame.
	 */
	public VentanaAgregarCoche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoCoche = new JLabel("Nuevo coche");
		lblNuevoCoche.setForeground(new Color(255, 165, 0));
		lblNuevoCoche.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNuevoCoche.setBounds(106, 45, 230, 39);
		contentPane.add(lblNuevoCoche);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(32, 137, 88, 32);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(130, 139, 103, 32);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(32, 197, 88, 32);
		contentPane.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(130, 199, 103, 32);
		contentPane.add(textMarca);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(32, 258, 88, 32);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(130, 260, 103, 32);
		contentPane.add(textPrecio);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(253, 137, 34, 32);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(297, 139, 47, 32);
		contentPane.add(textId);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoria.setBounds(32, 313, 88, 32);
		contentPane.add(lblCategoria);
		
		
		JLabel lblFchaMatriculacion = new JLabel("Fecha de matriculacion");
		lblFchaMatriculacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFchaMatriculacion.setBounds(32, 379, 180, 32);
		contentPane.add(lblFchaMatriculacion);
		
		textFecha_Matriculacion = new JTextField();
		textFecha_Matriculacion.setColumns(10);
		textFecha_Matriculacion.setBounds(222, 381, 170, 32);
		contentPane.add(textFecha_Matriculacion);
		
		JLabel lblCombustible = new JLabel("Combustible");
		lblCombustible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCombustible.setBounds(32, 439, 88, 32);
		contentPane.add(lblCombustible);
		
		textCombustible = new JTextField();
		textCombustible.setColumns(10);
		textCombustible.setBounds(222, 441, 170, 32);
		contentPane.add(textCombustible);
		
		String[] opciones = {"Categoria A","Categoria B","Categoria C","Categoria D"};
		JComboBox comboBox = new JComboBox(opciones);
		comboBox.setBounds(130, 319, 147, 25);
		contentPane.add(comboBox);

		
		JButton btnAgregarCoche = new JButton("AGREGAR");
		btnAgregarCoche.setForeground(Color.WHITE);
		btnAgregarCoche.setBackground(new Color(255, 165, 0));
		btnAgregarCoche.setBounds(149, 580, 132, 50);
		contentPane.add(btnAgregarCoche);
		
		JLabel lblEur = new JLabel("EUR");
		lblEur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEur.setBounds(243, 258, 41, 32);
		contentPane.add(lblEur);
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGestionStock vgs = new VentanaGestionStock();
				vgs.setVisible(true);
				dispose();
			}
		});
		btnAtras.setIcon(new ImageIcon("imagenes/iconoAtras.png"));
		btnAtras.setFocusPainted(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setBounds(10, 11, 53, 32);
		contentPane.add(btnAtras);
		
		// Boton imagen
				JButton btnImagen = new JButton("Imagen");
				btnImagen.setBounds(168, 510, 93, 29);
				getContentPane().add(btnImagen);
				
				JLabel lblFoto = new JLabel("");
				lblFoto.setBounds(297, 517, 0, 0);
				contentPane.add(lblFoto);

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

		btnAgregarCoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String id = textId.getText();
                String nombre = textNombre.getText();
                String categoria = comboBox.getSelectedItem().toString();
                String marca = textMarca.getText();
                String precio = textPrecio.getText();
                String fecha_matriculacion = textFecha_Matriculacion.getText();
                String combustible = textCombustible.getText();
                ImageIcon im =(ImageIcon) lblFoto.getIcon();
                String rutaFoto = im.getDescription();
                

                if (categoria.equals("Categoria A")) {
                    try {
						DBManager.insertarCategoriaA(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto);
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
						DBManager.insertarCategoriaB(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                } 

                if (categoria.equals("Categoria C")) {
                    try {
						DBManager.insertarCategoriaC(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                } 

                if (categoria.equals("Categoria D")) {
                    try {
						DBManager.insertarCategoriaD(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                }  


            } 
        }); 
	}
	}