package com.grupotema.portalcondo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotema.portalcondo.domain.AcessoProp;
import com.grupotema.portalcondo.repositories.AcessoPropRepository;
import com.grupotema.portalcondo.services.Exceptions.ObjectNotFoundException;

@Service
public class AcessoPropService {
	
	@Autowired
	private AcessoPropRepository repo;
	
	public AcessoProp find(Integer id) {
		Optional<AcessoProp> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + AcessoProp.class.getName()));
	}
		

}
