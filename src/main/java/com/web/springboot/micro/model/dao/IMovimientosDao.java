package com.web.springboot.micro.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.springboot.micro.model.entity.Movimientos;

public interface IMovimientosDao extends CrudRepository<Movimientos, Integer> {
	
	@Query("SELECT m " + "FROM Movimientos m ")
	List<Movimientos> findMovimientosbyDate(String desde, String hasta, Integer cliente);
	
	@Query("SELECT SUM(m.valor) FROM Movimientos m WHERE m.tipoMovimiento = 'Débito'"
			+ "AND m.fecha between :desde and :hasta AND m.cuenta.cuentaId = :cuentaId")
	Double findTotalDebit(Date desde, Date hasta, Integer cuentaId );

	@Query("SELECT SUM(m.valor) FROM Movimientos m WHERE m.tipoMovimiento = 'Crédito'"
			+ "AND m.fecha between :desde and :hasta AND m.cuenta.cuentaId = :cuentaId ")
	Double findTotalCredit(Date desde, Date hasta, Integer cuentaId );
	

}
