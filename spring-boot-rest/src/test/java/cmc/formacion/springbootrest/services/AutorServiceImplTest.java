package cmc.formacion.springbootrest.services;

import java.util.Arrays;

import org.mockito.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.domain.Libro;
import cmc.formacion.springbootrest.exception.NotFoundException;
import cmc.formacion.springbootrest.repository.AutorRepository;
import org.junit.Assert;

@RunWith(SpringRunner.class)
public class AutorServiceImplTest {

	@MockBean
	AutorRepository autorRepository;
	
	AutorService autorService;
	
	@Before
	public void setUp() {
		autorService = new AutorServiceImpl(autorRepository);
	}
	
	@Test
	public void findOneDebeDevolverElAutorPorIdSiExiste() throws NotFoundException {
		
		Mockito.when(autorRepository.findOne(Matchers.anyLong()))
			   .thenReturn(autor1);
		
		Autor autor = autorService.findOne(1L);
		
		Assert.assertNotNull("Autor nulo con findOne", autor);
		Assert.assertEquals("Nombre autor incorrecto", nombreAutor, autor.getNombre());
		
	}
	
	@Test(expected = NotFoundException.class)
	public void finOneDebeDevolverUnaNotFoundExceptionSiNoExisteAutorConId() throws NotFoundException {
		Mockito.when(autorRepository.findOne(Matchers.anyLong())).thenReturn(null);
		
		autorService.findOne(3L);
	}
	
	/**
	 * DATOS DE PRUEBA
	 */
	String nombreAutor = "Autor 1";
	Autor autor1 = new Autor(1L, "Autor 1", "Dir. Autor 1", 
			Arrays.asList(new Libro(1L, "libro 1"), 
						  new Libro(2L, "libro 2")));
	
	
}
