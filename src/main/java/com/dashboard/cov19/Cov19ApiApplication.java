package com.dashboard.cov19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class Cov19ApiApplication extends SpringBootServletInitializer {

	@GetMapping("/greet")
	public String greet(){
		return "welcome";
	}

	public static void main(String[] args) {
		SpringApplication.run(Cov19ApiApplication.class, args);
	}
}
