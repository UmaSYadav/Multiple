package com.uma.sprng.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SprController {

	@Value("server.port") private String vPort;
	
	@GetMapping("/test")
	public void testActuator() {
		System.out.println("Port number is : "+vPort);
	}
}
