package com.web.springboot.micro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.springboot.micro.model.dao.ICuentaDao;
import com.web.springboot.micro.model.entity.Cuenta;
import com.web.springboot.micro.service.ICuentaService;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaDao cuentaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		return (List<Cuenta>) cuentaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		cuentaDao.save(cuenta);

	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findOne(Integer id) {
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		cuentaDao.deleteById(id);

	}

}
