package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "genero")
	private String genero;
	@Column(name = "ciudadDeResidencia")
	private String ciudadDeResidencia;
	@Column(name = "edad")
	private int edad;
	@Column(name = "nroDni")
	@OneToMany
	private int nroDni;
	@Column(name = "nroLibreta")
	private int nroLibreta;

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String apellido, String genero, String ciudadDeResidencia, int edad, int nroDni,
			int nroLibreta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.ciudadDeResidencia = ciudadDeResidencia;
		this.edad = edad;
		this.nroDni = nroDni;
		this.nroLibreta = nroLibreta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudadDeResidencia() {
		return ciudadDeResidencia;
	}

	public void setCiudadDeResidencia(String ciudadDeResidencia) {
		this.ciudadDeResidencia = ciudadDeResidencia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNroDni() {
		return nroDni;
	}

	public void setNroDni(int nroDni) {
		this.nroDni = nroDni;
	}

	public int getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(int nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	@Override
	public String toString() {
		return "Estudiante [nroDni=" + nroDni + ", nombre=" + nombre + ", apellido=" + apellido + "nroLibreta="
				+ nroLibreta + ", genero=" + genero + ", edad=" + edad + ", ciudadDeResidencia=" + ciudadDeResidencia
				+ ",]";
	}

}
