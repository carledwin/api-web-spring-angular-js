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
import com.carledwin.ti.apiwebspringangularjs.ws.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clientesService;
	
	// end points
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		clientesService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
		
		Cliente clienteAlteracao = clientesService.buscarPorId(cliente.getId());
		
		if(null == clienteAlteracao){
			System.out.println("Cliente nao encontrado.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clientesService.alterar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosCliente() {
		Collection<Cliente> todosClientes = clientesService.buscarTodos();
		return new ResponseEntity<>(todosClientes, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> removerCliente(@PathVariable Long id) {
		Cliente cliente = clientesService.buscarPorId(id);
		if(null == cliente){
			System.out.println("Cliente nao encontrado.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clientesService.excluir(cliente.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
		Cliente cliente = clientesService.buscarPorId(id);
		if(null == cliente){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

}