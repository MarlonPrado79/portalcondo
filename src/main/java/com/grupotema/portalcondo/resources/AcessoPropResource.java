package com.grupotema.portalcondo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grupotema.portalcondo.domain.AcessoProp;
import com.grupotema.portalcondo.services.AcessoPropService;

@RestController
@RequestMapping(value="/acessosprop")
public class AcessoPropResource {

	@Autowired
	private AcessoPropService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		AcessoProp obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
