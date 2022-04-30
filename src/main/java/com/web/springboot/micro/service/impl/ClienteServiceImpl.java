package com.web.springboot.micro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.springboot.micro.model.dao.IClienteDao;
import com.web.springboot.micro.model.entity.Cliente;
import com.web.springboot.micro.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		clienteDao.deleteById(id);

	}

}
