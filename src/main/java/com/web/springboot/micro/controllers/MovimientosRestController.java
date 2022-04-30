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

import com.web.springboot.micro.model.dto.MovimientosDto;
import com.web.springboot.micro.model.entity.Movimientos;
import com.web.springboot.micro.model.mapper.MovimientosMapper;
import com.web.springboot.micro.service.IMovimientosService;

@RestController
public class MovimientosRestController {

	@Autowired
	private IMovimientosService movimientosService;
	
	@Autowired
	private MovimientosMapper movimientosMapper;
	

	@GetMapping(value = "/movimientos")
	public List<MovimientosDto> getMovimientos() {
		List<Movimientos> listaMovimientos = movimientosService.findAll();
		return movimientosMapper.toDtoList(listaMovimientos);
	}

	@GetMapping(value = "/movimiento/{id}")
	public MovimientosDto getMovimiento(@PathVariable(value = "id") Integer id) {

		Movimientos movimientos = movimientosService.findOne(id);
		return movimientosMapper.toDto(movimientos);
	}

	@PostMapping(value = "/movimiento")
	public void addMovimiento(@RequestBody Movimientos movimientos) {
		movimientosService.save(movimientos);
		
	}

	@DeleteMapping(value = "/movimiento/{id}")
	public void deleteMovimientos(@PathVariable(value = "id") Integer id) {
		if (id > 0) {
			movimientosService.delete(id);
		}
	}
	
	@PutMapping(value = "/movimiento/{id}")
	public void updateCuentas(@PathVariable(value = "id") Integer id, @RequestBody Movimientos movimientos) {
		Movimientos movimientosEntity = movimientosService.findOne(id);
		
		movimientosEntity.setCuenta(movimientos.getCuenta());
		movimientosEntity.setFecha(movimientos.getFecha());
		movimientosEntity.setSaldo(movimientos.getSaldo());
		movimientosEntity.setTipoMovimiento(movimientos.getTipoMovimiento());
		movimientosEntity.setValor(movimientos.getValor());
		
		movimientosService.save(movimientosEntity);
	}
	

}
