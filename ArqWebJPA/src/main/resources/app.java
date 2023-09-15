package main.resources;

import entity.Estudiante;
import repository.RepositoryFactory;

public class app {

	public static void main(String[] args) {
		RepositoryFactory.getInstance(RepositoryFactory.MYSQL);

		Estudiante j1 = new Estudiante("Nelson", "Defensa");
		Estudiante j = RepositoryFactory.get_repositorio_estudiante().save(j1);

		System.out.println(j);

	}

}
