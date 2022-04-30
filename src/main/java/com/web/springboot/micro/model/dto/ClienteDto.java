package com.web.springboot.micro.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {


	private Integer clienteId;
	
	private String contrasena;

	private boolean estado;

	private PersonaDto persona;
	
	private List<CuentaDto> cuentas;

}
