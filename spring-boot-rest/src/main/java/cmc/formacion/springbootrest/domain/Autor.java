package cmc.formacion.springbootrest.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity // Entidad para la base de datos
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //Autoincremental
	private Long id;
	
	@NotNull
	private String nombre;
	
	private String direccion;

	

	public Autor() {
		super();
	}

	public Autor(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Autor(Long id, String nombre, String direccion, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.libros = libros;
	}



	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// Como es una relacion many2many hace falta crear una tabla intermedia
	// que relacione los id de una tabla con los de la otra y viceversa
	@JoinTable(name = "autor_libro", 
		joinColumns = @JoinColumn(name = "id_autor"), 
		inverseJoinColumns = @JoinColumn(name = "id_libro"))
	private List<Libro> libros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", libros=" + libros + "]";
	}
	
	

}
