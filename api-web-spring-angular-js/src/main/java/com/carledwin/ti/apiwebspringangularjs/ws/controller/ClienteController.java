package com.carledwin.ti.apiwebspringangularjs.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Cliente;

@RestController
public class ClienteController {

	Map<Long, Cliente> clientes = new HashMap<>();
	Long nextId = 0L;

	// end points
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		cadastrar(cliente);
		System.out.println("Chamou POST - /clientes");
		System.out.println("Id: " + cliente.getId() + " Cliente: " + cliente.getNome());
		System.out.println("Cliente cadastrado com sucesso!");

		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosCliente() {
		Collection<Cliente> todosClientes = buscarTodos();
		System.out.println("Chamou GET - /clientes");
		System.out.println("Busca todos realizada com sucesso!");

		return new ResponseEntity<>(todosClientes, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> removerCliente(@PathVariable Long id) {
		System.out.println("Chamou DELETE - /clientes");
		
		System.out.println("Buscando cliente...");
		
		Cliente cliente = buscarPorId(id);
		
		if(null == cliente){
			System.out.println("Cliente nao encontrado.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		excluir(cliente.getId());
		
		System.out.println("Remocao realizada com sucesso!");

		return new ResponseEntity<>(HttpStatus.OK);
	}


	// negocios
	private Cliente cadastrar(Cliente cliente) {

		nextId++;
		cliente.setId(nextId);
		clientes.put(nextId, cliente);

		return cliente;
	}

	private Collection<Cliente> buscarTodos() {
		return clientes.values();
	}
	
	private void excluir(Long id){
		clientes.remove(id);
	}
	
	private Cliente buscarPorId(Long id){
		return clientes.get(id);
	}

}