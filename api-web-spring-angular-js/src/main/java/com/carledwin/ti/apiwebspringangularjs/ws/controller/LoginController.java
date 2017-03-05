package com.carledwin.ti.apiwebspringangularjs.ws.controller;

import java.util.Date;

import javax.servlet.ServletException;

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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> autenticar(@RequestBody Usuario usuario) throws ServletException{
		Usuario usuarioAutenticado = service.autenticar(usuario);
		
		if(usuario.getNome() == null || usuario.getSenha() == null){
			throw new ServletException("Nome e senha são obrigatórios.");
		}
		
		if(usuarioAutenticado == null){
			throw new ServletException("Usuário ou senha inválidos.");
		}
		
		String token= gerarToken(usuario);
		
		LoginResponse loginToken = new LoginResponse(token); 
		
		return new ResponseEntity<>(loginToken, HttpStatus.OK);
		
		//return new LoginResponse(token);
	}

	private String gerarToken(Usuario usuario) {
		return Jwts.builder()
				.setSubject(usuario.getNome())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.claim("ROLE_ADMIN", "Cliente")
				.setExpiration(new Date(System.currentTimeMillis() + 5*60*1000))
				.compact();
	}
	
	private class LoginResponse{
		private String token;

		public LoginResponse(String token) {
			this.token =token;
		}
		
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
	}
}
