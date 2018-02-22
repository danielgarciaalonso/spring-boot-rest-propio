package cmc.formacion.springbootrest.v1.controller;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.domain.Libro;
import cmc.formacion.springbootrest.services.AutorService;
import cmc.formacion.springbootrest.v1.mapper.AutorMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AutorController.class)
public class AutorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	AutorService autorService;
	
	@MockBean
	AutorMapper autorMapper;	
	
	@Autowired
	AutorController autorController;
	
	@Before
	public void setUp() {
		ReflectionTestUtils.setField(autorController, "autorMapper", new AutorMapper());
	}

	@Test
	public void getAllAutoresDebeDevolverListadoDeAutor() throws Exception {
		
		Mockito.when(autorService.findAll()).thenReturn(listaAutores);
		
		mockMvc.perform(MockMvcRequestBuilders.get(AutorController.BASE_URL))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
			.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").exists())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].direccion").doesNotExist())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].libros").doesNotExist());
	}
	
	/**
	 * DATOS DE PRUEBA
	 */
	Autor autor1 = new Autor(1L, "Autor 1", "Dir. Autor 1", Arrays.asList(new Libro()));
	Autor autor2 = new Autor(2L, "Autor 2", "Dir. Autor 2", Arrays.asList(new Libro()));
	List<Autor> listaAutores = Arrays.asList(autor1, autor2);
	
	
	
	
	
	
}
