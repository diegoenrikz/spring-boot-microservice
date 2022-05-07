package com.web.springboot.micro.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="retiro")
public class RetiroDiario {

	@Id
	@Column(name = "num_cuenta")
	private long numCuenta;

	@NotEmpty
	@Column(name="valor_diario")
	private double valorDiario;

}
