package erm.ventanasAdminstrador;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import erm.dataBase.DBManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaAgregarCoche extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textMarca;
	private JTextField textPrecio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarCoche frame = new VentanaAgregarCoche();
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
	public VentanaAgregarCoche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo coche");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(106, 45, 230, 39);
		contentPane.add(lblNewLabel);
		
		textNom = new JTextField();
		textNom.setBounds(197, 137, 170, 32);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(32, 137, 88, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marca");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(32, 199, 88, 32);
		contentPane.add(lblNewLabel_1_1);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(197, 199, 170, 32);
		contentPane.add(textMarca);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(32, 260, 88, 32);
		contentPane.add(lblNewLabel_1_2);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(197, 260, 170, 32);
		contentPane.add(textPrecio);
		
		JLabel lblNewLabel_1_3 = new JLabel("Descripcion");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(170, 332, 88, 32);
		contentPane.add(lblNewLabel_1_3);
		
		
		JLabel lblNewLabel_1_4 = new JLabel("Categoria");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(51, 494, 88, 32);
		contentPane.add(lblNewLabel_1_4);
		
		String[] opciones = {"Categoria A","Categoria B","Categoria C","Categoria D"};
		JComboBox comboBox = new JComboBox(opciones);
		comboBox.setBounds(225, 501, 147, 25);
		contentPane.add(comboBox);

		
		JButton btnAgregarCoche = new JButton("AGREGAR");
		btnAgregarCoche.setForeground(Color.WHITE);
		btnAgregarCoche.setBackground(new Color(255, 165, 0));
		btnAgregarCoche.setBounds(149, 580, 132, 50);
		contentPane.add(btnAgregarCoche);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("EUR");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(368, 260, 41, 32);
		contentPane.add(lblNewLabel_1_2_1);
		
		
		btnAgregarCoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textNom.getText();
                String marca = textMarca.getText();
                String precio =textPrecio.getText();
                String categoria = comboBox.getSelectedItem().toString();

                /*if (categoria.equals("Categoria A")) {
                    DBManager.insertarCategoriaA(nom, marca, precio, desc);
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                } */

               /* if (categoria.equals("Categoria B")) {
                    DBManager.insertarCategoriaB(nom, marca, precio, desc);
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                } */

               /* if (categoria.equals("Categoria C")) {
                    DManager.insertarCategoriaC(nom, marca, precio, desc);
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                } */

               /* if (categoria.equals("Categoria D")) {
                    DBManager.insertarCategoriaD(nom, marca, precio, desc);
                    VentanaGestionStock vs = new VentanaGestionStock();
                    vs.setVisible(true);
                    setVisible(false);
                }  */


            } 
        }); 
	}
	}
	
