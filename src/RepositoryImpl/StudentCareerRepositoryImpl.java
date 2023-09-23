package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Career;
import Entities.Student;
import Entities.StudentCareer;
import dto.CareerReportDTO;
import dto.EnrolledDTO;
import dto.StudentDTO;
import interfacesRepository.StudentCareerRepository;

public class StudentCareerRepositoryImpl implements StudentCareerRepository {
	private EntityManager em;

	public StudentCareerRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertStudentCareer(StudentCareer studentcareer) {
		this.em.getTransaction().begin();
		this.em.persist(studentcareer);
		this.em.getTransaction().commit();

	}

	@Override
	public List<EnrolledDTO> getCareersOrderByQuantity() {
		//this.em.getTransaction().begin();
		String jpql="SELECT new EnrolledDTO (c.id, c.name, s.name, s.city), COUNT(*) AS quantity FROM StudentCareer c GROUP BY c.id ORDER BY quantity DESC";
		TypedQuery<EnrolledDTO> typedQuery=this.em.createQuery(jpql, EnrolledDTO.class);
	    List<EnrolledDTO> results = typedQuery.getResultList();
		//this.em.getTransaction().commit();
	   // this.em.close();
		return  results;
	}

	public StudentCareer saveStudentCareer(StudentCareer sc) {
		if (sc.getCareer() == null && sc.getStudent() == null) {
			em.persist(sc);
		} else {
			sc = em.merge(sc);
		}
		return sc;
	}

	@Override
	public List<CareerReportDTO> getReport() {
		this.em.getTransaction().begin();
		String jpql="";
		this.em.getTransaction().commit();
		this.em.close();
		return null;
	}

}
