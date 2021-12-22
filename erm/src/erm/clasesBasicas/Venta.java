package erm.clasesBasicas;

public class Venta {

	public static int cont;
	private int idUsuario;
	private int idVenta;

	public Venta(int idUsuario, int idVenta, String equipo, String temporada, String talla, String precio,
			String descripcion) {
		super();
		this.idUsuario = idUsuario;
		this.idVenta = idVenta;

	}

	public Venta() {
		super();
		this.idUsuario = 0;
		this.idVenta = cont++;

	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getidVenta() {
		return idVenta;
	}

	public void setidVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
