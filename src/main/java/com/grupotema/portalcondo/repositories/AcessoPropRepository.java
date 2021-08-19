package com.grupotema.portalcondo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupotema.portalcondo.domain.AcessoProp;

@Repository
public interface AcessoPropRepository extends JpaRepository<AcessoProp, Integer> {

}
