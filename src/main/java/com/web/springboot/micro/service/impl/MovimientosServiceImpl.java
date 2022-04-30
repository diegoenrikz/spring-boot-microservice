package com.web.springboot.micro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.springboot.micro.model.dao.IMovimientosDao;
import com.web.springboot.micro.model.entity.Movimientos;
import com.web.springboot.micro.service.IMovimientosService;

@Service
public class MovimientosServiceImpl implements IMovimientosService {

	@Autowired
	private IMovimientosDao movimientosDao;

	@Override
	@Transactional(readOnly = true)
	public List<Movimientos> findAll() {
		return (List<Movimientos>) movimientosDao.findAll();
	}

	@Override
	@Transactional
	public void save(Movimientos movimientos) {
		movimientosDao.save(movimientos);

	}

	@Override
	@Transactional(readOnly = true)
	public Movimientos findOne(Integer id) {
		return movimientosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		movimientosDao.deleteById(id);
		
	}

	@Override
	public List<Movimientos> findMovimientos(String desde, String hasta, Integer cliente) {
		List<Movimientos> lisMovimientos = movimientosDao.findMovimientosbyDate(desde,hasta,cliente);
		return lisMovimientos;
	}
	
	


}
