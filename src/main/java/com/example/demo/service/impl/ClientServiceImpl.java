package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repo.ClientRepo;
import com.example.demo.service.ClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepo repo;

	@Override
	public Mono<Client> save(Client obj) {

		return repo.insert(obj);
	}

	@Override
	public Mono<Client> update(Client obj) {

		return repo.save(obj);
	}

	@Override
	public Flux<Client> findAll() {

		return repo.findAll();
	}

	@Override
	public Mono<Client> findById(Long v) {

		return repo.findById(v);
	}

	@Override
	public Mono<Void> deleteById(Long v) {

		return repo.deleteById(v);

	}

	@Override
	public Mono<Void> deleteAll() {
		
		return repo.deleteAll();
	}

}
