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
import com.web.springboot.micro.model.dto.MovimientosDto;
import com.web.springboot.micro.model.entity.Cuenta;
import com.web.springboot.micro.model.entity.Movimientos;
import com.web.springboot.micro.model.entity.RetiroDiario;
import com.web.springboot.micro.model.mapper.MovimientosMapper;
import com.web.springboot.micro.service.ICuentaService;
import com.web.springboot.micro.service.IMovimientosService;
import com.web.springboot.micro.util.Constants;

@RestController
public class MovimientosRestController {

	@Autowired
	private IMovimientosService movimientosService;

	@Autowired
	private MovimientosMapper movimientosMapper;

	@Autowired
	private IRetiroDao retiroDao;

	@Autowired
	private ICuentaService cuentaService;

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
	public void addMovimiento(@RequestBody Movimientos movimientos) throws Exception {

		Cuenta cuenta = cuentaService.findOne(movimientos.getCuenta().getCuentaId());

		RetiroDiario retiro = retiroDao.findbyCuenta(movimientos.getCuenta().getNumCuenta());

		Double cupoDiario = new Double(0);

		double totalTransaccion;

		if (retiro != null && retiro.getValorDiario() != 0) {
			cupoDiario = retiro.getValorDiario();
		}

		movimientos.setSaldo(cuenta.getSaldoTotal());
		if (Constants.CREDITO.equals(movimientos.getTipoMovimiento().toUpperCase().trim())) {
			totalTransaccion = movimientos.getSaldo() + movimientos.getValor();
			movimientos.setSaldo(totalTransaccion);
			cuenta.setSaldoTotal(totalTransaccion);
		} else if (Constants.DEBITO.equals(movimientos.getTipoMovimiento().toUpperCase().trim())) {
			cupoDiario = cupoDiario + movimientos.getValor();
			if (cuenta.getSaldoTotal() == 0) {
				throw new Exception("Saldo no disponible");
			}
			if (cupoDiario <= 1000) {
				totalTransaccion = movimientos.getSaldo() - movimientos.getValor();
				movimientos.setSaldo(totalTransaccion);
				cuenta.setSaldoTotal(totalTransaccion);
				retiro.setValorDiario(retiro.getValorDiario() + movimientos.getValor());
				retiroDao.save(retiro);
			} else {
				throw new Exception("Cupo diario Excedido");
			}

		}

		movimientos.setCuenta(cuenta);

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
