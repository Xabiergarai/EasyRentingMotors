package erm.ventanasVenta;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import erm.categoriasCoche.CategoriaA;
import erm.categoriasCoche.Coche;
import erm.clasesBasicas.Venta;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaPrincipal;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

public class VentanaVistaVenta extends JFrame{
	
	public VentanaVistaVenta() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ventas");
		lblTitulo.setForeground(new Color(255, 165, 0));
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);
		
		
	}
	
	private JPanel CochePanel(Venta v) {
			
			JPanel panel =  new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			panel.setBackground(Color.WHITE);

			/*JLabel lblImagen = new JLabel();
			lblImagen.setBounds(72, 90, 124, 141);
			ImageIcon ico1= new ImageIcon(v.getRutaFoto());//meter las rutas en la bd
			ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
			lblImagen.setIcon(img1);
			lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(lblImagen);*/

			JLabel lblNombre = new JLabel(v.getNombre());
			lblNombre.setBackground(Color.WHITE);
			lblNombre.setToolTipText("");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(lblNombre);

			JLabel lblPrecio = new JLabel(String.valueOf(v.getPrecio()+"€"));
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(lblPrecio);
			

			return panel;
		}	
		


}
