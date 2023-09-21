package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.Career;
import interfacesRepository.StudentCareerRepository;

public class StudentCareerRepositoryImpl implements StudentCareerRepository{
	private EntityManager em;
	
	public StudentCareerRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}


	@Override
	public List<Career> getCareersOrderByQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

}
