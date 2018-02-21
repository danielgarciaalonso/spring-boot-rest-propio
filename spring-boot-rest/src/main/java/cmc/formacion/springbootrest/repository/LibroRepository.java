package cmc.formacion.springbootrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.domain.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

	List<Autor> findByTitulo(String titulo);
	
}
