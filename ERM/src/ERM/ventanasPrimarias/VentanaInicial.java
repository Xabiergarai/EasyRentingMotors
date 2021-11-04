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
import javax.swing.SwingUtilities;

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
		setBounds(100, 100, 638, 639);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.addActionListener(e->{
			VentanaRegistro vr = null;
			try {
				vr = new VentanaRegistro();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vr.setVisible(true);
			dispose();
		});
	
		btnRegistro.setBounds(317, 518, 284, 48);
		getContentPane().add(btnRegistro);
	
		JLabel lblLogo = new JLabel("Foto");
		lblLogo.setBounds(185, 192, 149, 113);
		ImageIcon ico = new ImageIcon("EasyRentingMotors/imagenes/loggo.png");
        ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
        lblLogo.setIcon(img);
		
		
		
		JLabel lblTitulo = new JLabel("EASY RENTING MOTORS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Algerian", Font.BOLD, 40));
		lblTitulo.setBounds(23, 28, 564, 71);
		getContentPane().add(lblTitulo);
	
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(e->{
			VentanaLogIn vi = null;
			vi = new VentanaLogIn();
			vi.setVisible(true);
			dispose();
			JOptionPane.showMessageDialog(null, "Introduzca sus credenciales", "login", JOptionPane.INFORMATION_MESSAGE);
		
		});
		
		btnLogin.setBounds(23, 518, 284, 48);
		getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("\u00A1BIENVENID@ AL MEJOR CONCESIONARIO DEL MUNDO!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Zilla Slab", Font.ITALIC, 18));
		lblNewLabel.setBounds(23, 110, 554, 14);
		getContentPane().add(lblNewLabel);
	}
	
	 
	
}

