package com.carledwin.ti.apiwebspringangularjs.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Cliente;

@Service
public class ClienteService implements Clientes {
	
	Map<Long, Cliente> clientes = new HashMap<>();
	Long nextId = 0L;
	
	public Cliente cadastrar(Cliente cliente) {
		nextId++;
		cliente.setId(nextId);
		clientes.put(nextId, cliente);
		return cliente;
	}
	
	public void alterar(Cliente cliente){
		clientes.put(cliente.getId(),cliente);
	}

	public Collection<Cliente> buscarTodos() {
		return clientes.values();
	}
	
	public void excluir(Long id){
		clientes.remove(id);
	}
	
	public Cliente buscarPorId(Long id){
		return clientes.get(id);
	}
}
