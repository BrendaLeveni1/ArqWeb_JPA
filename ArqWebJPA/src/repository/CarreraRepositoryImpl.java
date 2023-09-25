package repository;

import java.util.ArrayList;
import java.util.List;
import entity.Carrera;

public class CarreraRepositoryImpl implements CarreraRepository {

	public static CarreraRepositoryImpl instance = new CarreraRepositoryImpl();

	private CarreraRepositoryImpl() {
	}

	public static CarreraRepositoryImpl get_instance() {
		return instance;
	}

	@Override
	public Carrera findById(Integer id) {
		return RepositoryFactory.getEntity_manager().find(Carrera.class, id);
	}

	@Override
	public List<Carrera> findAll() {
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM Carrera c", Carrera.class)
				.getResultList();
	}

	@Override
	public Carrera save(Carrera carrera) {
		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (carrera.getId() == 0) {
			RepositoryFactory.getEntity_manager().persist(carrera);
		} else {
			carrera = RepositoryFactory.getEntity_manager().merge(carrera);
		}

		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return carrera;

	}

	@Override
	public void delete(Carrera Carrera) {
		RepositoryFactory.getEntity_manager().remove(Carrera);
	}

	public List<CarreraYInscripcionDTO> xEstudiantesInscriptos() {
		String consulta = "SELECT NEW dtos.CarreraYInscripcionDTO(c, SIZE(c.estudiantes)) FROM Carrera c ORDER BY SIZE(c.estudiantes)";
		return RepositoryFactory.getEntity_manager().createQuery(consulta, CarreraYInscripcionDTO.class).getResultList();
	}

	
	public List<EstudianteDTO> reporte() {
		String consulta = "SELECT NEW dtos.EstudianteDTO(c , e, i, i.anioIngreso as fech) FROM Inscripcion i JOIN i.estudiante e JOIN i.carrera c";
		TypedQuery<EstudianteDTO> query = RepositoryFactory.getEntity_manager().createQuery(consulta,
				EstudianteDTO.class);
		List<EstudianteDTO> ingresos = query.getResultList();

		consulta = "SELECT NEW dtos.EstudianteDTO(c , e, i, i.anioEgreso as fech) FROM Inscripcion i JOIN i.estudiante e JOIN i.carrera c WHERE i.anioEgreso IS NOT NULL AND i.anioEgreso <> 0";
		query = RepositoryFactory.getEntity_manager().createQuery(consulta, EstudianteDTO.class);
		List<EstudianteDTO> egresos = query.getResultList();

		List<EstudianteDTO> resultados = new ArrayList<>();
		resultados.addAll(ingresos);
		resultados.addAll(egresos);

		return resultados;
	}
}