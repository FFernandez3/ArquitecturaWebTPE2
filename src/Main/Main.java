package Main;

import java.util.List;

import Entities.Career;
import Entities.Student;
import Entities.StudentCareer;
import Factory.FactoryEntityManager;
import RepositoryImpl.CareerRepositoryImpl;
import RepositoryImpl.StudentCareerRepositoryImpl;
import RepositoryImpl.StudentRepositoryImpl;
import dto.StudentDTO;

public class Main {
	 /*public static void crearBaseDeDatos(String nombreDb) {
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
	        conn.setAutoCommit(false);
	        String sql = "CREATE DATABASE IF NOT EXISTS "+ nombreDb;
	        conn.prepareStatement(sql).execute();
	        conn.commit();
	        conn.close();
	 }*/

	public static void main(String[] args) {
		FactoryEntityManager MYSQL = FactoryEntityManager.getEntityManager("MYSQL");
		
		CareerRepositoryImpl cri = MYSQL.getCareerRepositoryImpl();
		StudentCareerRepositoryImpl scri = MYSQL.getStudentCareerRepositoryImpl();
		StudentRepositoryImpl sri = MYSQL.getStudentRepositoryImpl();
		
		Career c1 = new Career("TUDAI");
		Career c2 = new Career("Ingenieria");
		
		Student s1 = new Student(32472514L, "Maria", "Conti", 'F', 28, 25678L, "Tandil");
		Student s2 = new Student(39290710L, "Florencia", "Fernandez", 'F', 22, 25999L, "Tandil");
		
		StudentCareer sc1 = new StudentCareer(c2,s2,null,2024, false);
		
		
		//cri.insertCareer(c1);
		//cri.insertCareer(c2);
		//sri.insertStudent(s1);
		//sri.insertStudent(s2);
		//scri.insertStudentCareer(sc1);
		
		sri.getAllStudentsByGenre('F');
		sri.getAllOrderByDni();
		sri.getStudentByStudentId(25999L);
		
	
	}

}
