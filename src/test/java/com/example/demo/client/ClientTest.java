package com.example.demo.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.impl.ClientServiceImpl;

@SpringBootTest
class ClientTest {

	@Autowired
	ClientServiceImpl service;
	
	@Test
	void test() {
		/*
		Client cli=new Client(1L, "75624412", "ALEX", "MIGUEL", "FERNANDEZ", "MANRIQUE", LocalDate.now());
		service.registrar(cli);
		*/
	}
	

}
