package com.web.springboot.micro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetiroDiarioDto {

	private long numCuenta;

	private double valorDiario;

}
