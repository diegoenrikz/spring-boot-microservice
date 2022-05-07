
package com.web.springboot.micro.model.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.web.springboot.micro.model.dto.CuentaDto;
import com.web.springboot.micro.model.entity.Cuenta;

@Mapper(componentModel = "spring", uses = { MovimientosMapper.class, ClienteMapper.class })
public interface CuentaMapper {
	
	 @Named("WithtoDto")
	 @Mapping(target = "cuentaId", ignore = false)
	 @Mapping(target = "numCuenta", ignore = false)
	 @Mapping(target = "tipoCuenta", ignore = false)
	 @Mapping(target = "saldoInicial", ignore = false)
	 @Mapping(target = "estado", ignore = false)
	 @Mapping(target = "saldoTotal", ignore = false)
	 @Mapping(target = "cliente",  qualifiedByName = { "WithtoDto" }, ignore = false)
	 @Mapping(target = "movimientos", qualifiedByName = { "WithtoDto" }, ignore = false)
	CuentaDto toDto(Cuenta target);
	
	@IterableMapping(qualifiedByName = { "WithtoDto" })
	List<CuentaDto> toDtoList(List<Cuenta> entityList);
	
	Cuenta toEntity(CuentaDto source);

	List<Cuenta> toEntityList(List<CuentaDto> dtoList);
	
	
}