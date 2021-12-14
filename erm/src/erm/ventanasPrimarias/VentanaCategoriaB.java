package erm.ventanasPrimarias;

import erm.dataBase.*;
import erm.categoriasCoche.CategoriaB;
import erm.categoriasCoche.Coche;
import erm.clasesBasicas.ListaCoche;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;

import java.util.ArrayList;
import java.awt.*;
import erm.categoriasCoche.*;
import erm.clasesBasicas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Random;

public class VentanaCategoriaB {

	private JFrame frame;
	private ListaCoche Coches;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCategoriaB window = new VentanaCategoriaB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCategoriaB() {
		Coches = new ListaCoche();
		initialize();
	}

	public VentanaCategoriaB(ListaCoche Coches) {
		this.Coches = Coches;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 600, 650);
		frame.setTitle("ERMotors");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ArrayList<CategoriaB> CategoriaB = new ArrayList<CategoriaB>();
		try {
			CategoriaB = DBManager.listarCategoriaB();
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		JPanel CategoriaBPanel = new JPanel(new FlowLayout());
		for (CategoriaB o : CategoriaB) {
			JPanel CategoriaBsPanel = CochePanel(o, VentanaPrincipal.carrito);
			CategoriaBPanel.add(CategoriaBsPanel);
		}
		CategoriaBPanel.setBounds(50, 100, 500, 700);
		JScrollPane scrollPane = new JScrollPane(CategoriaBPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(CategoriaBPanel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 99, 22);
		frame.getContentPane().add(menuBar);

		JMenu mnCat = new JMenu("Categorias");
		menuBar.add(mnCat);

		JMenuItem mntmCatA = new JMenuItem("Categoria A");
		mntmCatA.addActionListener(e -> {
			VentanaCategoriaA.main();
			frame.dispose();
		});
		mnCat.add(mntmCatA);

		JMenuItem mntmCatB = new JMenuItem("Categoria B");
		mntmCatB.addActionListener(e -> {
			VentanaCategoriaB.main();
			frame.dispose();
		});
		mnCat.add(mntmCatB);

		JMenuItem mntmCatC = new JMenuItem("Categoria C");
		mntmCatC.addActionListener(e -> {
			VentanaCategoriaC.main();
			frame.dispose();
		});
		mnCat.add(mntmCatC);

		JMenuItem mntmCatD = new JMenuItem("Categoria D");
		mntmCatD.addActionListener(e -> {
			VentanaCategoriaD.main();
			frame.dispose();
		});
		mnCat.add(mntmCatD);

		JMenuItem mntmCatInicio = new JMenuItem("Volver a inicio");
		mntmCatInicio.addActionListener(e -> {

			VentanaPrincipal.main(null);
			frame.dispose();
		});
		mnCat.add(mntmCatInicio);

		JLabel lblCatB = new JLabel("Categoria B");
		lblCatB.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCatB.setBounds(194, 34, 178, 43);
		frame.getContentPane().add(lblCatB);

		JButton btnCarritoCompra = new JButton("Carrito");
		btnCarritoCompra.setBounds(250, 550, 80, 30);
		btnCarritoCompra.addActionListener(e -> {
			VentanaCarritoCompra.main();
		});
		frame.getContentPane().add(btnCarritoCompra);
	}

	private JPanel CochePanel(CategoriaB o, ArrayList<Coche> carrito) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBackground(Color.WHITE);

		JLabel lblImagen = new JLabel();
		lblImagen.setBounds(72, 90, 124, 141);
		ImageIcon ico1 = new ImageIcon(o.getRutaFoto());// meter las rutas en la bd
		ImageIcon img1 = new ImageIcon(
				ico1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img1);
		lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblImagen);

		JLabel lblNombre = new JLabel(o.getNombre());
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setToolTipText("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNombre);

		JLabel lblPrecio = new JLabel(String.valueOf(o.getPrecio()));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblPrecio);

		JButton btnAnadirAlCarrito = new JButton("Agregar al carrito");
		btnAnadirAlCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnadirAlCarrito.setForeground(Color.WHITE);
		btnAnadirAlCarrito.setBackground(new Color(255, 165, 0));
		btnAnadirAlCarrito.addActionListener(e -> {

			Coches.getCoches().put(new Random().nextInt(), o);
			carrito.add(o);
		});

		btnAnadirAlCarrito.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnAnadirAlCarrito);

		return panel;
	}

}
