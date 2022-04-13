package com.touchtech.programa.anime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AnimeApplication {

//	Metodos em CONTROLLER
	public static void main(String[] args) {
		SpringApplication.run(AnimeApplication.class, args);
	}

	@GetMapping("/test")
	public String index(){return "Olá Mundo!";}

}
