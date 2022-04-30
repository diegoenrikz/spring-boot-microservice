package com.web.springboot.micro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.web.springboot.micro.model.entity.Cuenta;

class CuentaTest extends AbstractBaseTest {

	@Autowired
	private WebTestClient webClient;

	private Cuenta cuentaGet;

	private Cuenta cuentaCreatedFromGet;

	@Test
	public void findClienteTest() {
		findAll();
		assertEquals(1, (cuentaCreatedFromGet.getCuentaId()));
		find();
		assertEquals(1, (cuentaGet.getCuentaId()));

	}

	private Cuenta find() {
		return cuentaGet = webClient.get().uri(uriBuilder -> uriBuilder.path("/cuenta/1").build()).exchange()
				.expectStatus().isOk().expectBody(Cuenta.class).returnResult().getResponseBody();
	}

	private void findAll() {
		List<Cuenta> listcuentasGet = webClient.get().uri(uriBuilder -> uriBuilder.path("/cuentas").build()).exchange()
				.expectStatus().isOk().expectBodyList(Cuenta.class).returnResult().getResponseBody();

		cuentaCreatedFromGet = listcuentasGet.get(0);
	}

	private void delete() {
		webClient.delete().uri(uriBuilder -> uriBuilder.path("/cuenta/1").build()).exchange().expectStatus().isOk()
				.expectBodyList(Cuenta.class).returnResult().getResponseBody();

	}

}