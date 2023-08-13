package com.hustle.hustle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.hustle.hustle.model")
@ComponentScan({"com.hustle.hustle.controllers", "com.hustle.hustle.repositories", "com.hustle.hustle.security", "com.hustle.hustle.services", "com.hustle.hustle.config"})
@EnableJpaRepositories("com.hustle.hustle.repositories")
public class HustleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HustleApplication.class, args);
	}

}
