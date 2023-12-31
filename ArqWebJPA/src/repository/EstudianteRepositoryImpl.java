package repository;

import java.util.List;
import entity.Estudiante;

public class EstudianteRepositoryImpl implements EstudianteRepository {

	public static EstudianteRepositoryImpl instance = new EstudianteRepositoryImpl();

	private EstudianteRepositoryImpl() {
	}

	public static EstudianteRepositoryImpl get_instance() {
		return instance;
	}

	@Override

	public Estudiante findById(Integer nroDni) {
		return RepositoryFactory.getEntity_manager().find(Estudiante.class, nroDni);
	}

	@Override
	public List<Estudiante> findAll() {
		return RepositoryFactory.getEntity_manager()
				.createQuery("SELECT e FROM Estudiante e ORDER BY e.nroDni", Estudiante.class).getResultList();
	}

	@Override

	public Estudiante save(Estudiante estudiante) {

		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (estudiante.getNroDni() == 0) {
			RepositoryFactory.getEntity_manager().persist(estudiante);
		} else {
			estudiante = RepositoryFactory.getEntity_manager().merge(estudiante);
		}
		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return estudiante;
	}

	public List<Estudiante> xGenero(String g) {
		String consulta = "SELECT e FROM Estudiante e WHERE e.genero LIKE :generoParametro ORDER BY e.apellido, e.nombre";
		TypedQuery<Estudiante> query = RepositoryFactory.getEntity_manager().createQuery(consulta, Estudiante.class);
		query.setParameter("generoParametro", "%" + g + "%");
		return query.getResultList();
	}


	@Override
	public void delete(Estudiante Estudiante) {
		RepositoryFactory.getEntity_manager().remove(Estudiante);
	}

	public List<Estudiante> xCarreraYciudad(Carrera carrera, String ciudad) {
		String consulta = "SELECT e FROM Estudiante e JOIN e.carreras c WHERE c = :carr AND e.ciudadDeResidencia LIKE :city";
		TypedQuery<Estudiante> query = RepositoryFactory.getEntity_manager().createQuery(consulta, Estudiante.class);
		query.setParameter("carr", carrera);
		query.setParameter("city", "%" + ciudad + "%");
		return query.getResultList();
	}

}