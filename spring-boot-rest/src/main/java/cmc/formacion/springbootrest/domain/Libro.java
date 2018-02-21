package cmc.formacion.springbootrest.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity // Entidad para la base de datos
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //Autoincremental
	private Long id;
	
	@NotNull
	private String titulo;
	
	@ManyToMany(mappedBy = "libros", fetch = FetchType.EAGER)
	private List<Autor> autores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autores=" + autores + "]";
	}
	
	

}
