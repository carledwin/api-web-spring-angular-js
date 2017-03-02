package com.carledwin.ti.apiwebspringangularjs.ws.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {
}
