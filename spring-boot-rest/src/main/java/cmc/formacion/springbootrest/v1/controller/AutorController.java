package cmc.formacion.springbootrest.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cmc.formacion.springbootrest.services.AutorService;
import cmc.formacion.springbootrest.v1.mapper.AutorMapper;

@RestController
public class AutorController {
	
	private AutorService autorService;
	
	private AutorMapper AutorMapper;
	
	@Autowired
	public AutorController (AutorService autorService) {
		this.autorService = autorService;
	}

}
