package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Entities.Career;
import Entities.Student;
import dto.EnrolledDTO;
import dto.StudentDTO;
import interfacesRepository.CareerRepository;

public class CareerRepositoryImpl implements CareerRepository {
	private EntityManager em;

	public CareerRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insertCareer(Career career) {

		this.em.getTransaction().begin();
		this.em.persist(career);
		this.em.getTransaction().commit();

	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city) {
		//this.em.getTransaction().begin();
		String jpql="SELECT new dto.EnrolledDTO (c.id, c.name, s.name, s.city) FROM Student s JOIN StudentCareer sc ON s.dni = sc.dni JOIN Career c ON sc.careerId = c.careerId WHERE c.name = :careerName AND s.city = :city";
		Query query=em.createQuery(jpql);
		query.setParameter("careerName", careerName); //career_name en tabla y name en la entidad
		query.setParameter("city", city);
		List<EnrolledDTO> results=query.getResultList();
		//this.em.getTransaction().commit();
		results.forEach(r->System.out.println(r));
		//this.em.close();
		return results;
	}

	public Career saveCareer(Career c) {
		if (c.getId() == null) {
			em.persist(c);
		} else {
			c = em.merge(c);
		}
		return c;
	}
}
