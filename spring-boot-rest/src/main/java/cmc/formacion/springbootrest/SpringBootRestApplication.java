package cmc.formacion.springbootrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

// Creacion automatica de un proyecto spring
// http://start.spring.io/

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cmc.formacion.springbootrest.repository.AutorRepository;
import cmc.formacion.springbootrest.repository.LibroRepository;

@SpringBootApplication
public class SpringBootRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
		
		// Para visualizar el contenido de la base de datos acceder a 
		// localhost/8080/h2-console/  
		// puerto 8080 por defecto
		
		// postman para ver el apirest
		
	}
	
	@Bean
	CommandLineRunner runner (AutorRepository autorRepository, LibroRepository libroRepository) {
		return args -> {
			//System.out.println(autorRepository.findAll().toString());
			
			//System.out.println(autorRepository.findByLibros_Titulo("Mastering AngularJS"));
			
			//System.out.println(autorRepository.findOne((long) 1));
		};
	}
}
