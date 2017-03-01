package com.carledwin.ti.apiwebspringangularjs.ws.service;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Cliente;

@Component
public interface Clientes {
	Cliente cadastrar(Cliente cliente);	
	void alterar(Cliente cliente);
	Collection<Cliente> buscarTodos();
	void excluir(Long id);
	Cliente buscarPorId(Long id);
}
