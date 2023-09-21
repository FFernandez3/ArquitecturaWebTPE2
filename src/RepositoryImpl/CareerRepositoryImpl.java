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

}
