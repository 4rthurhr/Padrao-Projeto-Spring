package com._rthur.Padroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("Model")
@EntityScan("Model")
@SpringBootApplication(scanBasePackages = {"Controller", "Service", "Model"})
@EnableFeignClients(basePackages = "Service")
public class PadrosProjetosSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadrosProjetosSpringApplication.class, args);
	}

}
