package com.web.springboot.micro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.web.springboot.micro.model.entity.Movimientos;


class MovimientosTest extends AbstractBaseTest {


	@Autowired
	private WebTestClient webClient;

	private Movimientos movimientoGet;
	
	private Movimientos movimientoCreatedFromGet;

	@Test
	public void findClienteTest() {
		findAll();
		assertEquals(1, (movimientoCreatedFromGet.getMovId()));
		find();
		assertEquals(1, (movimientoGet.getMovId()));

	}

	private Movimientos find() {
		return movimientoGet = webClient.get().uri(uriBuilder -> uriBuilder.path("/movimiento/1").build()).exchange()
				.expectStatus().isOk().expectBody(Movimientos.class).returnResult().getResponseBody();
	}
	
	private void findAll() {
		List<Movimientos> listcuentasGet = webClient.get().uri(uriBuilder -> uriBuilder.path("/movimientos").build()).exchange()
				.expectStatus().isOk().expectBodyList(Movimientos.class).returnResult().getResponseBody();

		movimientoCreatedFromGet = listcuentasGet.get(0);
	}

	private void delete() {
		webClient.delete().uri(uriBuilder -> uriBuilder.path("/movimiento/1").build()).exchange().expectStatus().isOk()
				.expectBodyList(Movimientos.class).returnResult().getResponseBody();

	}

}
