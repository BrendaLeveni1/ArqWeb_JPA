package entity;

import java.util.ArrayList;

import javax.persistence.Entity;



@Entity
public class Carrera {
	private int id;
	private String nombre;
	private ArrayList<Estudiante>estudiantes;
	 
	
	
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
