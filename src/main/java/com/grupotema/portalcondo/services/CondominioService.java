package com.grupotema.portalcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.grupotema.portalcondo.domain.Condominio;
import com.grupotema.portalcondo.dto.CondominioDTO;
import com.grupotema.portalcondo.repositories.CondominioRepository;
import com.grupotema.portalcondo.services.Exceptions.DataIntegrityException;
import com.grupotema.portalcondo.services.Exceptions.ObjectNotFoundException;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository repo;
	
	public Condominio find(Integer id) {
		Optional<Condominio> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Condominio.class.getName()));
	}
	
	public Page<Condominio> searchCondominioUsuario(Integer id, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,  linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.searchCondominioUsuario(id, pageRequest);
		
	}
	
	
	
	public Condominio insert(Condominio obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Condominio update(Condominio obj) {
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
	
	public List<Condominio> findAll() {
		return repo.findAll();
	}
	
	public Page<Condominio> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,  linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Condominio fromDTO(CondominioDTO objDto) {
		return new Condominio(objDto.getId(), objDto.getNome());
	}
}
