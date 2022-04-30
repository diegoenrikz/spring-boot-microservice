
package com.web.springboot.micro.model.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.web.springboot.micro.model.dto.ClienteDto;
import com.web.springboot.micro.model.entity.Cliente;

@Mapper(componentModel = "spring",  uses = { CuentaMapper.class})
public interface ClienteMapper {
	
	
	 @Named("WithtoDto")
	 @Mapping(target = "clienteId", ignore = false)
	 @Mapping(target = "contrasena", ignore = false)
	 @Mapping(target = "estado", ignore = false)
	 @Mapping(target = "persona", ignore = false)
	 @Mapping(target = "cuentas", ignore = true)
	ClienteDto toDto(Cliente target);
	
	@IterableMapping(qualifiedByName = { "WithtoDto" })
	List<ClienteDto> toDtoList(List<Cliente> entityList);
	
	Cliente toEntity(ClienteDto source);

	List<Cliente> toEntityList(List<ClienteDto> dtoList);
	
	@Named("WithCuentas")
	 @Mapping(target = "clienteId", ignore = false)
	 @Mapping(target = "contrasena", ignore = false)
	 @Mapping(target = "estado", ignore = false)
	 @Mapping(target = "persona", ignore = false)
	 @Mapping(target = "cuentas", qualifiedByName = { "WithtoDto" }, ignore = false)
	ClienteDto toDtoWithCuentas(Cliente target);
	
	@IterableMapping(qualifiedByName = { "WithCuentas" })
	List<ClienteDto> toDtoListWithCliente(List<Cliente> entityList);
	
	
}