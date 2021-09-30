package com.grupotema.portalcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.grupotema.portalcondo.domain.Proprietario;
import com.grupotema.portalcondo.repositories.ProprietarioRepository;
import com.grupotema.portalcondo.services.Exceptions.DataIntegrityException;
import com.grupotema.portalcondo.services.Exceptions.ObjectNotFoundException;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository repo;
	
	public Proprietario find(Integer id) {
		Optional<Proprietario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Proprietario.class.getName()));
	}
	
	public Proprietario insert(Proprietario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Proprietario update(Proprietario obj) {
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

	public List<Proprietario> findAll() {
		return repo.findAll();
	}
	
}
