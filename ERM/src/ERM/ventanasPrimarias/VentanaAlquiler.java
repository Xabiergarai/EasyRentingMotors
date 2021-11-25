package ERM.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ERM.categoriasCoche.Coche;
import ERM.clasesBasicas.Alquiler;
import ERM.clasesBasicas.Usuario;
import ERM.dataBase.DBManager;

public class VentanaAlquiler extends JFrame{

	private JPanel contentPane,panelAbajo,panelCentral,panelBotonera;
	public static Connection con;
	public static String nombreBD = "usuarios.db";

	private JComboBox<Coche>comboCoche;
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
		
		comboCoche = new JComboBox<>();
		panelCentral.add(comboCoche);
		
		
		panelBotonera = new JPanel();
		panelAbajo.add(panelBotonera);
		
		btnALquilar = new JButton("REALIZAR ALQUILER");
		panelBotonera.add(btnALquilar);
		
		cargarComboVehiculos();

		btnALquilar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT nickname FROM Usuarios ";
				Statement st = null;
				ResultSet rs = null;
				rs = st.executeQuery(sql);
				
				Coche c = (Coche) comboCoche.getSelectedItem();
				Date fechainit = new Date(System.currentTimeMillis());
				//Date fechaFin=
				Alquiler alq = new Alquiler(rs.getString(3), c.getId(), fechainit,fechaFin);
				con = DBManager.initBD(nombreBD);
				//DBManager.insertarAlquiler(con, alq);
				//DBManager.disconnect();
				JOptionPane.showMessageDialog(null, "ALQUILER INSERTADO");
			}
		});
		
		
		setVisible(true);

	}
	private void cargarComboVehiculos() {
		con = DBManager.initBD(nombreBD);
		ArrayList<Coche> ac = DBManager.obtenerCoches(con);
		DBManager.disconnect();
		for(Coche v : ac) {	
			comboCoche.addItem(v);
}
		
		
	}
	
	
}
