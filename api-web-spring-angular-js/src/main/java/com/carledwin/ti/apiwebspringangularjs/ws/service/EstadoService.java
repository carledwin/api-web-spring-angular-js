package com.carledwin.ti.apiwebspringangularjs.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Estado;

@Service
public class EstadoService {

	@Autowired
	private Estados estados;
	
	public Estado cadastrar(Estado estado){
		estados.save(estado);
		return estado;
	}
	
	public void alterar(Estado estado){
		estados.save(estado);
	}
	
	public void excluir(Long id){
		estados.delete(id);
	}
	
	public Estado buscarPorId(Long id){
		return estados.findOne(id);
	}
	
	public Collection<Estado> buscarTodos(){
		return estados.findAll();
	}
}
