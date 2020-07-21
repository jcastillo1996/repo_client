package com.example.demo.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.model.Client;

public interface ClientRepo extends ReactiveMongoRepository<Client, Long> {

	
	
}
