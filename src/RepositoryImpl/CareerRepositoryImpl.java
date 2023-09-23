package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.Career;
import Entities.Student;
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
	public List<Student> getStudentsByCarrerandCity(String careerName, String city) {
		// TODO Auto-generated method stub
		return null;
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
