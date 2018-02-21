package cmc.formacion.springbootrest.v1.model;

public class AutorDTO {
	
	private Long id;
	
	private String nombre;
	
	public AutorDTO() {
		super();
	}

	public AutorDTO(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

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
	
}
