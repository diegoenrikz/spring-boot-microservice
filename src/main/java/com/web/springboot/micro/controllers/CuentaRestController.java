package com.web.springboot.micro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.springboot.micro.model.dao.IRetiroDao;
import com.web.springboot.micro.model.dto.CuentaDto;
import com.web.springboot.micro.model.entity.Cuenta;
import com.web.springboot.micro.model.entity.RetiroDiario;
import com.web.springboot.micro.model.mapper.CuentaMapper;
import com.web.springboot.micro.service.ICuentaService;

@RestController
public class CuentaRestController {

	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private CuentaMapper cuentaMapper;
	
	@Autowired
	private IRetiroDao retiroDao;
	

	@GetMapping(value = "/cuentas")
	public List<CuentaDto> getCuentas() {
		List<Cuenta> listaCuentas = cuentaService.findAll();
		return cuentaMapper.toDtoList(listaCuentas);
	}

	@GetMapping(value = "/cuenta/{id}")
	public CuentaDto getCuenta(@PathVariable(value = "id") Integer id) {

		Cuenta cuenta = cuentaService.findOne(id);
		return cuentaMapper.toDto(cuenta);
	}

	@PostMapping(value = "/cuenta")
	public void addCuenta(@RequestBody Cuenta cuenta) {
		cuenta.setSaldoTotal(cuenta.getSaldoInicial());
		RetiroDiario retiroDiario = new RetiroDiario();
		retiroDiario.setNumCuenta(cuenta.getNumCuenta());
		retiroDao.save(retiroDiario);
		cuentaService.save(cuenta);
		
	}

	@DeleteMapping(value = "/cuenta/{id}")
	public void deleteCuenta(@PathVariable(value = "id") Integer id) {
		if (id > 0) {
			cuentaService.delete(id);
		}
	}
	
	@PutMapping(value = "/cuenta/{id}")
	public void updateCuentas(@PathVariable(value = "id") Integer id, @RequestBody Cuenta cuenta) {
		Cuenta cuentaEntity = cuentaService.findOne(id);
		
		cuentaEntity.setCliente(cuenta.getCliente());
		cuentaEntity.setEstado(cuenta.isEstado());
		cuentaEntity.setMovimientos(cuenta.getMovimientos());
		cuentaEntity.setNumCuenta(cuenta.getNumCuenta());;
		cuentaEntity.setSaldoInicial(cuenta.getSaldoInicial());
		cuentaEntity.setTipoCuenta(cuenta.getTipoCuenta());
		
		cuentaService.save(cuentaEntity);
	}
	

}
