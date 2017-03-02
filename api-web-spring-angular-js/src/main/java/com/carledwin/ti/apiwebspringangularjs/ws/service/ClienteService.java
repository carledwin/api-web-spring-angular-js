package com.carledwin.ti.apiwebspringangularjs.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private Clientes clientes;
	public Cliente cadastrar(Cliente cliente) {
		clientes.save(cliente);
		return cliente;
	}
	
	public void alterar(Cliente cliente){
		clientes.save(cliente);
	}

	public Collection<Cliente> buscarTodos() {
		return clientes.findAll();
	}
	
	public void excluir(Long id){
		clientes.delete(id);
	}
	
	public Cliente buscarPorId(Long id){
		return clientes.findOne(id);
	}
}
