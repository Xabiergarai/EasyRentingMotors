package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.clasesBasicas.ListaUsuario;
import erm.clasesBasicas.Usuario;

class ListaUsuarioTest {
	
	ListaUsuario listaUsuario = new ListaUsuario();
	ArrayList<Usuario> lista = listaUsuario.getUsuarios();

	
	@BeforeEach
	void setUplistaUsuario() {
		
		lista.add(new Usuario("Xabier", "Garai Pascual", "XabierG", "Cont123", "Xabier.garai@opendeusto.es", "192.72.20.16"));
		lista.get(0);	}
	
	@Test
	public void de() {
		listaUsuario.setUsuarios(lista);
		assertEquals(lista,listaUsuario.getUsuarios() );
	}
	
	
}
