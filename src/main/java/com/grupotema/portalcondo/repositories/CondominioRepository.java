package com.grupotema.portalcondo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupotema.portalcondo.domain.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Integer> { 

	@Query(value = "SELECT C.ID, C.NOME, A.USUARIO_ID FROM CONDOMINIO C INNER JOIN UNIDADE U ON C.ID = U.CONDOMINIO_ID INNER JOIN PROPRIEDADE P ON U.PROPRIEDADE_ID = P.ID INNER JOIN ACESSO A ON P.ID = A.PROPRIEDADE_ID WHERE A.USUARIO_ID = :id GROUP BY C.ID, C.NOME, A.USUARIO_ID",
			nativeQuery = true)
	@Transactional(readOnly=true)
	Page<Condominio> searchCondominioUsuario(@Param("id") Integer id, Pageable pageRequest);
}
