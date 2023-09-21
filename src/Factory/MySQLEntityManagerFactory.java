package Factory;

import RepositoryImpl.CareerRepositoryImpl;
import RepositoryImpl.StudentCareerRepositoryImpl;
import RepositoryImpl.StudentRepositoryImpl;
import interfacesRepository.CareerRepository;
import interfacesRepository.StudentCareerRepository;
import interfacesRepository.StudentRepository;

public class MySQLEntityManagerFactory extends FactoryEntityManager {
	private static MySQLEntityManagerFactory instance;

	private MySQLEntityManagerFactory(String db) {
		super(db);
	}

	public static FactoryEntityManager getInstance(String db) {
		if (instance == null) {
			instance = new MySQLEntityManagerFactory(db);
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
