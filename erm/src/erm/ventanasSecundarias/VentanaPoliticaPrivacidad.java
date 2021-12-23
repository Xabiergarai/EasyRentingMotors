package erm.ventanasSecundarias;

import erm.ventanasPrimarias.VentanaPrincipal;
import erm.ventanasSecundarias.VentanaPrivacidad;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JCheckBox;



public class VentanaPoliticaPrivacidad extends JFrame {
	public VentanaPoliticaPrivacidad() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 454, 555);
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		
		JLabel lblPoliticaPrivacidad = new JLabel("Politica de privacidad");
		lblPoliticaPrivacidad.setForeground(new Color(255, 165, 0));
		lblPoliticaPrivacidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoliticaPrivacidad.setBounds(128, 11, 160, 29);
		getContentPane().add(lblPoliticaPrivacidad);
		
		JTextPane txtpnATravsDe = new JTextPane();
		txtpnATravsDe.setText("A trav\u00E9s de este sitio web no se recaban datos de car\u00E1cter personal de los "
				+ "usuarios sin su conocimiento, ni se ceden a terceros.\r\n\r\nCon la finalidad de ofrecerle el mejor "
				+ "servicio y con el objeto de facilitar el uso, se analizan el n\u00FAmero de p\u00E1ginas visitadas, "
				+ "el n\u00FAmero de visitas, as\u00ED como la actividad de los visitantes y su frecuencia de "
				+ "utilizaci\u00F3n. A estos efectos, la Agencia Espa\u00F1ola de Protecci\u00F3n de Datos (AEPD) "
				+ "utiliza la informaci\u00F3n estad\u00EDstica elaborada por el Proveedor de Servicios de "
				+ "Internet.\r\n\r\nLa AEPD no utiliza cookies para recoger informaci\u00F3n de los usuarios, "
				+ "ni registra las direcciones IP de acceso. \u00DAnicamente se utilizan cookies propias,  de sesi\u00F3n,"
				+ " con finalidad t\u00E9cnica (aquellas que permiten al usuario la navegaci\u00F3n a trav\u00E9s del "
				+ "sitio web y la utilizaci\u00F3n de las diferentes opciones y servicios que en ella existen)."
				+ "\r\n\r\nEl portal del que es titular la AEPD contiene enlaces a sitios web de terceros, cuyas "
				+ "pol\u00EDticas de privacidad son ajenas a la de la AEPD. Al acceder a tales sitios web usted "
				+ "puede decidir si acepta sus pol\u00EDticas de privacidad y de cookies. Con car\u00E1cter general, "
				+ "si navega por internet usted puede aceptar o rechazar las cookies de terceros desde las opciones de"
				+ " configuracion de su navegador.");
		
		txtpnATravsDe.setBackground(SystemColor.menu);
		txtpnATravsDe.setBounds(27, 65, 376, 341);
		getContentPane().add(txtpnATravsDe);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(27, 430, 89, 23);
		getContentPane().add(btnAtras);
		
		JCheckBox cbAcepto = new JCheckBox("Acepto");
		cbAcepto.setBounds(302, 430, 99, 23);
		getContentPane().add(cbAcepto);
		
		if(cbAcepto.isSelected()) {
			
			 JOptionPane.showMessageDialog(null, "Has aceptado la politica de privacidad", "Privacidad", JOptionPane.INFORMATION_MESSAGE);
			 VentanaPrincipal v = new VentanaPrincipal();
			 v.setVisible(true);
			 dispose();
		}
		
		btnAtras.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 VentanaPrivacidad v1 = new VentanaPrivacidad();
				 v1.setVisible(true);
				 dispose();
				 
				 
			 }
		});
		
	}
}
