package com.grupotema.portalcondo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grupotema.portalcondo.domain.Usuario;

@RestController
@RequestMapping(value="/Usuarios")
public class UsuarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> listar() {
		Usuario usr1 = new Usuario(1, "Maria dos Reis", "maria", "123");
		Usuario usr2 = new Usuario(2, "Jose Pedro Dia", "josep", "321");
		
		List<Usuario> lista = new ArrayList<>();
		lista.add(usr1);
		lista.add(usr2);
		
		return lista;
	}
}
