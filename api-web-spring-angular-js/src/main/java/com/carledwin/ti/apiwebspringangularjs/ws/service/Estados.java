package com.carledwin.ti.apiwebspringangularjs.ws.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carledwin.ti.apiwebspringangularjs.ws.model.Estado;

public interface Estados extends JpaRepository<Estado, Long> {

}
