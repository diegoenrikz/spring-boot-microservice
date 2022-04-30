package com.web.springboot.micro.service;

import java.util.List;

import com.web.springboot.micro.model.entity.Movimientos;

public interface IMovimientosService {
	
	public List<Movimientos> findAll();
	
	public void save(Movimientos movimientos);
	
	public Movimientos findOne(Integer id);
	
	public void delete(Integer id);
	
	public List<Movimientos> findMovimientos(String desde, String hasta, Integer cliente);
	

}
