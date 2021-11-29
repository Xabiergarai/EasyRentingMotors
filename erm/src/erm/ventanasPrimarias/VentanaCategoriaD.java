package erm.ventanasPrimarias;
import erm.dataBase.*;
import erm.categoriasCoche.CategoriaD;
import erm.categoriasCoche.Coche;
import erm.clasesBasicas.ListaCoche;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;

import java.awt.*;
import erm.categoriasCoche.*;
import erm.clasesBasicas.*;

	import javax.swing.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

	import java.util.Random;

	public class VentanaCategoriaD {

		private JFrame frame;
		private ListaCoche Coches;

		/**
		 * Launch the application.
		 */
		public static void main(ArrayList<Coche> carrito) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaCategoriaD window = new VentanaCategoriaD(carrito);
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
		public VentanaCategoriaD(ArrayList<Coche> carrito) {
			Coches = new ListaCoche();
			initialize(carrito);
		}

		public VentanaCategoriaD(ListaCoche Coches, ArrayList<Coche> carrito) {
			this.Coches = Coches;
			initialize(carrito);
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize(ArrayList<Coche> carrito) {
			frame = new JFrame();
			frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
			frame.setBounds(100, 100, 600,650);
			frame.setTitle("Ishop");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			 ArrayList<CategoriaD> CategoriaD = new ArrayList<CategoriaD>();
			try {
				CategoriaD = DBManager.listarCategoriaD();
			} catch (DBException e1) {
				e1.printStackTrace();
			} 

			JPanel CategoriaDPanel = new JPanel(new FlowLayout());
			for (CategoriaD o : CategoriaD) {
				JPanel CategoriaDsPanel = CochePanel(o, carrito);
				CategoriaDPanel.add(CategoriaDsPanel);
			}
			CategoriaDPanel.setBounds(50,100,500,700);
			JScrollPane scrollPane = new JScrollPane(
					CategoriaDPanel,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);
			frame.getContentPane().add(scrollPane);
			frame.getContentPane().add(CategoriaDPanel);

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 99, 22);
			frame.getContentPane().add(menuBar);

			JMenu mnNewMenu = new JMenu("Categorias");
			menuBar.add(mnNewMenu);

			JMenuItem mntmNewMenuItem_2 = new JMenuItem("Categoria A");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCategoriaA.main(null);
					frame.dispose();
				}
			});
			mnNewMenu.add(mntmNewMenuItem_2);

			JMenuItem mntmNewMenuItem = new JMenuItem("Categoria B");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCategoriaB.main(null);
					frame.dispose();
				}
			});
			mnNewMenu.add(mntmNewMenuItem);

			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Categoria C");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCategoriaC.main(null);
					frame.dispose();
				}
			});
			mnNewMenu.add(mntmNewMenuItem_1);

			JMenuItem mntmNewMenuItem_3 = new JMenuItem("Categoria D");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCategoriaD.main(null);
					frame.dispose();
				}
			});
			mnNewMenu.add(mntmNewMenuItem_3);

			JLabel lblNewLabel_1_1 = new JLabel("Categoria D");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_1_1.setBounds(194, 34, 178, 43);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			JButton btnCarritoCompra = new JButton("Carrito");
			btnCarritoCompra.setBounds(250, 550, 80, 30);
			btnCarritoCompra.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaCarritoCompra.main(carrito);
					
				}
			});
			frame.getContentPane().add(btnCarritoCompra);
		}
			
		
		private JPanel CochePanel(CategoriaD o, ArrayList<Coche> carrito) {
			JPanel panel =  new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			panel.setBackground(Color.WHITE);

			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setBounds(72, 90, 124, 141);
			ImageIcon ico1= new ImageIcon(o.getRutaFoto());//meter las rutas en la bd
			ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
			lblNewLabel.setIcon(img1);
			lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_2 = new JLabel(o.getNombre());
			lblNewLabel_2.setBackground(Color.WHITE);
			lblNewLabel_2.setToolTipText("");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(lblNewLabel_2);

			JLabel label = new JLabel(String.valueOf(o.getPrecio()));
			label.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(label);
			
			JButton btnAnadirAlCarrito = new JButton("Agregar al carrito");
			btnAnadirAlCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAnadirAlCarrito.setForeground(Color.WHITE);
			btnAnadirAlCarrito.setBackground(new Color(255, 165, 0));
			btnAnadirAlCarrito.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Coches.getCoches().put(
							new Random().nextInt(), o
							);
					carrito.add(o);
				}
			});
			btnAnadirAlCarrito.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(btnAnadirAlCarrito);

			return panel;
		}	

		}	
	




