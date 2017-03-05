package com.carledwin.ti.apiwebspringangularjs.ws.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value="SELECT u FROM Usuario u WHERE u.nome=:pnome AND u.senha=:psenha")
	Usuario buscarPorNome(@Param("pnome")String nome, @Param("psenha") String senha);

}
