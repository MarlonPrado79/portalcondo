package com.grupotema.portalcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.grupotema.portalcondo.domain.Unidade;
import com.grupotema.portalcondo.repositories.UnidadeRepository;
import com.grupotema.portalcondo.services.Exceptions.DataIntegrityException;
import com.grupotema.portalcondo.services.Exceptions.ObjectNotFoundException;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository repo;
	
	public Unidade find(Integer id) {
		Optional<Unidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Unidade.class.getName()));
	}

	public Unidade insert(Unidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Unidade update(Unidade obj) {
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
	
	public List<Unidade> findAll() {
		return repo.findAll();
	}
	
}
