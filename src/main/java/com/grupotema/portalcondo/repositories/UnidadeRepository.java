package com.grupotema.portalcondo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupotema.portalcondo.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

}
