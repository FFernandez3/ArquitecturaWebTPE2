package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;

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
		// TODO Auto-generated method stub
		
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
	

}
