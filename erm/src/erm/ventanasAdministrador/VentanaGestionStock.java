package erm.ventanasAdministrador;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaInicial;

import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ListModel;
import java.awt.Font;
import javax.swing.JLabel;

public class VentanaGestionStock extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<String> coches = new ArrayList<>();

	

	/**
	 * Create the frame.
	 */
	public VentanaGestionStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarCoche vac = new VentanaAgregarCoche();
				vac.setVisible(true);
				dispose();
			}
		});
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(255, 165, 0));
		btnAgregar.setBounds(50, 299, 100, 39);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(255, 165, 0));
		btnEliminar.setBounds(437, 299, 100, 39);
		contentPane.add(btnEliminar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 22);
		getContentPane().add(menuBar);
		
		JMenu mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);

		JMenuItem mnStock = new JMenuItem("Stock");
		mnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionStock vgs = new VentanaGestionStock();
				vgs.setVisible(true);
				dispose();
			}
		});
		mnGestion.add(mnStock);

		JMenuItem mnUsuarios = new JMenuItem("Usuarios");
		mnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionUsuarios vgu = new VentanaGestionUsuarios();
				vgu.setVisible(true);
				dispose();
			}
		});
		mnGestion.add(mnUsuarios);
		
		JMenuItem mnCerrarSesion = new JMenuItem("Cerrar sesion");
		mnCerrarSesion.setForeground(Color.RED);
		mnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicial.main(null);
				dispose();
			}
		});
		mnGestion.add(mnCerrarSesion);
		
		 try {
			coches = DBManager.listarcoches();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		DefaultListModel<String> modelo = new DefaultListModel<>();
		JList listaArticulos = new JList(modelo);
		listaArticulos.setForeground(Color.BLACK);
		listaArticulos.setFont(new Font("Arial", Font.PLAIN, 15));
		listaArticulos.setBackground(new Color(255, 255, 255));
		listaArticulos.setBounds(50, 54, 487, 234);
		contentPane.add(listaArticulos);
		
		JScrollPane scrollpane = new JScrollPane(listaArticulos);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        scrollpane.setBounds(50, 54, 487, 234);
		contentPane.add(scrollpane);
		
		JLabel lblGestionStock = new JLabel("                Gestion de Stock");
		lblGestionStock.setFont(new Font("Tahoma", Font.PLAIN, 27));
		scrollpane.setColumnHeaderView(lblGestionStock);
		
		JButton btnExpACsv = new JButton("Exp a CSV");
		btnExpACsv.setForeground(Color.WHITE);
		btnExpACsv.setBackground(new Color(0, 128, 0));
		btnExpACsv.setBounds(245, 299, 100, 39);
		contentPane.add(btnExpACsv);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = modelo.get(listaArticulos.getSelectedIndex());
				coches.remove(listaArticulos.getSelectedIndex());
				modelo.remove(listaArticulos.getSelectedIndex());
				 try {
					try {
						DBManager.borrarCoche(p);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				validate();
				repaint();
			}
		});
		
		for (String producto : coches) {
			modelo.addElement(producto);
		}
		//metodo para pasar el arraylist a un fichero .csv
		btnExpACsv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String desktopPath = System.getProperty("user.home") + "/github/EasyRentingMotors" + "/coches.csv";
				String ruta = desktopPath.replace("\\", "/");
				
		 
	
				File archivo = new File(ruta);
				PrintWriter pw = null;
					
				try {
					pw = new PrintWriter(archivo);
					for(String p: coches) {
						pw.println(p);
						
						
					}
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} finally {
					if(pw!=null) {
						pw.flush();
						pw.close();
						JOptionPane.showMessageDialog(null, "Fichero .Csv creado correctamente", "EXPORTACION CORRECTA", JOptionPane.INFORMATION_MESSAGE);
					}
				}
		        
			}
		
		});
		
	}
}

