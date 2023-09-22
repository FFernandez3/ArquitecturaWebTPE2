package Factory;

import RepositoryImpl.CareerRepositoryImpl;
import RepositoryImpl.StudentCareerRepositoryImpl;
import RepositoryImpl.StudentRepositoryImpl;
import interfacesRepository.CareerRepository;
import interfacesRepository.StudentCareerRepository;
import interfacesRepository.StudentRepository;

public class MySQLEntityManagerFactory extends FactoryEntityManager {
	private static MySQLEntityManagerFactory instance;

	private MySQLEntityManagerFactory() {
		super();
	}

	public static FactoryEntityManager getInstance() {
		if (instance == null) {
			instance = new MySQLEntityManagerFactory();
		}
		return instance;
	}

	@Override
	public StudentRepositoryImpl getStudentRepositoryImpl() {
		
		return null;
	}

	@Override
	public CareerRepositoryImpl getCareerRepositoryImpl() {
		
		return null;
	}

	@Override
	public StudentCareerRepositoryImpl getStudentCareerRepositoryImpl() {
		
		return null;
	}

}
