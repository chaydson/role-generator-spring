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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AppUserService userService, CategoryService categoryService, OptionService optionService){
		return args -> {
			// cadastro de categorias
			categoryService.saveCategory(new Category(null, "categoriaTest1"));
			categoryService.saveCategory(new Category(null, "categoriaTest2"));
			categoryService.saveCategory(new Category(null, "categoriaTest3"));
			categoryService.saveCategory(new Category(null, "categoriaTest4"));
			categoryService.saveCategory(new Category(null, "filmes"));
			categoryService.saveCategory(new Category(null, "roupas"));
			Category lugar = categoryService.saveCategory(new Category(null, "lugar"));
			Category desafio = categoryService.saveCategory(new Category(null, "desafio"));

			// cadastro de opções
			optionService.saveOption(new CategoryOption(null, "optionTeste1",lugar));
			optionService.saveOption(new CategoryOption(null, "optionTeste2", desafio));

			// cadastro de usuário e adicionando categoria ao usuário
			userService.saveUser(new AppUser(null, "teste1", "teste1", "teste1", "teste1"));
			userService.addCategoryToUser("teste1", "categoriaTest1");
			userService.addCategoryToUser("teste1", "categoriaTest2");
			userService.saveUser(new AppUser(null, "teste2", "teste2", "teste2", "teste2"));

			// adiciona opção na categoria
			categoryService.addOptionToCategory("optionTeste1", "categoriaTest1");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
