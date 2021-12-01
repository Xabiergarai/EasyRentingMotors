package erm.clasesBasicas;
	

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.PrintWriter;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;

import erm.categoriasCoche.CategoriaA;
import erm.categoriasCoche.CategoriaB;
import erm.categoriasCoche.CategoriaC;
import erm.categoriasCoche.CategoriaD;
import erm.categoriasCoche.Coche;

	public class Contenedora {
		/**
		 * Lista con toda la informacion de los Coches
		 */
		public ArrayList<Coche> listaCoches;
		public ArrayList<Coche> favorito;
		public ArrayList<Coche> carrito;
		
		public Contenedora() {
			listaCoches = new ArrayList<Coche>();
			favorito = new ArrayList<Coche>();
			carrito = new ArrayList<Coche>();
			
		}

		public ArrayList<Coche> getListaCoches() {
			return listaCoches;
		}

		public void setListaCoches(ArrayList<Coche> listaCoches) {
			this.listaCoches = listaCoches;
		}

		public ArrayList<Coche> getFavorito() {
			return favorito;
		}

		public void setFavorito(ArrayList<Coche> favorito) {
			this.favorito = favorito;
		}
		
		public ArrayList<Coche> getCarrito() {
			return carrito;
		}

		public void setCarrito(ArrayList<Coche> carrito) {
			this.carrito = carrito;
		}
		
		public void vaciarListaDeseos() {
			for(int i=0;i<favorito.size();i++)
				favorito.remove(i);
		}	
		
		public void vaciarCarrito() {
			for(int i=0;i<carrito.size();i++)
				carrito.remove(i);
		}	
		
		/**
		 * Metodo que guarda el contenido del carrito en un fichero de texto para generar la factura
		 */
		/* public void guardarCarritoEnFicheroDeTexto(String nombreUsuario) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha = new Date(System.currentTimeMillis()); //fecha actual
			String nomfich = nombreUsuario+ " " +sdf.format(fecha)+".txt";
			PrintWriter pw=null;
			try {
				pw = new PrintWriter(new FileWriter(nomfich,true)); //true = abrir el fichero en modo append(que no te borre lo q ya esta en el fichero)
				for(Coche p : carrito) {
					pw.println(p);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(pw!=null) {
					pw.flush(); //vaciar flujo de salida
					pw.close();
				}
			}
		} */
	 public void guardarListaCochesEnFichero() {

			try {
				FileOutputStream fos = new FileOutputStream("Coches.DAT");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for(Coche p: listaCoches)
					oos.writeObject(p);
				oos.writeObject(null);
				oos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
	
		/**
		 * Metodo que actualiza el contenido del fichero con la informacion del ArrayList
		 */
		
		
		public void cargarFicheroCoches() {
			try {
				FileInputStream fis = new FileInputStream("Coches.DAT");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object p = ois.readObject();
				while(p!=null) {
					if(p instanceof CategoriaA) {
						CategoriaA o = (CategoriaA)p;
						listaCoches.add(o);
					} else if(p instanceof CategoriaB) {
						CategoriaB o = (CategoriaB)p;
						listaCoches.add(o);
					} else if(p instanceof CategoriaC) {
						CategoriaC o = (CategoriaC)p;
						listaCoches.add(o);
					} else if(p instanceof CategoriaD) {
						CategoriaD o = (CategoriaD)p;
						listaCoches.add(o);
					}
					p = ois.readObject(); //lea siguiente objeto
				}
				ois.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
		
		

