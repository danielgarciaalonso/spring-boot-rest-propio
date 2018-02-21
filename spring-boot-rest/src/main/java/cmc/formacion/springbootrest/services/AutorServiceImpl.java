package cmc.formacion.springbootrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
	
	private AutorRepository autorRepository;

	@Autowired // Para no hacer el new del autorRepository
	public AutorServiceImpl(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	@Override
	public Autor findOne(Long id) {
		return autorRepository.findOne(id);
	}

	@Override
	public void save(Autor autor) {
		autorRepository.save(autor);
	}

	@Override
	public void update(Long id, Autor autor) {
		// a saco
//		autorRepository.delete(id);
//		autorRepository.save(autor);
		
		Autor original = autorRepository.findOne(id);
		if (original != null) {
			original.setNombre(autor.getNombre());
			original.setDireccion(autor.getDireccion());
			original.setLibros(autor.getLibros());
			autorRepository.save(original);
		}
	}

	@Override
	public void delete(Long id) {
		autorRepository.delete(id);
	}

	@Override
	public List<Autor> findByBookTittle(String titulo) {
		// TODO Auto-generated method stub
		return autorRepository.findByLibros_Titulo(titulo);
	}
	
	

}
