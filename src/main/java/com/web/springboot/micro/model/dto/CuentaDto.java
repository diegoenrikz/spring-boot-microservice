package com.web.springboot.micro.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDto {
	
	private Integer cuentaId;
	
	private long numCuenta;
	
	private String tipoCuenta;
	
	private double saldoInicial;
	
	private boolean estado;
	
	private ClienteDto cliente;
	
	private List<MovimientosDto> movimientos;
	


}
