package erm.ventanasAdminstrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.core.DB;

import erm.clasesBasicas.Usuario;
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
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ListModel;
import java.awt.Font;
import javax.swing.JLabel;

public class VentanaGestionUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGestionUsuarios frame = new VentanaGestionUsuarios();
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
	public VentanaGestionUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarUsuario.main(null);
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
		
		JMenu mnNewMenu = new JMenu("Gestion");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Stock");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionStock.main(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Usuarios");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGestionUsuarios.main(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar sesion");
		mntmNewMenuItem_1.setForeground(Color.RED);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicial.main(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		 try {
			usuarios = DBManager.listarUsuarios();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
		DefaultListModel<Usuario> modelo = new DefaultListModel<>();
		JList listaUsuarios = new JList(modelo);
		listaUsuarios.setForeground(Color.BLACK);
		listaUsuarios.setFont(new Font("Arial", Font.PLAIN, 15));
		listaUsuarios.setBackground(new Color(255, 255, 255));
		listaUsuarios.setBounds(50, 54, 487, 234);
		contentPane.add(listaUsuarios);
		
		JScrollPane scrollpane = new JScrollPane(listaUsuarios);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        scrollpane.setBounds(50, 54, 487, 234);
		contentPane.add(scrollpane);
		
		JLabel lblNewLabel = new JLabel("                Gestion de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		scrollpane.setColumnHeaderView(lblNewLabel);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = modelo.get(listaUsuarios.getSelectedIndex());
				usuarios.remove(listaUsuarios.getSelectedIndex());
				modelo.remove(listaUsuarios.getSelectedIndex());
				 try {
					try {
						DBManager.borrarUsuarioGestion(u);
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
		
		for (Usuario usuario : usuarios) {
			modelo.addElement(usuario);
		}

		
	}
}

