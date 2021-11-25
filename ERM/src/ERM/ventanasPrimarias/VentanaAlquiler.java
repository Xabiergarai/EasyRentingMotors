package ERM.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ERM.categoriasCoche.Coche;
import ERM.clasesBasicas.Usuario;
import ERM.dataBase.DBManager;

public class VentanaAlquiler extends JFrame{

	private JPanel contentPane,panelAbajo,panelCentral,panelBotonera;
	public static Connection con;
	public static String nombreBD = "usuarios.db";

	private JComboBox<Coche>comoboCoche;
	private JButton btnALquilar;

	public VentanaAlquiler() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelAbajo = new JPanel();
		contentPane.add(panelAbajo, BorderLayout.SOUTH);
		
		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelBotonera = new JPanel();
		panelAbajo.add(panelBotonera);
		
		btnALquilar = new JButton("REALIZAR ALQUILER");
		panelBotonera.add(btnALquilar);
		
		setVisible(true);

		btnALquilar.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent e) {
				Coche v = (Coche) comboVehiculos.getSelectedItem();
				Usuario usu = new Usuario();

				Date fecha = new Date(System.currentTimeMillis());
				Alquiler venta = new Alquiler(usu.getNomUsuario(), v.getId(), fecha);
				con = BD.initBD(nombreBD);
				BD.insertarVenta(con, venta);
				BD.closeBD(con);
				JOptionPane.showMessageDialog(null, "VENTA INSERTADA");
			}
		});
		
	}
	private void cargarComboVehiculos() {
		con = DBManager.initBD(nombreBD);
		ArrayList<Coche> av = DBManager.obtenerCoches(con);
		DBManager.disconect();
		for(Coche v : av) {	
			comoboCoche.addItem(v);
}
		
	}
}
