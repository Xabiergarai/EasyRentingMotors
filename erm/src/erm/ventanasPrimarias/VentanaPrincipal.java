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

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
	private JFrame frame;
	JPanel pCentral, pSur;
	private JButton btnSalir, btnFinalizarCompra;
	private JFrame ventana, ventanaAnterior;
	ArrayList<Coche> carrito = new ArrayList<Coche>();
	ListaCoche listaCoche = new ListaCoche();

	/* public void cargarFotos() {
	 for(Coche p: VentanaLogIn.contenedora.getListaCoches()) {
	 if(p instanceof Categoria_A) {
	 PanelCategoria_A panel = new PanelCategoriaA((Categoria_A ) p,ventana);
	 pCentral.add(panel);
	 }
	 }
	 }*/

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
		lblCategoriaA.setBounds(275, 62, 126, 77);
		getContentPane().add(lblCategoriaA);

		ImageIcon ico2 = new ImageIcon("imagenes/cocheClaseA.jpg");
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblCategoriaA.getWidth(), lblCategoriaA.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaA.setIcon(img2);

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

		JLabel lblCategoriaB = new JLabel("Categoria B");
		lblCategoriaB.setBounds(90, 62, 106, 77);
		getContentPane().add(lblCategoriaB);
		ImageIcon ico3 = new ImageIcon("imagenes/cocheClaseB.jpg");
		ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(lblCategoriaB.getWidth(), lblCategoriaB.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaB.setIcon(img3);

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

		JLabel lblCategoriaC = new JLabel("Categoria C");
		lblCategoriaC.setBackground(Color.WHITE);
		lblCategoriaC.setBounds(83, 224, 126, 77);
		getContentPane().add(lblCategoriaC);

		ImageIcon ico4 = new ImageIcon("imagenes/cocheClaseC.jpg");
		ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(lblCategoriaC.getWidth(), lblCategoriaC.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaC.setIcon(img4);

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

		JLabel lblCategoriaD = new JLabel("Categoria D");
		lblCategoriaD.setBackground(Color.WHITE);
		lblCategoriaD.setBounds(275, 224, 126, 77);
		getContentPane().add(lblCategoriaD);

		ImageIcon ico5 = new ImageIcon("imagenes/cocheClaseD.jpg");
		ImageIcon img5 = new ImageIcon(ico5.getImage().getScaledInstance(lblCategoriaD.getWidth(),lblCategoriaD.getHeight(), Image.SCALE_SMOOTH));
		lblCategoriaD.setIcon(img5);

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

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.setForeground(Color.RED);
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaInicial v3 = new VentanaInicial();
				v3.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmCerrarSesion);
		
		JButton btnPerfil = new JButton("");
		btnPerfil.setBackground(new Color(255, 222, 173));
		btnPerfil.setIcon(new ImageIcon("imagenes/iconoPerfil.png"));
		menuBar.add(btnPerfil);

		JButton btnAjustes = new JButton("");
		btnAjustes.setIcon(new ImageIcon("imagenes/iconoAjustes.png"));
		btnAjustes.setBackground(new Color(255, 222, 173));
		menuBar.add(btnAjustes);

		btnAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAjustes v1 = new VentanaAjustes();
				v1.setVisible(true);
				dispose();
			}

		});
	}
}
