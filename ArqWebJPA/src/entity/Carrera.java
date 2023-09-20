package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Carrera {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToMany(mappedBy = "inscripcion", fetch = FetchType.LAZY)
	private List<Inscripcion> id_inscripcion;
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	// ??
	private ArrayList<Estudiante> estudiantes;

	public Carrera() {
		super();

	}

	public Carrera(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.estudiantes = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}

}
