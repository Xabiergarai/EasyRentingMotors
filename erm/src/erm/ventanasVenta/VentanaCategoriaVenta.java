package erm.ventanasVenta;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erm.ventanasPrimarias.VentanaInicial;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window;
import javax.swing.JLabel;
import java.awt.Font;


public class VentanaCategoriaVenta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCategoriaVenta frame = new VentanaCategoriaVenta();
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
	public VentanaCategoriaVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCategoriaA = new JButton("Categoria A");
		btnCategoriaA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVentaCategoriaA va = new VentanaVentaCategoriaA();
				va.setVisible(true);
				dispose();
		}
		});
		btnCategoriaA.setForeground(Color.WHITE);
		btnCategoriaA.setBackground(new Color(255, 165, 0));
		btnCategoriaA.setBounds(48, 86, 206, 66);
		contentPane.add(btnCategoriaA);
		
		JButton btnCategoriaB = new JButton("Categoria B");
		btnCategoriaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCategoriaB.setForeground(Color.WHITE);
		btnCategoriaB.setBackground(new Color(255, 165, 0));
		btnCategoriaB.setBounds(342, 86, 206, 66);
		contentPane.add(btnCategoriaB);
		
		JButton btnCategoriaC = new JButton("Categoria C");
		btnCategoriaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCategoriaC.setForeground(Color.WHITE);
		btnCategoriaC.setBackground(new Color(255, 165, 0));
		btnCategoriaC.setBounds(48, 187, 206, 66);
		contentPane.add(btnCategoriaC);
		
		JButton btnCategoriaD = new JButton("Categoria D");
		btnCategoriaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCategoriaD.setForeground(Color.WHITE);
		btnCategoriaD.setBackground(new Color(255, 165, 0));
		btnCategoriaD.setBounds(342, 187, 206, 66);
		contentPane.add(btnCategoriaD);
		
		JButton btnVlvAtras = new JButton("Volver atras");
		btnVlvAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaVentasInformacion v1 = new VentanaVentasInformacion();
				v1.setVisible(true);
				dispose();
			}
		});
		btnVlvAtras.setBounds(230, 303, 138, 23);
		contentPane.add(btnVlvAtras);
		
		JLabel lblNewLabel = new JLabel("Selecciona la categoria que deseas vender:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(48, 26, 334, 30);
		contentPane.add(lblNewLabel);
		
		
	}
}

