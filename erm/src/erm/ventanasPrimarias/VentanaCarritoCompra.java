package erm.ventanasPrimarias;

import erm.categoriasCoche.*; 
import erm.clasesBasicas.*;
import erm.clasesBasicas.Contenedora;
import erm.dataBase.DBManager;
import erm.ventanasSecundarias.VentanaTransaccionCompra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaCarritoCompra extends JFrame {
	

	private JFrame frame;
	private JPanel tablePanel;
	private JTable carritoTabla;
	private DefaultTableModel carritoModeloTabla;
	private JLabel lblTotal;
	private double precioTotal;
	public static Contenedora contenedora;
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarritoCompra window = new VentanaCarritoCompra(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	
	public VentanaCarritoCompra() {
		contenedora = new Contenedora();
		initialize();
	}
	public VentanaCarritoCompra(ListaCoche Coches) {
		this.precioTotal = 0;
		lblTotal = new JLabel();
		initTablePanel(VentanaPrincipal.carrito);
		initialize();
	}

	private void initTablePanel(ArrayList<Coche> carrito) {
		tablePanel = new JPanel(new GridLayout());
	    tablePanel.setBounds(10, 81, 360, 241);

		initTableModel(carrito);

		carritoTabla = new JTable();
		carritoTabla.setModel(carritoModeloTabla);
		tablePanel.add(carritoTabla);
		
		carritoTabla.getColumnModel().getColumn(0).setMaxWidth(40);
		carritoTabla.getColumnModel().getColumn(1).setMaxWidth(100);
		carritoTabla.getColumnModel().getColumn(2).setMaxWidth(140);
		carritoTabla.getColumnModel().getColumn(3).setMaxWidth(80);	
		
		
		//AÃ±adimos el Renderer a la tabla
		carritoTabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(column == 0) {
					c.setBackground(Color.LIGHT_GRAY);
				}else {
					c.setBackground(Color.WHITE);
				}

				// Cuando tengo que aplicar el cambio a toda la fila, compruebo
				// si se cumple la condiciÃ³n en el DefaultTableModel (carritoModeloTabla)
				double precio = (double)carritoModeloTabla.getValueAt(row, 3);
				if(precio<18000) {
					c.setForeground(Color.BLUE);
				}else {
					c.setForeground(Color.BLACK);
				}
				return c;
			}
		});

		JScrollPane js = new JScrollPane(carritoTabla);
		tablePanel.add(js);
	}
	
	
	
		

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Easy Renting Motors");
		frame.getContentPane().setLayout(null);
		updatePrecioTotal();
		lblTotal.setBounds(14, 527, 360, 16);
		frame.getContentPane().add(lblTotal);
		
		JButton btnVaciarCesta = new JButton("Vaciar cesta");
		btnVaciarCesta.setBounds(90, 349, 212, 29);
		btnVaciarCesta.addActionListener(e -> {
				while(carritoModeloTabla.getRowCount() != 0)
					carritoModeloTabla.removeRow(0);
				while (!VentanaPrincipal.carrito.isEmpty()) {
					VentanaPrincipal.carrito.remove(0);
				}
		});
		frame.getContentPane().add(btnVaciarCesta);
				
		JButton btnGuardarLista = new JButton("Guardar lista");
		btnGuardarLista.setBounds(90, 378, 212, 29);
		btnGuardarLista.addActionListener(e -> {			
			contenedora.guardarListaCochesEnFichero();
			contenedora.cargarFicheroCoches();
		//contenedora.guardarCarritoEnFicheroDeTexto();
			ArrayList<Carrito> car = null;
			if(carritoModeloTabla.getRowCount()!=0){
			for (Carrito coche : car) {
				
			}
			}
		});
		frame.getContentPane().add(btnGuardarLista);
		
		JButton btnSeguirComprando = new JButton("Seguir comprando");
		btnSeguirComprando.setBounds(90, 407, 212, 29);
		frame.getContentPane().add(btnSeguirComprando);
		btnSeguirComprando.addActionListener(e -> {
			frame.dispose();
		
		});
		
		JLabel lblPremium = new JLabel("* Con Easy Renting Motors puedes benificiarte de gastos");
		lblPremium.setBounds(14, 448, 352, 29);
		frame.getContentPane().add(lblPremium);
		
		JLabel lblEnvioGratis = new JLabel("de envio GRATIS!");
		lblEnvioGratis.setBounds(14, 475, 130, 16);
		frame.getContentPane().add(lblEnvioGratis);
		
		JCheckBox chckbxContratoTarifa = new JCheckBox("Contratar tarifa premium");
		chckbxContratoTarifa.setBounds(14, 498, 188, 23);
		frame.getContentPane().add(chckbxContratoTarifa);
		
		
		
		JButton btnRealizarPedido = new JButton("REALIZAR PEDIDO");
		btnRealizarPedido.setBackground(Color.ORANGE);
		btnRealizarPedido.setBounds(98, 555, 188, 29);
		frame.getContentPane().add(btnRealizarPedido);
		 btnRealizarPedido.addActionListener(e -> {
				// TODO Auto-generated method stub
				new VentanaTransaccionCompra();
				
				frame.dispose();
		}); 
		
		
		JLabel lblFormasDePago = new JLabel("Formas de pago");
		lblFormasDePago.setBounds(22, 625, 108, 16);
		frame.getContentPane().add(lblFormasDePago);
		
		JRadioButton radiobtVisa = new JRadioButton("VISA");
		radiobtVisa.setBounds(14, 665, 83, 23);
		frame.getContentPane().add(radiobtVisa);
		
		JRadioButton radiobtMaterCard = new JRadioButton("MasterCard");
		radiobtMaterCard.setBounds(107, 665, 119, 23);
		frame.getContentPane().add(radiobtMaterCard);
		
		JRadioButton radiobtPayPal= new JRadioButton("PayPal");
		radiobtPayPal.setBounds(238, 665, 97, 23);
		frame.getContentPane().add(radiobtPayPal);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(radiobtVisa);
		grupo1.add(radiobtMaterCard);
		grupo1.add(radiobtPayPal);

		frame.getContentPane().add(tablePanel);

		JLabel lblResumenCompra = new JLabel("Resumen Compra");
		lblResumenCompra.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 40));
		lblResumenCompra.setBounds(63, 28, 261, 43);
		frame.getContentPane().add(lblResumenCompra);
	}
	
	
	
	/** 
	 * 	Atributos que contendra la tabla de los coches señeccionados
	 * @param carrito
	 */

	private void initTableModel(ArrayList<Coche> carrito) {
		carritoModeloTabla = new DefaultTableModel();
		carritoModeloTabla.addColumn("Id");
		carritoModeloTabla.addColumn("Nombre");
		carritoModeloTabla.addColumn("Fecha de matriculacion");
		carritoModeloTabla.addColumn("Precio (€)");
		setTableContent(carrito);
		
		
	}
	
	/**
	 *  Se añaden los atributos de coche/s a la tabla
	 * @param carrito
	 */
	
	public void setTableContent(ArrayList<Coche> carrito) {
		clear();
		System.out.println(carrito);
		for (Coche Coche: carrito) {
			this.carritoModeloTabla.addRow(new Object[] {
					Coche.getId(),
					Coche.getNombre(),
					Coche.getfecha_matriculacion(),
					Coche.getPrecio()
			});
			precioTotal += Coche.getPrecio();
		}
		updatePrecioTotal();
		
		/*Hilo que hace que los productos se pongan en oferta a las 18:04:00
		 * y que dejen de estar en oferta a las 18:05:00*/
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mm:ss");
				
				boolean fin = false;
				while(fin == false) {
					long milis = System.currentTimeMillis();
					Date d = new Date(milis);
					String f = sdf.format(d);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//if(f.equals("30-11-21 15:55:00")) {
					//if(d.getMinutes() == 53) && d.getSeconds()==0) {
					if(d.getHours() == 19 && d.getMinutes() ==30 && d.getSeconds()==0) {
						try {
							DBManager.ponerCategoriaAEnOferta();
							setTableContent(carrito);
							
							fin = true;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				fin = false;
				while(fin == false) {
					long milis = System.currentTimeMillis();
					Date d = new Date(milis);
					String f = sdf.format(d);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//if(f.equals("30-11-21 15:55:00")) {
					//if(d.getMinutes() == 53) && d.getSeconds()==0) {
					if(d.getHours() == 20 && d.getMinutes() == 30 && d.getSeconds()==0) {
						try {
							DBManager.seAcabaLaOferta();
							setTableContent(carrito);
							
							fin = true;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
	}
	

	
	
	
	
	/**
	 * Se vacia la tabla de la cesta de la compra donde estan los coches
	 */
	
	public void clear() {
	    this.precioTotal = 0;
		this.carritoModeloTabla.setRowCount(0);
		updatePrecioTotal();
	}
	
	/** 
	 * Se suman los precios de los coches que se encuentran en la tabla
	 */

	private void updatePrecioTotal() {
		this.lblTotal.setText("TOTAL:   "+this.precioTotal+" €");
	}
}


