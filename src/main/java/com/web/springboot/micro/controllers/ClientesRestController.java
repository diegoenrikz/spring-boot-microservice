package com.web.springboot.micro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.springboot.micro.model.dto.ClienteDto;
import com.web.springboot.micro.model.entity.Cliente;
import com.web.springboot.micro.model.mapper.ClienteMapper;
import com.web.springboot.micro.service.IClienteService;

@RestController
public class ClientesRestController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private ClienteMapper clienteMapper;

	@GetMapping(value = "/clientes")
	public List<ClienteDto> getClientes() {
		List<Cliente> listaClientes = clienteService.findAll();
		return clienteMapper.toDtoListWithCliente(listaClientes);
	}

	@GetMapping(value = "/cliente/{id}")
	public ClienteDto getCliente(@PathVariable(value = "id") Integer id) {

			Cliente cliente = clienteService.findOne(id);
	
			return clienteMapper.toDtoWithCuentas(cliente);

		
	}

	@PostMapping(value = "/cliente")
	public void addCliente(@RequestBody Cliente cliente) {
		clienteService.save(cliente);

	}

	@DeleteMapping(value = "/cliente/{id}")
	public void deleteCliente(@PathVariable(value = "id") Integer id) {
		if (id > 0) {
			clienteService.delete(id);
		}
	}

	@PutMapping(value = "/cliente/{id}")
	public void updateCliente(@PathVariable(value = "id") Integer id, @RequestBody Cliente cliente) {
		Cliente clienteEntity = clienteService.findOne(id);

		clienteEntity.setContrasena(cliente.getContrasena());
		clienteEntity.setCuentas(cliente.getCuentas());
		clienteEntity.setEstado(cliente.isEstado());
		clienteEntity.setPersona(cliente.getPersona());

		clienteService.save(clienteEntity);
	}

}
