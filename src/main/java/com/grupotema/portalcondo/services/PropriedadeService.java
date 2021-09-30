package com.grupotema.portalcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.grupotema.portalcondo.domain.Propriedade;
import com.grupotema.portalcondo.repositories.PropriedadeRepository;
import com.grupotema.portalcondo.services.Exceptions.DataIntegrityException;
import com.grupotema.portalcondo.services.Exceptions.ObjectNotFoundException;

@Service
public class PropriedadeService {

	@Autowired
	private PropriedadeRepository repo;
	
	public Propriedade find(Integer id) {
		Optional<Propriedade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Propriedade.class.getName()));
	}
	
	public Propriedade insert(Propriedade obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Propriedade update(Propriedade obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um condominio que existe unidade");
		}
	}

	public List<Propriedade> findAll() {
		return repo.findAll();
	}
	
}
