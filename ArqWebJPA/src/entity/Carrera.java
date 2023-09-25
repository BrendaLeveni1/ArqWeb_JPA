package entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_inscripcion;
	@Column(name = "antiguedad")
	private int antiguedad;
	@Column(name = "graduado")
	private Date graduado;
	@Column (name = "idCarrera")
	@ManyToMany
	private Carrera idCarrera;
	@Column (name = "nroDni")
	@ManyToOne
	private Estudiante nroDni;
	@Column
	private int anioIngreso;

	@Column
	private int anioEgreso;
	
	

	public Inscripcion() {
	}

	public Inscripcion(int id_inscripcion, int antiguedad, Date graduado, Carrera idCarrera, Estudiante nroDni,int anioIngreso) {

		this.id_inscripcion = id_inscripcion;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
		this.idCarrera = idCarrera;
		this.nroDni = nroDni;
		this.anioIngreso = anioIngreso;
	}

	public int getIdInscripcion() {
		return id_inscripcion;
	}

	public void setIdInscripcion(int id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Date getGraduado() {
		return graduado;
	}

	public void setGraduado(Date graduado) {
		this.graduado = graduado;
	}

	public Carrera getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Estudiante getNroDni() {
		return nroDni;
	}

	public void setNroDni(Estudiante nroDni) {
		this.nroDni = nroDni;
	}
	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioEgreso(int anio) {
		this.anioEgreso = anio;
	}
	public int getAnioEgreso() {
		return anioEgreso;
	}

	public String toString() {
		return "Inscripcion [id_inscripcion=" + id_inscripcion + ", antiguedad=" + antiguedad + ", graduado=" + graduado + "idCarrera="
				+ idCarrera + ", nroDni=" + nroDni + ", anioIngreso="
						+ anioIngreso
						+ ", anioEgreso=" + anioEgreso + ",]";
	}

}