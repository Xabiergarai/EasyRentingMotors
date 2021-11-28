package erm.ventanasPrimarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaOpciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelSur, panelCentral;
	private JButton btnAtras, btnComprar, btnVender, btnAlquilar;
	private JFrame ventanaActual;

	public VentanaOpciones() {
		// TODO Auto-generated constructor stub

		ventanaActual = this;
		setTitle("Menú inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500, 500, 500, 500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);

		btnComprar = new JButton("Comprar");
		btnComprar.setBackground(Color.WHITE);
		btnVender = new JButton("Vender");
		btnVender.setBackground(Color.WHITE);
		btnAlquilar = new JButton("Alquilar");
		btnAlquilar.setBackground(Color.WHITE);
		btnAtras = new JButton("SALIR");
		btnAtras.setBackground(Color.WHITE);

		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 2, 0, 0));
		panelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));

		panelCentral.add(btnComprar);
		panelCentral.add(btnVender);
		panelCentral.add(btnAlquilar);
		panelCentral.add(btnAtras);

		panelCentral.setBackground(Color.BLACK);

		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaLogIn();
				ventanaActual.setVisible(false);
			}
		});
btnAlquilar.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new VentanaAlquiler();
		setVisible(false);
	}
});
		btnComprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaPrincipal();
				ventanaActual.setVisible(false);
			}
		});

		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while (true) {
					btnComprar.setForeground(Color.GREEN);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					btnComprar.setForeground(Color.BLACK);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		};
		Thread t1 = new Thread(r1);
		t1.start();

		btnAtras.addMouseListener(new MouseListener() {

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnAtras.setBackground(Color.RED);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

btnAlquilar.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		btnAtras.setBackground(Color.WHITE);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
});
btnComprar.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		btnAtras.setBackground(Color.WHITE);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
});
btnVender.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		btnAtras.setBackground(Color.WHITE);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
});
		setVisible(true);
	}

}
