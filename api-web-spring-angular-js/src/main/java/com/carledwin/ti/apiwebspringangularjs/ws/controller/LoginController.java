package com.carledwin.ti.apiwebspringangularjs.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Usuario;
import com.carledwin.ti.apiwebspringangularjs.ws.service.UsuarioService;

@RestController
public class LoginController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
		Usuario usuarioAutenticado = service.autenticar(usuario);
		
		if(usuarioAutenticado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(usuarioAutenticado, HttpStatus.OK);
	}
}
