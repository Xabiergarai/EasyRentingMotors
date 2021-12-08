package erm.ventanasSecundarias;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.UIManager;

import erm.ventanasPrimarias.VentanaVenderCoche;

public class VentanaVentasInformacion extends JFrame {

	/**
	 * Creamos la ventana
	 */
	
	public VentanaVentasInformacion() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lblVentas = new JLabel("Ventas ");
		lblVentas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVentas.setForeground(new Color(255, 165, 0));
		lblVentas.setBounds(172, 28, 90, 20);
		getContentPane().add(lblVentas);

		JButton btnInfoVentas = new JButton("Informacion de ventas");
		btnInfoVentas.setBackground(UIManager.getColor("CheckBox.background"));
		btnInfoVentas.setBounds(67, 117, 297, 29);
		getContentPane().add(btnInfoVentas);

		JButton btnVenderCoche = new JButton("Vender coche");
		btnVenderCoche.setBackground(UIManager.getColor("CheckBox.background"));
		btnVenderCoche.setBounds(67, 77, 297, 29);
		getContentPane().add(btnVenderCoche);
		
		btnVenderCoche.addActionListener(e -> {
				 VentanaVenderCoche v2 = new VentanaVenderCoche();
				 v2.setVisible(true);
					dispose();
		});
		

		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.setBackground(UIManager.getColor("CheckBox.background"));
		btnVolverAtras.setBounds(67, 197, 297, 29);
		getContentPane().add(btnVolverAtras);
		
		btnVolverAtras.addActionListener(e -> {
				VentanaAjustes v3 = new VentanaAjustes();
				v3.setVisible(true);
				dispose();
		});
		

		JButton btnOpiniones = new JButton("Opiniones");
		btnOpiniones.setBackground(UIManager.getColor("CheckBox.background"));
		btnOpiniones.setBounds(67, 157, 297, 29);
		getContentPane().add(btnOpiniones);

	

	}

}
