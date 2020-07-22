package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration;
@EnableEurekaClient
@SpringBootApplication
//(exclude = ErrorWebFluxAutoConfiguration.class)
public class ClientMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientMicroApplication.class, args);
	}

}
