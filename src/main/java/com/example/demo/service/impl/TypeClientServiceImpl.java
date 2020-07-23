package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TypeClient;
import com.example.demo.repo.TypeClientRepo;
import com.example.demo.service.TypeClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypeClientServiceImpl implements TypeClientService {

	@Autowired
	TypeClientRepo repo;
	
	@Override
	public Mono<TypeClient> save(TypeClient obj) {
		
		return repo.insert(obj);
	}

	@Override
	public Mono<TypeClient> update(TypeClient obj) {
		
		return repo.save(obj);
	}

	@Override
	public Flux<TypeClient> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Mono<TypeClient> findById(Long v) {
		
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
