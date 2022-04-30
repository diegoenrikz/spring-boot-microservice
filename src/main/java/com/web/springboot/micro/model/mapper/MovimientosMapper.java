
package com.web.springboot.micro.model.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.web.springboot.micro.model.dto.MovimientosDto;
import com.web.springboot.micro.model.entity.Movimientos;

@Mapper(componentModel = "spring", uses = { CuentaMapper.class })
public interface MovimientosMapper {

	@Named("WithtoDto")
	@Mapping(target = "movId", ignore = false)
	@Mapping(target = "fecha", ignore = false)
	@Mapping(target = "tipoMovimiento", ignore = false)
	@Mapping(target = "valor", ignore = false)
	@Mapping(target = "saldo", ignore = false)
	@Mapping(target = "cuenta", qualifiedByName = { "WithtoDto" }, ignore = true)
	MovimientosDto toDto(Movimientos target);

	@IterableMapping(qualifiedByName = { "WithtoDto" })
	List<MovimientosDto> toDtoList(List<Movimientos> entityList);

	Movimientos toEntity(MovimientosDto source);

	List<Movimientos> toEntityList(List<MovimientosDto> dtoList);

}