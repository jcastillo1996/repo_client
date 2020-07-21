package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "clients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
	private static final long serialVersionUID = -7002717789008112626L;
	@Transient
    public static final String SEQUENCE_NAME = "client_sequence";
	@Id
	public Long idClient;

	@NotNull(message = "NOT NULL")
	@NotEmpty(message = "NOT EMPTY")
	public String document;

	public String firstName;

	public String secondName;

	public String lastName1;

	public String lastName2;

	public LocalDate birthDate=LocalDate.now();

	
}
