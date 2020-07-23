package com.example.demo.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.model.TypeClient;

public interface TypeClientRepo extends ReactiveMongoRepository<TypeClient, Long> {

}
