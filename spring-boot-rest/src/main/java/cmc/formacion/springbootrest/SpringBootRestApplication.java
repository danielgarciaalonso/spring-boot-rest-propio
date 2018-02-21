package cmc.formacion.springbootrest;

import org.springframework.boot.SpringApplication;

// Creacion automatica de un proyecto spring
// http://start.spring.io/

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
		
		// Para visualizar el contenido de la base de datos acceder a 
		// localhost/8080/h2-console/  
		// puerto 8080 por defecto
	}
}
