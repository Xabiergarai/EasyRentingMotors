package ERM.ventanasPrimarias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import ERM.dataBase.DBException;





public class VentanaInicial extends JFrame{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaInicial() {
		
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistro registro = null;
				try {
					registro = new VentanaRegistro();
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				registro.setVisible(true);
				dispose();
			}
		});
	
		btnRegistro.setBounds(293, 482, 273, 48);
		getContentPane().add(btnRegistro);
	
		JLabel lblLogo = new JLabel("Foto");
		lblLogo.setBounds(185, 192, 149, 113);
		ImageIcon ico = new ImageIcon("EasyRentingMotors/imagenes/loggo.png");
        ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
        lblLogo.setIcon(img);
		
		
		
		JLabel lblTitulo = new JLabel("EASY RENTING MOTORS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Algerian", Font.BOLD, 40));
		lblTitulo.setBounds(23, 28, 543, 71);
		getContentPane().add(lblTitulo);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaLogIn login = new VentanaLogIn();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(23, 482, 255, 48);
		getContentPane().add(btnLogin);
	}
}
