package cmc.formacion.springbootrest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cmc.formacion.springbootrest.domain.Autor;
import cmc.formacion.springbootrest.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
	
	AutorRepository autorRepository;

	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	@Override
	public Autor findOne(Long id) {
		System.out.println("control");
		return autorRepository.findOne(id);
	}

	@Override
	public void save(Autor autor) {
		autorRepository.save(autor);
	}

	@Override
	public void update(Long id, Autor autor) {
		autorRepository.delete(id);
		autorRepository.save(autor);
	}

	@Override
	public void delete(Long id) {
		autorRepository.delete(id);
	}

}
