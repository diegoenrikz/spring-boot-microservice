package com.web.springboot.micro.service;

import java.util.List;

import com.web.springboot.micro.model.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Integer id);
	
	public void delete(Integer id);
	

}
