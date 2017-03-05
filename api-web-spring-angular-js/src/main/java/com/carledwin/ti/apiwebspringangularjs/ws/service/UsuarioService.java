package com.carledwin.ti.apiwebspringangularjs.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario autenticar(Usuario usuario){
		return repository.buscarPorNome(usuario.getNome(), usuario.getSenha());
	}

	public Usuario cadastrar(Usuario usuario) {
		return repository.save(usuario);
	}
}
