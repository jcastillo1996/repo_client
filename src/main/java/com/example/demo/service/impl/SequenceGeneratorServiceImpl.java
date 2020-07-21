package com.example.demo.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

//import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;

import com.example.demo.model.DataBaseSequence;

import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.core.query.Update;

@Service
public class SequenceGeneratorServiceImpl {

	// @Autowired(required = true)
	// private MongoOperations mongoOperation;

	@Autowired
	private ReactiveMongoOperations mongoReactive;

	public Mono<DataBaseSequence> generateSequenceReact(String name) {
		return mongoReactive.findAndModify(query(where("_id").is(name)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), DataBaseSequence.class);
	}

	/*
	 * public Long generateSequence(String seqName) {
	 * 
	 * DataBaseSequence counter =
	 * mongoOperation.findAndModify(query(where("_id").is(seqName)), new
	 * Update().inc("seq", 1), options().returnNew(true).upsert(true),
	 * DataBaseSequence.class); return !Objects.isNull(counter) ? counter.getSeq() :
	 * 1; }
	 */
}
