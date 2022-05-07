package com.web.springboot.micro.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.springboot.micro.model.entity.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Integer> {
	
	@Query("SELECT c FROM Cuenta c WHERE c.cliente.clienteId = :clienteId")
	List<Cuenta> findbyClient(Integer clienteId);
	

}
