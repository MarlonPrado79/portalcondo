package com.grupotema.portalcondo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupotema.portalcondo.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
	
	@Query(value="SELECT C.ID, C.NOME FROM CONDOMINIO INNER JOIN UNIDADE U ON C.ID=U.CONDOMINIO_ID INNER JOIN USUARIO_PROPRIEDADE P ON U.PROPRIEDADE_ID=P.PROPRIEDADE_ID WHERE P.USUARIO_ID = 2 GROUP BY C.ID, C.NOME",
	       nativeQuery=true)
	@Transactional(readOnly=true)
	List<Usuario> findAcessosUsuario();
		
}
	