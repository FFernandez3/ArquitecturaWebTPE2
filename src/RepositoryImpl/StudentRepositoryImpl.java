package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.Career;
import Entities.Student;
import interfacesRepository.StudentRepository;

public class StudentRepositoryImpl implements StudentRepository {
	private EntityManager em;
	

	public StudentRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insertStudent(Student student) {
		 this.em.getTransaction().begin();
	     this.em.persist(student);
	     this.em.getTransaction().commit();
	     
		
	}

	@Override
	public List<Student> getAllOrderByDni() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByStudentId(long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentsByGenre(char genre) {
		// TODO Auto-generated method stub
		return null;
	}
	public Student saveStudent(Student s) {
		if (s.getDni() == null) {
		em.persist(s);
		} else {
		s = em.merge(s);
		}
		return s;
		}

}
