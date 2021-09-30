package com.grupotema.portalcondo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupotema.portalcondo.domain.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Integer> {
		
}
