package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.clasesBasicas.ListaUsuario;
import erm.clasesBasicas.Usuario;

class ListaUsuarioTest {		
	ListaUsuario listaUsuario = new ListaUsuario();
	private ArrayList<Usuario> usuarios;
	ArrayList<Usuario> lista = listaUsuario.getUsuarios();
	
	@Test
	public ArrayList<Usuario> myArray(){
		lista.add(new Usuario("Xabier", "Garai Pascual", "XabierG", "Cont123", "Xabier.garai@opendeusto.es", "192.72.20.16"));
		lista.get(0);
		return lista;		
	}
	
	
	@Test
	public void testmyArray() {
		ListaUsuarioTest test = new ListaUsuarioTest();
	    Assert.assertNotNull("no deberia ser null", test);
						
	}
	
	@Test
	public void testSet() {
		listaUsuario.setUsuarios(lista);
		assertEquals(lista,listaUsuario.getUsuarios() );
	}
	
	
	
	
	
}
