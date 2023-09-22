package Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import RepositoryImpl.CareerRepositoryImpl;
import RepositoryImpl.StudentCareerRepositoryImpl;
import RepositoryImpl.StudentRepositoryImpl;


public abstract class FactoryEntityManager {
	protected EntityManager em;
    private EntityManagerFactory emf;
    
    public FactoryEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MYSQL");
        this.emf =emf;
        this.em = emf.createEntityManager();
    }
    
	public abstract StudentRepositoryImpl getStudentRepositoryImpl();

	public abstract CareerRepositoryImpl getCareerRepositoryImpl();

	public abstract StudentCareerRepositoryImpl getStudentCareerRepositoryImpl();
	
	

	public static FactoryEntityManager getEntityManager(String baseDeDatos) {

		switch (baseDeDatos) {
		case "MYSQL":
			return MySQLEntityManagerFactory.getInstance();
		case "DERBY":
			return null;
		case "POSTGRESQL":
			return null;
		default:
			return null;
		}

	}
}
