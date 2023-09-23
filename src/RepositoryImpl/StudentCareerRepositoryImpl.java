package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.Career;
import Entities.Student;
import Entities.StudentCareer;
import interfacesRepository.StudentCareerRepository;

public class StudentCareerRepositoryImpl implements StudentCareerRepository{
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
	public List<Career> getCareersOrderByQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public StudentCareer saveStudentCareer(StudentCareer sc) {
		if (sc.getCareer() == null && sc.getStudent()== null) {
		em.persist(sc);
		} else {
		sc = em.merge(sc);
		}
		return sc;
		}

}
