package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "type_client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeClient {

	@Id
	public Long typeId;
	
	public String typeName;
	
}
