package cmc.formacion.springbootrest.v1.mapper;

import org.springframework.stereotype.Component;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.v1.model.AutorDTO;

@Component
public class AutorMapper {
	
	public AutorDTO convertAutorToAutorDTO(Autor autor) {
		return new AutorDTO(autor.getId(), autor.getNombre());
		
	}
	
	public Autor convertAutorDTOToAutor(AutorDTO autorDTO) {
		return new Autor(autorDTO.getId(), autorDTO.getNombre());
	}

}
