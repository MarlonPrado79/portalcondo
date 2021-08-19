package com.grupotema.portalcondo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupotema.portalcondo.domain.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Integer> {

}
