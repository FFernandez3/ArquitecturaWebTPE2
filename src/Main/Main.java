package Main;

import Entities.Career;
import Factory.FactoryEntityManager;
import RepositoryImpl.CareerRepositoryImpl;
import RepositoryImpl.StudentCareerRepositoryImpl;
import RepositoryImpl.StudentRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		FactoryEntityManager MYSQL = FactoryEntityManager.getEntityManager("MYSQL");
		
		CareerRepositoryImpl cri = MYSQL.getCareerRepositoryImpl();
		StudentCareerRepositoryImpl scri = MYSQL.getStudentCareerRepositoryImpl();
		StudentRepositoryImpl sri = MYSQL.getStudentRepositoryImpl();
		
		Career c1 = new Career("TUDAI");
		
		cri.insertCareer(c1);
		

	}

}
