package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration;

@SpringBootApplication
//(exclude = ErrorWebFluxAutoConfiguration.class)
public class ClientMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientMicroApplication.class, args);
	}

}
