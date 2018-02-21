package cmc.formacion.springbootrest.v1.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
