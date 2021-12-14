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
import erm.ventanasSecundarias.VentanaAjustes;
import erm.ventanasSecundarias.VentanaPerfil;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
	private JFrame frame;
	JPanel pCentral, pSur;
	private JButton btnSalir, btnFinalizarCompra;
	private JFrame ventana, ventanaAnterior;
	public static ArrayList<Coche> carrito = new ArrayList<Coche>();
	ListaCoche listaCoche = new ListaCoche();

	
	/**
	 * Launch the application
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	VentanaLogIn vp = new VentanaLogIn();
	private JLabel lblCategoriaA;

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

		JLabel lblCategoriaA = new JLabel("Categoria A");
		lblCategoriaA.setBounds(83, 62, 126, 77);
		getContentPane().add(lblCategoriaA);
		ImageIcon ico3 = new ImageIcon("imagenes/cocheClaseA.jpg");
		ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(lblCategoriaA.getWidth(), lblCategoriaA.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaA.setIcon(img3);
		

		JButton btncategoriaA = new JButton("Categoria A");
		btncategoriaA.setForeground(Color.WHITE);
		btncategoriaA.setBackground(new Color(255, 165, 0));
		btncategoriaA.setBounds(83, 150, 126, 48);
		getContentPane().add(btncategoriaA);

		btncategoriaA.addActionListener(e -> {
				VentanaCategoriaA.main();
				dispose();
		});

		JLabel lblCategoriaB = new JLabel("Categoria B");
		lblCategoriaB.setBounds(275, 62, 126, 77);
		getContentPane().add(lblCategoriaB);

		ImageIcon ico2 = new ImageIcon("imagenes/cocheClaseB.jpg");
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblCategoriaB.getWidth(), lblCategoriaB.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaB.setIcon(img2);
		
		JButton btncategoriaB = new JButton("Categoria B");
		btncategoriaB.setForeground(Color.WHITE);
		btncategoriaB.setBackground(new Color(255, 165, 0));
		btncategoriaB.setBounds(275, 150, 126, 48);
		getContentPane().add(btncategoriaB);

		btncategoriaB.addActionListener(e -> {
				VentanaCategoriaB.main();
				dispose();
		});

		JLabel lblCategoriaC = new JLabel("Categoria C");
		lblCategoriaC.setBackground(Color.WHITE);
		lblCategoriaC.setBounds(83, 239, 126, 77);
		getContentPane().add(lblCategoriaC);

		ImageIcon ico4 = new ImageIcon("imagenes/cocheClaseC.jpg");
		ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(lblCategoriaC.getWidth(), lblCategoriaC.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaC.setIcon(img4);

		JButton btncategoriaC = new JButton("Categoria C");
		btncategoriaC.setForeground(Color.WHITE);
		btncategoriaC.setBackground(new Color(255, 165, 0));
		btncategoriaC.setBounds(83, 339, 126, 48);
		getContentPane().add(btncategoriaC);

		btncategoriaC.addActionListener(e -> {
				VentanaCategoriaC.main();
				dispose();
		});

		JLabel lblCategoriaD = new JLabel("Categoria D");
		lblCategoriaD.setBackground(Color.WHITE);
		lblCategoriaD.setBounds(275, 239, 126, 77);
		getContentPane().add(lblCategoriaD);

		ImageIcon ico5 = new ImageIcon("imagenes/cocheClaseD.jpg");
		ImageIcon img5 = new ImageIcon(ico5.getImage().getScaledInstance(lblCategoriaD.getWidth(),lblCategoriaD.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaD.setIcon(img5);

		JButton btncategoriaD = new JButton("Categoria D");
		btncategoriaD.setForeground(Color.WHITE);
		btncategoriaD.setBackground(new Color(255, 165, 0));
		btncategoriaD.setBounds(275, 339, 126, 48);
		getContentPane().add(btncategoriaD);

		btncategoriaD.addActionListener(e -> {
				VentanaCategoriaD.main(carrito);
				dispose();
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmCerrarSesion.setForeground(new Color(255, 153, 0));
		mntmCerrarSesion.addActionListener(e -> {

				VentanaInicial v3 = new VentanaInicial();
				v3.setVisible(true);
				dispose();
		});
		menuBar.add(mntmCerrarSesion);
		
		JButton btnPerfil = new JButton("");
		btnPerfil.setIcon(new ImageIcon("imagenes/iconoPerfil.png"));
		btnPerfil.setFocusPainted(false);
		btnPerfil.setContentAreaFilled(false);
		menuBar.add(btnPerfil);
		
		btnPerfil.addActionListener(e -> {
			
			VentanaPerfil v2 = new VentanaPerfil();
			v2.setVisible(true);
			dispose();
		});

		JButton btnAjustes = new JButton("");
		btnAjustes.setIcon(new ImageIcon("imagenes/iconoAjustes.png"));
		btnAjustes.setFocusPainted(false);
		btnAjustes.setContentAreaFilled(false);
		menuBar.add(btnAjustes);

		btnAjustes.addActionListener(e -> {
			
				VentanaAjustes v1 = new VentanaAjustes();
				v1.setVisible(true);
				dispose();
		});
	}
}
