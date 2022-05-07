package com.web.springboot.micro.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDto {
	
	private String fechaDesde;
	
	private String fechaHasta;
	
	private String cliente;
	
	private long numCuenta;
	
	private String tipoCuenta;
	
	private Double saldoDisponible;
	
	private Double totalDebito;
	
	private Double totalCredito;
	



}
