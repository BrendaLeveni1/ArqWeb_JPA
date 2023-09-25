package main.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Carrera;
import entity.Estudiante;
import repository.RepositoryFactory;

public class app {

	public static void main(String[] args) {
		//Conexion
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		// Insertar carrera
		Carrera carrera_1 = new Carrera ();
		em.persist(carrera_1);
		
		// Insertar Estudiante
		Estudiante estudiante1 = new Estudiante ();
		em.persist(estudiante1);
		
		Estudiante estudiante2 = new Estudiante ();
		em.persist(estudiante2);
		
		// Obtener estudiante
		Estudiante estudiante_select = em.find(Estudiante.class, 1);
		System.out.println(estudiante_select.toString());
		
		// Query JPQL
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
		estudiantes.forEach(j -> System.out.println(j.toString()));
		
		em.getTransaction().commit();
		em.close();
		emf.close();		


	}

}