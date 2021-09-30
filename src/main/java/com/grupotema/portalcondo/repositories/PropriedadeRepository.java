package com.grupotema.portalcondo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupotema.portalcondo.domain.Propriedade;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade, Integer> {

}
