package erm.ventanasSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import erm.ventanasPrimarias.VentanaPrincipal;


public class VentanaTransaccionCompra extends JFrame {
	
	/**
	 * Método que contiene un hilo que salta al a hora de realizar la compra de la tabla de coches seleccionados
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTransaccionCompra window = new VentanaTransaccionCompra();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel pCentral;
	public VentanaTransaccionCompra() {
		setBounds(800,300,400,100);
		setTitle("Espera unos segundos mientras se realiza la transacción");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pCentral = new JPanel();
		getContentPane().add(pCentral,BorderLayout.CENTER);
		JFrame ventana = this;
		Runnable r = new Runnable() { //objeto ejecutable
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<5;i++) {
					JLabel lbl = new JLabel(".");
					lbl.setFont(new Font(Font.SERIF,Font.BOLD, 30));
					pCentral.add(lbl);
					getContentPane().validate();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ventana.dispose();
				JOptionPane.showMessageDialog(null,"Gracias por su compra, la operación se ha realizado con exito");
			}
		};
		Thread t = new Thread(r); //hilo
		t.start();
		setVisible(true);
	}
}



