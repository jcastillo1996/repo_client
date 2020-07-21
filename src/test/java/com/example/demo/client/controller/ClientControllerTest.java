package com.example.demo.client.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.controller.ClienteController;
import com.example.demo.model.Client;
import com.example.demo.service.impl.ClientServiceImpl;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ClienteController.class)
class ClientControllerTest {

	@MockBean
	ClientServiceImpl service;

	@Autowired
	private WebTestClient webClient;

	@Test
	void findById() {
		Long id = 4L;
		Client cli = new Client();
		cli.idClient = id;
		cli.firstName = "JOSeeeE";
		cli.secondName = null;
		cli.lastName1 = "CASTILLO";
		cli.lastName2 = "CHALQUE";
		cli.document = "75624412";
		cli.birthDate = LocalDate.now();
		Mono<Client> cliMono = Mono.just(cli);
		when(service.findById(4L)).thenReturn(cliMono);
		webClient.get().uri("/api_client/4").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
				.expectBody(Client.class).value(cli1 -> cli.idClient, equalTo(4L));
	}

	@Test
	void save() {
		Long id = 9L;
		Client cli = new Client();
		cli.idClient = id;
		cli.firstName = "PEDROE";
		cli.secondName = null;
		cli.lastName1 = "BARRANTES";
		cli.lastName2 = "COTRINA";
		cli.document = "07440945";
		cli.birthDate = LocalDate.now();
		Mono<Client> cliMono = Mono.just(cli);
		when(service.save(cli)).thenReturn(cliMono);
		webClient.post().uri("/api_client").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(cli), Client.class).exchange().expectStatus().isCreated();
	}
	@Test
	void update() {
		Long id = 4L;
		Client cli = new Client();
		cli.idClient = id;
		cli.firstName = "JULIO";
		cli.secondName = null;
		cli.lastName1 = "BARRANTES";
		cli.lastName2 = "COTRINA";
		cli.document = "07440945";
		cli.birthDate = LocalDate.now();
		Mono<Client> cliMono = Mono.just(cli);
		when(service.save(cli)).thenReturn(cliMono);
		webClient.put().uri("/api_client").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(cli), Client.class).exchange().expectStatus().isOk();
	}
	@Test
	void deleteById() {
		Long id = 4L;
		when(service.deleteById(id)).thenReturn(Mono.empty());
		webClient.delete()
		.uri("/api_client/4")
		.exchange()
		.expectStatus().isOk();
	}
}
