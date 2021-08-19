package com.grupotema.portalcondo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupotema.portalcondo.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

}
