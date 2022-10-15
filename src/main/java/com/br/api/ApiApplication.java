package com.br.api;

import com.br.api.model.AppUser;
import com.br.api.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AppUserService userService){
		return args -> {
			userService.saveUser(new AppUser(null, "teste1", "teste1", "teste1", "teste1"));
			userService.saveUser(new AppUser(null, "teste2", "teste2", "teste2", "teste2"));
			userService.saveUser(new AppUser(null, "teste3", "teste3", "teste3", "teste3"));

		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
