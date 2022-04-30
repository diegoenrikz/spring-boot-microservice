package com.web.springboot.micro.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDto {
	
	private Date fecha;
	
	private String cliente;
	
	private long numCuenta;

	private String tipo;
	
	private Double saldoInicial;
	
	private boolean estado;
	
	private Double movimiento;
	
	private Double saldoDisponible;


}
