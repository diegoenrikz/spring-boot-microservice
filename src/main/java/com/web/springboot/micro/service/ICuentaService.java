package com.web.springboot.micro.service;

import java.util.List;

import com.web.springboot.micro.model.entity.Cuenta;

public interface ICuentaService {
	
	public List<Cuenta> findAll();
	
	public void save(Cuenta cliente);
	
	public Cuenta findOne(Integer id);
	
	public void delete(Integer id);
	

}
