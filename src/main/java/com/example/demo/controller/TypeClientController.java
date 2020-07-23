package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TypeClient;
import com.example.demo.service.impl.TypeClientServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api_clientType")
public class TypeClientController {
	@Autowired
	TypeClientServiceImpl service;

	// @Autowired
	// SequenceGeneratorServiceImpl sequence;

	@GetMapping
	public Flux<TypeClient> findAll() {

		return service.findAll();
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<TypeClient>> findById(@PathVariable(name = "id") Long id) {
		return service.findById(id).map(type -> new ResponseEntity<>(type, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping(value = "/unauthorized")
	public ResponseEntity<Mono<String>> unathorized() {
		return ResponseEntity.status(HttpStatus.CREATED).header("X-Reason", "user-invalid")
				.body(Mono.just("unauthorized"));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<TypeClient> save(@RequestBody TypeClient type) {

		return service.save(type);
	}

	@PutMapping
	public Mono<TypeClient> update(@RequestBody(required = true) TypeClient type) {

		return service.update(type);
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
