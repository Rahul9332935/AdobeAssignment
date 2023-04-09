package com.rahul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		
		servers = {
				@Server(url="/", description = "Default server URI")
		}
		
		)

@SpringBootApplication
public class AdobeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdobeAssignmentApplication.class, args);
	}

}
