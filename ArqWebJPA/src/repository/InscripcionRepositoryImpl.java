package repository;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import entity.Carrera;
import entity.Estudiante;
import entity.Inscripcion;

public class InscripcionRepositoryImpl implements InscripcionRepository {

	public static InscripcionRepositoryImpl instance = new InscripcionRepositoryImpl();

	private InscripcionRepositoryImpl() {
	}

	public static InscripcionRepositoryImpl get_instance() {
		return instance;
	}

	@Override
	public Inscripcion findById(Integer id_inscripcion) {
		return RepositoryFactory.getEntity_manager().find(Inscripcion.class, id_inscripcion);
	}
	// mira esta funcion
   //public void setEgreso(Estudiante e, Carrera c, Date graduado) {
		//RepositoryFactory.getEntity_manager().getTransaction().begin();
		//TypedQuery<Inscripcion> i = RepositoryFactory.getEntity_manager().createQuery(
			//	"SELECT i FROM Inscripcion i WHERE carrera= :carr AND nroLibreta=:libreta", Inscripcion.class);
		//i.setParameter("libreta", e);
		//i.setParameter("carr", c);
		//Inscripcion Inscripcion = i.getSingleResult();
		//InscripcionsetAnioEgreso(graduado);
		//RepositoryFactory.getEntity_manager().getTransaction().commit();
		//RepositoryFactory.cerrar_conexion();
	//}

	@Override
	public List<Inscripcion> findAll() {
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM Inscripcion i", Inscripcion.class)
				.getResultList();
	}

	@Override
	public Inscripcion save(Inscripcion Inscripcion) {
		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (Inscripcion.getIdInscripcion() == 0) {
			RepositoryFactory.getEntity_manager().persist(Inscripcion);
		} else {
			Inscripcion = RepositoryFactory.getEntity_manager().merge(Inscripcion);
		}
		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return Inscripcion;
	}

	@Override
	public void delete(Inscripcion Inscripcion) {
		RepositoryFactory.getEntity_manager().remove(Inscripcion);
	}

}