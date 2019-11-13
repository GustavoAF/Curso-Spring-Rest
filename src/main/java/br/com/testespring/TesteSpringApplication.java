package br.com.testespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Deu certo cara :-)
@SpringBootApplication(scanBasePackages="br.com.testespring")
public class TesteSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteSpringApplication.class, args);
	}
	
}
