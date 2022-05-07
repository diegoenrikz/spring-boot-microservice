package com.web.springboot.micro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

	private Integer id;
	
	private String nombre;

	private String genero;
	
	private Integer edad;
	
	private String identificacion;
	
	private String direccion;
	
	private String telefono;

}
