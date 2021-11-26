package erm.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import erm.categoriasCoche.Coche;
import erm.clasesBasicas.ListaCoche;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
	private JFrame frame;
	JPanel pCentral, pSur;
	private JButton btnSalir, btnFinalizarCompra;
	private JFrame ventana, ventanaAnterior;
	ArrayList<Coche> carrito = new ArrayList<Coche>();
	ListaCoche listaCoche = new ListaCoche();

	// public void cargarFotos() {
	// for(Coche p: VentanaLogIn.contenedora.getListaCoches()) {
	// if(p instanceof Categoria_A) {
	// PanelCategoria_A panel = new PanelCategoriaA((Categoria_A ) p,ventana);
	// pCentral.add(panel);
	// }
	// }
	// }

	VentanaLogIn vp = new VentanaLogIn();

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 500, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Easy Renting Motors");
		getContentPane().setLayout(null);

		JLabel lblSeccionesCoches = new JLabel("Categorias de los coches");
		lblSeccionesCoches.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSeccionesCoches.setBounds(128, 11, 242, 26);
		getContentPane().add(lblSeccionesCoches);

		JLabel lblNewLabel_1 = new JLabel("Categoria A");
		lblNewLabel_1.setBounds(275, 62, 126, 77);
		getContentPane().add(lblNewLabel_1);

		ImageIcon ico2 = new ImageIcon("imagenes/cocheClaseA.jpg");
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblNewLabel_1.getWidth(),
				lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_1.setIcon(img2);

		JButton btncategoriaA = new JButton("Categoria A");
		btncategoriaA.setForeground(Color.WHITE);
		btncategoriaA.setBackground(new Color(255, 165, 0));
		btncategoriaA.setBounds(83, 150, 126, 48);
		getContentPane().add(btncategoriaA);

		btncategoriaA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCategoriaA.main(carrito);
				dispose();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Categoria B");
		lblNewLabel_2.setBounds(90, 62, 106, 77);
		getContentPane().add(lblNewLabel_2);
		ImageIcon ico3 = new ImageIcon("imagenes/cocheClaseB.jpg");
		ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
				lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon(img3);

		JButton btncategoriaB = new JButton("Categoria B");
		btncategoriaB.setForeground(Color.WHITE);
		btncategoriaB.setBackground(new Color(255, 165, 0));
		btncategoriaB.setBounds(275, 150, 126, 48);
		getContentPane().add(btncategoriaB);

		btncategoriaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCategoriaB.main(carrito);
				dispose();
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Categoria C");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(83, 224, 126, 77);
		getContentPane().add(lblNewLabel_3);

		ImageIcon ico4 = new ImageIcon("imagenes/cocheClaseC.jpg");
		ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(lblNewLabel_3.getWidth(),
				lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(img4);

		JButton btncategoriaC = new JButton("Categoria C");
		btncategoriaC.setForeground(Color.WHITE);
		btncategoriaC.setBackground(new Color(255, 165, 0));
		btncategoriaC.setBounds(83, 339, 126, 48);
		getContentPane().add(btncategoriaC);

		btncategoriaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCategoriaC.main(carrito);
				dispose();
			}
		});

		JLabel lblNewLabel_3_1 = new JLabel("Categoria D");
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(275, 224, 126, 77);
		getContentPane().add(lblNewLabel_3_1);

		ImageIcon ico5 = new ImageIcon("imagenes/cocheClaseD.jpg");
		ImageIcon img5 = new ImageIcon(ico5.getImage().getScaledInstance(lblNewLabel_3_1.getWidth(),
				lblNewLabel_3_1.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_3_1.setIcon(img5);

		JButton btncategoriaD = new JButton("Categoria D");
		btncategoriaD.setForeground(Color.WHITE);
		btncategoriaD.setBackground(new Color(255, 165, 0));
		btncategoriaD.setBounds(275, 339, 126, 48);
		getContentPane().add(btncategoriaD);

		btncategoriaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCategoriaD.main(carrito);
				dispose();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar sesion");
		mntmNewMenuItem_1.setForeground(Color.RED);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		menuBar.add(mntmNewMenuItem_1);

	}
}
