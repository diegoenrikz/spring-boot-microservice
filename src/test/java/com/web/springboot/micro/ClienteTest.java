package com.web.springboot.micro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.web.springboot.micro.model.entity.Cliente;

class ClienteTest extends AbstractBaseTest {

	@Autowired
	private WebTestClient webClient;

	private Cliente clienteGet;
	
	private Cliente clienteCreatedFromGet;
	
	

	@Test
	public void findClienteTest() {
		findAll();
		assertEquals(1, (clienteCreatedFromGet.getClienteId()));
		find();
		assertEquals(1, (clienteGet.getClienteId()));
		
		//delete();

	}

	private Cliente find() {
		return clienteGet = webClient.get().uri(uriBuilder -> uriBuilder.path("/cliente/1").build()).exchange()
				.expectStatus().isOk().expectBody(Cliente.class).returnResult().getResponseBody();
	}
	
	private void findAll() {
		List<Cliente>  listclienteGet = webClient.get().uri(uriBuilder -> uriBuilder.path("/clientes").build()).exchange()
				.expectStatus().isOk().expectBodyList(Cliente.class).returnResult().getResponseBody();
		
		clienteCreatedFromGet = listclienteGet.get(0);
	}
	
	private void delete() {
		 webClient.delete().uri(uriBuilder -> uriBuilder.path("/cliente/1").build()).exchange()
				.expectStatus().isOk().expectBodyList(Cliente.class).returnResult().getResponseBody();
		
	}

}
