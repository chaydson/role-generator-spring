package com.br.api;

import com.br.api.model.AppUser;
import com.br.api.model.Category;
import com.br.api.model.CategoryOption;
import com.br.api.service.AppUserService;
import com.br.api.service.CategoryService;
import com.br.api.service.OptionService;
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
	CommandLineRunner run(AppUserService userService, CategoryService categoryService, OptionService optionService){
		return args -> {
			userService.saveUser(new AppUser(null, "teste1", "teste1", "teste1", "teste1"));
			userService.saveUser(new AppUser(null, "teste2", "teste2", "teste2", "teste2"));
			userService.saveUser(new AppUser(null, "teste3", "teste3", "teste3", "teste3"));

			categoryService.saveCategory(new Category(null, "categoriaTest1"));
			categoryService.saveCategory(new Category(null, "categoriaTest2"));
			categoryService.saveCategory(new Category(null, "categoriaTest3"));
			categoryService.saveCategory(new Category(null, "categoriaTest4"));

			optionService.saveOption(new CategoryOption(null, "optionTeste1"));
			optionService.saveOption(new CategoryOption(null, "optionTeste2"));
			optionService.saveOption(new CategoryOption(null, "optionTeste3"));
		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
