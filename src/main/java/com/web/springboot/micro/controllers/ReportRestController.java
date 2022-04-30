package com.web.springboot.micro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.springboot.micro.model.dto.ReporteDto;
import com.web.springboot.micro.model.entity.Movimientos;
import com.web.springboot.micro.model.mapper.MovimientosMapper;
import com.web.springboot.micro.service.IMovimientosService;

@RestController
public class ReportRestController {

	@Autowired
	private IMovimientosService movimientosService;

	@Autowired
	private MovimientosMapper movimientosMapper;

	@GetMapping(value = "/report")
	public List<ReporteDto> reportes(@RequestParam(value = "desde") String desde,
			@RequestParam(value = "hasta") String hasta, @RequestParam(value = "cliente") Integer cliente) {
		List<ReporteDto> listReports = new ArrayList<>();

		List<Movimientos> listMovimientos = movimientosService.findMovimientos(desde, hasta, cliente);
		for (Movimientos movimientos : listMovimientos) {
			ReporteDto report = new ReporteDto();
			report.setCliente(movimientos.getCuenta().getCliente().getPersona().getNombre());
			report.setEstado(movimientos.getCuenta().isEstado());
			report.setFecha(movimientos.getFecha());
			report.setMovimiento(movimientos.getValor());
			report.setSaldoInicial(movimientos.getSaldo());
			report.setNumCuenta(movimientos.getCuenta().getNumCuenta());
			report.setSaldoDisponible(movimientos.getSaldo() - movimientos.getValor());
			report.setTipo(movimientos.getTipoMovimiento());

			listReports.add(report);
		}
		return listReports;
	}

}
