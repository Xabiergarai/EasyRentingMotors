package erm.ventanasSecundarias;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.UIManager;

import erm.dataBase.DBException;
import erm.dataBase.DBManager;
import erm.ventanasPrimarias.VentanaInicial;
import erm.ventanasPrimarias.VentanaLogIn;

import java.awt.SystemColor;

public class VentanaPrivacidad extends JFrame  {
	public VentanaPrivacidad() {
		
		int idU = VentanaLogIn.getUsuarioId();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		
		JLabel lblPrivacidad = new JLabel("Privacidad\r\n");
		lblPrivacidad.setForeground(new Color(255, 165, 0));
		lblPrivacidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrivacidad.setBounds(171, 29, 99, 17);
		getContentPane().add(lblPrivacidad);
		
		JButton btnAcercaDe = new JButton("Acerca de");
		btnAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcercaDe.setBackground(UIManager.getColor("CheckBox.background"));
		btnAcercaDe.setBounds(52, 122, 297, 29);
		getContentPane().add(btnAcercaDe);
		
		JButton btnPoliticaDePrivacidad = new JButton("Politica de privacidad");
		btnPoliticaDePrivacidad.setBackground(UIManager.getColor("CheckBox.background"));
		btnPoliticaDePrivacidad.setBounds(52, 82, 297, 29);
		getContentPane().add(btnPoliticaDePrivacidad);
		
		JButton btnEliminarCuenta = new JButton("Eliminar cuenta");
		btnEliminarCuenta.setBackground(UIManager.getColor("CheckBox.background"));
		btnEliminarCuenta.setBounds(52, 162, 297, 29);
		getContentPane().add(btnEliminarCuenta);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setBackground(UIManager.getColor("CheckBox.background"));
		btnAtras.setBounds(52, 202, 297, 29);
		getContentPane().add(btnAtras);
		
		btnPoliticaDePrivacidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPoliticaPrivacidad v2 = new VentanaPoliticaPrivacidad();
				v2.setVisible(true);
				dispose();
				
			}
			
		});
		
		
		btnEliminarCuenta.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				DBManager dbm = new DBManager();
					if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar permanentemente su cuenta?", "Eliminacion de cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						try {
							dbm.initBD("EasyRentingMotors.db");
							
							dbm.eliminarUsuario(idU);
							dbm.disconnect();
							dispose();
							VentanaInicial vl = new VentanaInicial();
							vl.setVisible(true);
					
							
						} catch (DBException e1) {
							e1.printStackTrace();
						}
				
					}
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnAcercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()) {
                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                    if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                        try {
                            java.net.URI uri = new java.net.URI("https://www.autonocion.com/datos-curiosos-de-la-industria-del-automovil/");
                            desktop.browse(uri);
                        }catch (URISyntaxException | IOException ex) {}
                        }
                    }

            }
				
			});
			
		}
	}

