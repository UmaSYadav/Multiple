package com.uma.spring.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "1.0", description = "Employees Information"))
public class SpringJpaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPracticeApplication.class, args);
	}

}
