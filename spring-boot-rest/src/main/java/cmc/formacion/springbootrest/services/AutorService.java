package cmc.formacion.springbootrest.services;

import java.util.List;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.exception.NotFoundException;

public interface AutorService {

	List<Autor> findAll();
	
	Autor findOne(Long id) throws NotFoundException;
	
	void save(Autor autor);
	
	void update (Long id, Autor autor) throws NotFoundException;
	
	void delete (Long id);
	
	List<Autor> findByBookTittle(String titulo);
}
