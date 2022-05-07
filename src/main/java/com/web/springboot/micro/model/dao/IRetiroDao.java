package com.web.springboot.micro.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.springboot.micro.model.entity.RetiroDiario;

public interface IRetiroDao extends CrudRepository<RetiroDiario, Integer> {
	

	@Query("SELECT r  FROM RetiroDiario r WHERE r.numCuenta = :numCuenta")
	RetiroDiario findbyCuenta(Long numCuenta);
	

}
