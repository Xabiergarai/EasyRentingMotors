package erm.ventanasPrimarias;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class VentanaAjustes extends JFrame{

	public VentanaAjustes() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(UIManager.getColor("EditorPane.disabledBackground"));
		getContentPane().setLayout(null);
		
		JLabel lblConfiguracion = new JLabel("Configuracion");
		lblConfiguracion.setForeground(UIManager.getColor("ComboBox.selectionBackground"));
		lblConfiguracion.setBackground(Color.PINK);
		lblConfiguracion.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblConfiguracion.setBounds(10, 11, 297, 29);
		getContentPane().add(lblConfiguracion);
		
		JLabel lblDatosDeTu = new JLabel("Datos de tu cuenta\r\n");
		lblDatosDeTu.setBackground(Color.PINK);
		lblDatosDeTu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeTu.setBounds(10, 66, 229, 20);
		getContentPane().add(lblDatosDeTu);
		
		JLabel lblSesion = new JLabel("Sesion");
		lblSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSesion.setBounds(10, 208, 69, 20);
		getContentPane().add(lblSesion);
		
		JLabel lblContacto = new JLabel("Servicio");
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContacto.setBounds(10, 312, 110, 20);
		getContentPane().add(lblContacto);
		
		JButton BotonPrivacidad = new JButton("Privacidad");
		BotonPrivacidad.setBackground(UIManager.getColor("CheckBox.background"));
		BotonPrivacidad.setBounds(57, 125, 297, 20);
		getContentPane().add(BotonPrivacidad);
		
		JButton BotonSeguridad = new JButton("Seguridad");
		BotonSeguridad.setBackground(UIManager.getColor("CheckBox.background"));
		BotonSeguridad.setBounds(57, 144, 297, 23);
		getContentPane().add(BotonSeguridad);
		
		JButton BotonPago = new JButton("Metodos de pago");
		BotonPago.setBackground(UIManager.getColor("CheckBox.background"));
		BotonPago.setBounds(57, 163, 297, 23);
		getContentPane().add(BotonPago);
		
		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		botonCerrarSesion.setBackground(UIManager.getColor("CheckBox.background"));
		botonCerrarSesion.setBounds(57, 239, 297, 23);
		getContentPane().add(botonCerrarSesion);
		
		JButton BotonSalir = new JButton("Salir de la aplicacion");
		BotonSalir.setBackground(UIManager.getColor("CheckBox.background"));
		BotonSalir.setBounds(57, 263, 297, 23);
		getContentPane().add(BotonSalir);
		
		JButton BotonInformacion = new JButton("Contacto");
		BotonInformacion.setBackground(UIManager.getColor("CheckBox.background"));
		BotonInformacion.setBounds(57, 353, 297, 23);
		getContentPane().add(BotonInformacion);
		
		JButton btnvlvAtras = new JButton("Volver atras");
		btnvlvAtras.setBackground(UIManager.getColor("CheckBox.background"));
		btnvlvAtras.setBounds(57, 376, 297, 23);
		getContentPane().add(btnvlvAtras);
		
		JButton btnVentasEInformacion = new JButton("Ventas e informacion");
		btnVentasEInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVentasEInformacion.setBackground(UIManager.getColor("CheckBox.background"));
		btnVentasEInformacion.setBounds(57, 106, 297, 20);
		getContentPane().add(btnVentasEInformacion);
		
		btnVentasEInformacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//VentanaVentasEInformacion v5 = new VentanaVentasEInformacion();
				//v5.setVisible(true);
				dispose();
			}
		});
		
		
		BotonPrivacidad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//VentanaPrivacidad v2 = new VentanaPrivacidad();
				//v2.setVisible(true);
				dispose();
				
				
				
			}
			
		});
		
		botonCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogIn vl = new VentanaLogIn();
				vl.setVisible(true);
				dispose();
				
			
				
			}
		});
		
		BotonPago.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			  //VentanaPagoAjustes v3 = new VentanaPagoAjustes();
			  //v3.setVisible(true);
			  dispose();
			  
			}
			
		});
		
		BotonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
				
			}
		});
		
		 BotonInformacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//VentanaAyudaInformacion v4 = new VentanaAyudaInformacion();
				//v4.setVisible(true);
				  dispose();
				
			}
			 
		 });
		
		BotonSeguridad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//VentanaSeguridad vs = new VentanaSeguridad();
				//vs.setVisible(true);
				setVisible(false);
				 
				
			}
		});
		
		btnvlvAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vs = new VentanaPrincipal();
				vs.setVisible(true);
				setVisible(false);
			
			
			}
	});
}
}