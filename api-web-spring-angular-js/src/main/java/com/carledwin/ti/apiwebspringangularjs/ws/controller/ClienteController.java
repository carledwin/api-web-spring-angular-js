package com.carledwin.ti.apiwebspringangularjs.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Cliente;
import com.carledwin.ti.apiwebspringangularjs.ws.service.Clientes;

@RestController
public class ClienteController {

	@Autowired
	private Clientes clientes;
	
	// end points
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		clientes.cadastrar(cliente);
		System.out.println("Chamou POST - /clientes");
		System.out.println("Id: " + cliente.getId() + " Cliente: " + cliente.getNome());
		System.out.println("Cliente cadastrado com sucesso!");

		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
		
		Cliente clienteAlteracao = clientes.buscarPorId(cliente.getId());
		
		if(null == clienteAlteracao){
			System.out.println("Cliente nao encontrado.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clientes.alterar(cliente);
		System.out.println("Chamou PUT- /clientes");
		System.out.println("Id: " + cliente.getId() + " Cliente: " + cliente.getNome());
		System.out.println("Cliente alterado com sucesso!");

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosCliente() {
		Collection<Cliente> todosClientes = clientes.buscarTodos();
		System.out.println("Chamou GET - /clientes");
		System.out.println("Busca todos realizada com sucesso!");

		return new ResponseEntity<>(todosClientes, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> removerCliente(@PathVariable Long id) {
		System.out.println("Chamou DELETE - /clientes");
		
		System.out.println("Buscando cliente...");
		
		Cliente cliente = clientes.buscarPorId(id);
		
		if(null == cliente){
			System.out.println("Cliente nao encontrado.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		clientes.excluir(cliente.getId());
		
		System.out.println("Remocao realizada com sucesso!");

		return new ResponseEntity<>(HttpStatus.OK);
	}

}