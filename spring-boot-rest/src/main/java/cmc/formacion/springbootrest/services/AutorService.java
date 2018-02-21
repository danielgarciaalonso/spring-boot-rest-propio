package cmc.formacion.springbootrest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.domain.Libro;

public interface AutorService {

	List<Autor> findAll();
	
	Autor findOne(Long id);
	
	void save(Autor autor);
	
	void update (Long id, Autor autor);
	
	void delete (Long id);
	
	List<Autor> findByBookTittle(String titulo);
}