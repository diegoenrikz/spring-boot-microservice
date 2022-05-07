package com.web.springboot.micro.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cuenta_id")
	private Integer cuentaId;
	
	@NotEmpty
	@Column(name="num_cuenta")
	private long numCuenta;
	
	@NotEmpty
	@Column(name="tipo_cuenta")
	private String tipoCuenta;
	
	@NotEmpty
	@Column(name="saldo_inicial")
	private double saldoInicial;
	
	@NotEmpty
	@Column(name="estado")
	private boolean estado;
	
	@NotEmpty
	@Column(name="saldo_total")
	private double saldoTotal;
	
	@ManyToOne
	@JoinColumn(name = "cliente", referencedColumnName = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "cuenta", cascade = { CascadeType.ALL })
	private List<Movimientos> movimientos;
	


}
