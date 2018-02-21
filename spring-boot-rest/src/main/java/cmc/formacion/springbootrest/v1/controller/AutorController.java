package cmc.formacion.springbootrest.v1.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.services.AutorService;
import cmc.formacion.springbootrest.v1.mapper.AutorMapper;
import cmc.formacion.springbootrest.v1.model.AutorDTO;

@RestController
@RequestMapping(path = AutorController.BASE_URL)
public class AutorController {
	
	public static final String BASE_URL = "api/v1/autor";
	
	private AutorService autorService;
	
	private AutorMapper autorMapper;
	
	@Autowired
	public AutorController (AutorService autorService, AutorMapper autorMapper) {
		this.autorService = autorService;
		this.autorMapper = autorMapper;
	}

	@GetMapping // @RequestMapping(method = RequestMethod.GET)
	public List<AutorDTO> getAllAutores(){
		return autorService.findAll()
				.stream()
				.map(a -> autorMapper.convertAutorToAutorDTO(a))
				.collect(Collectors.toList());
	}
	
	@GetMapping(path = "/{id}")
	public AutorDTO getAutorById(@PathVariable Long id) {
		return autorMapper.convertAutorToAutorDTO(autorService.findOne(id));
		
	}
	
	@GetMapping("/books")
	public List<AutorDTO> getAutoresPorTitulo(@RequestParam String titulo) {
		return autorService.findByBookTittle(titulo)
				.stream()
				.map(a -> autorMapper.convertAutorToAutorDTO(a))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveAutor(@RequestBody AutorDTO dto) {
		autorService.save(autorMapper.convertAutorDTOToAutor(dto));
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteAutor(@PathVariable Long id) {
		autorService.delete(id);
	}
	
	@PutMapping(path = "/{id}")
	public void updateAutor(@PathVariable Long id, @RequestBody AutorDTO dto) {
		autorService.update(id, autorMapper.convertAutorDTOToAutor(dto));
	}
	
}
