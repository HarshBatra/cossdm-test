package com.cdac.TicketRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.cdac.controllers", "com.cdac.services"})
@EntityScan(basePackages = {"com.cdac.entity"})
@EnableJpaRepositories(basePackages = {"com.cdac.repositories"})
public class TicketRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketRestApiApplication.class, args);
	}

}
