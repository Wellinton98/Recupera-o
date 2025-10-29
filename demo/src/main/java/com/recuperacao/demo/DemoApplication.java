package com.recuperacao.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Aplicação iniciada com sucesso!");
		System.err.println("Acesso: http://localhost:8080");
	}

}
