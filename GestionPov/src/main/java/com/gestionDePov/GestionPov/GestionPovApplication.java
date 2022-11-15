package com.gestionDePov.GestionPov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class GestionPovApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPovApplication.class, args);
		System.out.println("connnected");
	}

}
