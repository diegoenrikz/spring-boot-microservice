package com.web.springboot.micro.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.springboot.micro.model.dao.ICuentaDao;
import com.web.springboot.micro.model.dao.IMovimientosDao;
import com.web.springboot.micro.model.dto.ReporteDto;
import com.web.springboot.micro.model.entity.Cuenta;
import com.web.springboot.micro.model.entity.Movimientos;
import com.web.springboot.micro.model.mapper.MovimientosMapper;
import com.web.springboot.micro.service.IMovimientosService;

@RestController
public class ReportRestController {

	@Autowired
	private IMovimientosService movimientosService;

	@Autowired
	private MovimientosMapper movimientosMapper;

	@Autowired
	private IMovimientosDao movimientoDao;

	@Autowired
	private ICuentaDao cuentaDao;

	@GetMapping(value = "/report")
	public List<ReporteDto> reportes(@RequestParam(value = "desde") String desde,
			@RequestParam(value = "hasta") String hasta, @RequestParam(value = "cliente") Integer cliente)
			throws ParseException {

		List<ReporteDto> listReport = new ArrayList<>();

		Date dateHasta = new SimpleDateFormat("dd/MM/yyyy").parse(desde);

		Date dateDesde = new SimpleDateFormat("dd/MM/yyyy").parse(hasta);

		List<Cuenta> listCuentas = cuentaDao.findbyClient(cliente);
		for (Cuenta cuenta : listCuentas) {
			ReporteDto report = new ReporteDto();
			Double totalDebito = movimientoDao.findTotalDebit(dateHasta, dateDesde, cuenta.getCuentaId());

			Double totalCredito = movimientoDao.findTotalCredit(dateHasta, dateDesde, cuenta.getCuentaId());

			report.setTotalCredito(totalCredito == null ? 0 : totalCredito);

			report.setTotalDebito(totalDebito == null ? 0 : totalDebito);

			report.setNumCuenta(cuenta.getNumCuenta());

			report.setTipoCuenta(cuenta.getTipoCuenta());

			report.setSaldoDisponible(cuenta.getSaldoTotal());

			report.setCliente(cuenta.getCliente().getPersona().getNombre());

			report.setFechaDesde(desde);

			report.setFechaHasta(hasta);

			listReport.add(report);
		}

		return listReport;
	}

}
