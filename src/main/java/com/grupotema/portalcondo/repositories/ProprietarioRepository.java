package com.grupotema.portalcondo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupotema.portalcondo.domain.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {

}
