package erm.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import erm.categoriasCoche.Coche;
import erm.clasesBasicas.Alquiler;
import erm.dataBase.DBException;
import erm.dataBase.DBManager;

public class VentanaAlquiler extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane,panelAbajo,panelCentral,panelNorte,panelBotonera;
	public static Connection con;
	public static String nombreBD = "EasyRentingMotors.db";
	
	private JLabel lblNombre;
	private JTextField textNombre;
	private JCalendar calendario;

	private JComboBox<String>comboCoche;
	private JButton btnALquilar;
	 

	public VentanaAlquiler() throws DBException, SQLException  {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelAbajo = new JPanel();
		contentPane.add(panelAbajo, BorderLayout.SOUTH);
		
		panelNorte= new JPanel();
		contentPane.add(panelNorte,BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNombre = new JLabel("Introduce tu nombre:");
		panelAbajo.add(lblNombre);

		textNombre = new JTextField();
		panelAbajo.add(textNombre);
		textNombre.setColumns(10);
		
		
		comboCoche = new JComboBox<>();
		panelNorte.add(comboCoche);
		
		calendario = new JCalendar();
		panelCentral.add(calendario);
		
		
		/*CALENDARIO*/
		calendario.setTodayButtonVisible(true);
		calendario.setTodayButtonText("Volver a la fecha actual");
		
		calendario.setWeekOfYearVisible(false);
		calendario.setMaxDayCharacters(2);
		calendario.setForeground(Color.GREEN);
		calendario.setSundayForeground(Color.BLACK);
		calendario.setWeekdayForeground(Color.GRAY);
		// Establecer las fechas mínima y máxima seleccionable
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaM =  new Date(System.currentTimeMillis());
		String fechaMin=sdf.format(fechaM);
		String fechaMax = "2022-12-31";
		try {
			Date fMin = sdf.parse(fechaMin);
			Date fMax = sdf.parse(fechaMax);
			calendario.setMinSelectableDate(fMin);
			calendario.setMaxSelectableDate(fMax);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("no llega");
		
		cargarComboVehiculos();
		System.out.println("Llega");
		Date fechaDelCalendario = calendario.getDate();
		String fc = sdf.format(fechaDelCalendario);
		
		panelBotonera = new JPanel();
		panelAbajo.add(panelBotonera);
		
		btnALquilar = new JButton("REALIZAR ALQUILER");
		panelBotonera.add(btnALquilar);
		
		

		btnALquilar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = textNombre.getText();
				
				Date fechaf = calendario.getDate();
				String ff = sdf.format(fechaf);
				int pos= comboCoche.getSelectedIndex();
				//if(!pos==-1)
					
				
				//Coche c =  comboCoche.getSelectedItem();
				Date fechainit = new Date(System.currentTimeMillis());
				String fi=sdf.format(fechainit);
				//Alquiler alq = new Alquiler(textNombre.getText(), c.getId(), fi,ff);
				try {
					con = DBManager.initBD(nombreBD);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					DBManager.disconnect();
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "ALQUILER INSERTADO");
			}
		});
		
		
		setVisible(true);

	}
	private void cargarComboVehiculos() throws DBException, SQLException {
		con = DBManager.initBD(nombreBD);
		TreeSet<String> ac =  DBManager.obtenerNombresCoches();
		DBManager.disconnect();
		for(String v : ac) {	
			System.out.println(v);
			comboCoche.addItem(v);
}
		
		
	}
	
	
}
