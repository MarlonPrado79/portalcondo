package com.grupotema.portalcondo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Usuarios")
public class UsuarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest funcionando";
	}
}
