package erm.ventanasPrimarias;

import erm.dataBase.*;
import erm.categoriasCoche.CategoriaA;
import erm.categoriasCoche.Coche;
import erm.clasesBasicas.ListaCoche;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;

import java.awt.*;
import erm.clasesBasicas.*;
import erm.categoriasCoche.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Random;

	public class VentanaCategoriaA {

		private JFrame frame;
		private ListaCoche Coches;
		DBManager con = new DBManager();
		JScrollPane scrollPane;

		/**
		 * Launch the application.
		 */
		public static void main() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaCategoriaA window = new VentanaCategoriaA();
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
		public VentanaCategoriaA() {
			Coches = new ListaCoche();
			initialize();
		}

		public VentanaCategoriaA(ListaCoche Coches, ArrayList<Coche> carrito) {
			this.Coches = Coches;
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
			frame.setBounds(100, 100, 600,650);
			frame.setTitle("ERMotors");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 10, 700, 750);
			
		

			 ArrayList<CategoriaA> CategoriaA = new ArrayList<CategoriaA>();
			 try {
				CategoriaA = DBManager.listarCategoriaA();
			} catch (DBException e1) {
				e1.printStackTrace();
			}

			JPanel CategoriaAPanel = new JPanel(new FlowLayout());
			cargarRecursivamente(CategoriaAPanel,CategoriaA,0);
			/*for (CategoriaA o : CategoriaA) {
				JPanel CategoriaAsPanel = CochePanel(o, VentanaPrincipal.carrito);
				CategoriaAPanel.add(CategoriaAsPanel);
			}*/
			CategoriaAPanel.setBounds(50,100,500,700);
			JScrollPane scrollPane = new JScrollPane(
					CategoriaAPanel,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);
			frame.getContentPane().add(scrollPane);
			frame.getContentPane().add(CategoriaAPanel);

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

			JLabel lblCatA = new JLabel("Categoria A");
			lblCatA.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblCatA.setBounds(194, 34, 178, 43);
			frame.getContentPane().add(lblCatA);
			
			JButton btnCarritoCompra = new JButton("Carrito");
			btnCarritoCompra.setBounds(250, 550, 80, 30);
			btnCarritoCompra.addActionListener(e -> {
					VentanaCarritoCompra.main();
			});
			frame.getContentPane().add(btnCarritoCompra);

			
		}
			
		private void cargarRecursivamente(JPanel CategoriaAPanel, ArrayList<CategoriaA> CategoriaA, int i) {
			if(i<CategoriaA.size()) {
				JPanel CategoriaAsPanel = CochePanel(CategoriaA.get(i), VentanaPrincipal.carrito);
				CategoriaAPanel.add(CategoriaAsPanel);
				cargarRecursivamente(CategoriaAPanel, CategoriaA, i+1);
			}
		}
		
		private JPanel CochePanel(CategoriaA o, ArrayList<Coche> carrito) {
			
			JPanel panel =  new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			panel.setBackground(Color.WHITE);
			JLabel lblImagen = new JLabel();
			lblImagen.setBounds(72, 90, 124, 141);
			ImageIcon ico1= new ImageIcon(o.getRutaFoto());//meter las rutas en la bd
			ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
			lblImagen.setIcon(img1);
			lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(lblImagen);

			JLabel lblNombre = new JLabel(o.getNombre());
			lblNombre.setBackground(Color.WHITE);
			lblNombre.setToolTipText("");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(lblNombre);

			JLabel lblPrecio = new JLabel(String.valueOf(o.getPrecio()+"€"));
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