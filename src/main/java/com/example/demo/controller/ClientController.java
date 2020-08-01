package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Client;
import com.example.demo.service.impl.ClientServiceImpl;
//import com.example.demo.service.impl.SequenceGeneratorServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api_client")
public class ClientController {

	@Autowired
	ClientServiceImpl service;

	// @Autowired
	// SequenceGeneratorServiceImpl sequence;

	@GetMapping
	public Flux<Client> findAll() {

		return service.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Client> findById(@PathVariable(name = "id") Long id) {
		return service.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"CLIENT NOT FOUND ID: "+id)));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Client> save(@RequestBody Client cliente) {

		return service.save(cliente);
	}

	@PutMapping
	public Mono<Client> update(@RequestBody(required = true) Client cliente) {

		return service.update(cliente);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable Long id) {

		return service.deleteById(id);
	}

	@DeleteMapping("/deleteAll")
	public Mono<Void> deleteAll() {

		return service.deleteAll();
	}
}
