package com.carledwin.ti.apiwebspringangularjs.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Estado;
import com.carledwin.ti.apiwebspringangularjs.ws.service.EstadoService;

@RestController
public class EstadoController {

	@Autowired
	private EstadoService service;
	
	@RequestMapping(method = RequestMethod.POST, value="/estados", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> cadastrar(@RequestBody Estado estado){
		service.cadastrar(estado);
		return new ResponseEntity<Estado>(estado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/estados", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> alterar(@RequestBody Estado estado){
		Estado estadoAlterado = service.buscarPorId(estado.getId());
		
		if(null == estadoAlterado){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		service.alterar(estadoAlterado);
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/estados/{id}")
	public ResponseEntity<Estado> remover(@PathVariable Long id){
		Estado estado = service.buscarPorId(id);
		
		if(null == estado){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		service.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/estados/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> buscarPorId(@PathVariable Long id){
		Estado estado = service.buscarPorId(id);
		
		if(null == estado){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(estado, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,  value="/estados", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Estado>> buscarTodos(){
		Collection<Estado> todos = service.buscarTodos();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}
}
