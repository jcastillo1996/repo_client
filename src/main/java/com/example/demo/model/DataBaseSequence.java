package com.example.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "databases_sequences")
public class DataBaseSequence implements Serializable {

	private static final long serialVersionUID = 590023498370954083L;
	
	@Id
	private String id;
	
	private Long seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "DataBaseSequence [id=" + id + ", seq=" + seq + "]";
	}
}
