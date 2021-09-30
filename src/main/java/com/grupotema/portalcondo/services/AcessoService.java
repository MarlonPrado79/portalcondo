package com.grupotema.portalcondo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.grupotema.portalcondo.domain.Acesso;
import com.grupotema.portalcondo.domain.Usuario;
import com.grupotema.portalcondo.dto.AcessoDTO;
import com.grupotema.portalcondo.repositories.AcessoRepository;
import com.grupotema.portalcondo.services.Exceptions.DataIntegrityException;
import com.grupotema.portalcondo.services.Exceptions.ObjectNotFoundException;

@Service
public class AcessoService {

	@Autowired
	private AcessoRepository repo;
	
	public Acesso find(Integer id) {
		Optional<Acesso> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Acesso insert(Acesso obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Acesso update(Acesso obj) {
		Acesso newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um acesso que contenha vínculos");
		}
	}
	
	public List<Acesso> findAll() {
		return repo.findAll();
	}

	public Page<Acesso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,  linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Acesso fromDTO(AcessoDTO objDto) {
		return new Acesso(objDto.getId(), objDto.getNivel(), null, null);
	}
	
	private void updateData(Acesso newObj, Acesso obj) {
		newObj.setNivel(obj.getNivel());
	}
}
