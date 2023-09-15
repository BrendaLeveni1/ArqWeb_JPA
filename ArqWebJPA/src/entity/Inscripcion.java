package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Inscripcion {
private int id;
private int antiguedad;
private Date graduado;
private Carrera idCarrera;
private Estudiante nroDni;
public Inscripcion(int id, int antiguedad, Date graduado, Carrera idCarrera, Estudiante nroDni) {

	this.id = id;
	this.antiguedad = antiguedad;
	this.graduado = graduado;
	this.idCarrera = idCarrera;
	this.nroDni = nroDni;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String toString() {
	return "Inscripcion [id=" + id + ", antiguedad=" + antiguedad + ", graduado=" + graduado +  
			"idCarrera=" + idCarrera +", nroDni=" + nroDni + ",]";
}

}