package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("Service")
@EntityScan("Model")
@SpringBootApplication(scanBasePackages = {"Controller", "Service", "Model"})
public class AcdemiaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcdemiaApiApplication.class, args);
	}

}
