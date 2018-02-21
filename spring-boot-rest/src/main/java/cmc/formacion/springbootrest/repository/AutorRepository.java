package cmc.formacion.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cmc.formacion.springbootrest.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
