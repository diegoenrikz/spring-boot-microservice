package com.web.springboot.micro.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.springboot.micro.model.entity.Movimientos;

public interface IMovimientosDao extends CrudRepository<Movimientos, Integer> {
	
	@Query("SELECT e " + "FROM Movimientos e ")
	List<Movimientos> findMovimientosbyDate(String desde, String hasta, Integer cliente);
	

}
