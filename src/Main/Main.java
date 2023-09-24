package Main;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.internal.build.AllowSysOut;

import Entities.Career;
import Entities.Student;
import Entities.StudentCareer;
import Factory.FactoryEntityManager;
import RepositoryImpl.CareerRepositoryImpl;
import RepositoryImpl.StudentCareerRepositoryImpl;
import RepositoryImpl.StudentRepositoryImpl;
import dto.CareerReportDTO;
import dto.StudentDTO;

public class Main {

	public static void main(String[] args) {
		FactoryEntityManager MYSQL = FactoryEntityManager.getEntityManager("MYSQL");

		CareerRepositoryImpl cri = MYSQL.getCareerRepositoryImpl();
		StudentCareerRepositoryImpl scri = MYSQL.getStudentCareerRepositoryImpl();
		StudentRepositoryImpl sri = MYSQL.getStudentRepositoryImpl();

		Career c1 = new Career("TUDAI");
		Career c2 = new Career("Ingenieria");
		Career c3 = new Career("TUARI");
		Career c4 = new Career("Profesorado de Matematica");
		Career c5 = new Career("Profesorado de Fisica");
		Career c6 = new Career("Licenciatura en Matematica");

		Student s1 = new Student(32472514L, "Maria", "Conti", 'F', 28, 25678L, "Tandil");
		Student s2 = new Student(39290710L, "Florencia", "Fernandez", 'F', 22, 25999L, "Tandil");
		Student s3 = new Student(34258339L, "Florencia", "Bazan", 'F', 34, 25946L, "Tandil");
		Student s4 = new Student(35350712L, "Melisa", "Burlando", 'F', 24, 25752L, "Tandil");
		Student s5 = new Student(29286713L, "Lucrecia", "Martinez", 'F', 39, 24984L, "Tandil");
		Student s6 = new Student(29795841L, "Marcelo", "Perez", 'M', 38, 23798L, "Tres Arroyos");
		Student s7 = new Student(34965375L, "Pablo", "Lopez", 'M', 32, 24697L, "Tandil");
		Student s8 = new Student(38754159L, "Nicolás", "Esperado", 'M', 23, 23467L, "Tres Arroyos");
		Student s9 = new Student(33456789L, "Pedro", "Destino", 'M', 36, 24951L, "Azul");
		Student s10 = new Student(31483927L, "Bautista", "Rodriguez", 'M', 37, 25678L, "Tandil");
		Student s11 = new Student(35497843L, "Martí", "Navarro", 'M', 35, 23472L, "Azul");

		StudentCareer sc1 = new StudentCareer(c2, s2, null, 2024, false);
		StudentCareer sc2 = new StudentCareer(c1, s1, 2023, 2019, true);
		StudentCareer sc3 = new StudentCareer(c2, s1, null, 2023, false);
		StudentCareer sc4 = new StudentCareer(c4, s2, null, 2024, false);
		StudentCareer sc5 = new StudentCareer(c5, s5, null, 2021, false);
		StudentCareer sc6 = new StudentCareer(c6, s7, null, 2019, false);
		StudentCareer sc7 = new StudentCareer(c1, s8, 2022, 2020, true);
		StudentCareer sc8 = new StudentCareer(c6, s9, null, 2024, false);
		StudentCareer sc9 = new StudentCareer(c4, s10, null, 2024, false);
		StudentCareer sc10 = new StudentCareer(c3, s11, 2021, 2019, true);
		StudentCareer sc11 = new StudentCareer(c2, s4, null, 2023, false);
		StudentCareer sc12 = new StudentCareer(c5, s6, null, 2023, false);

		cri.insertCareer(c1);
		cri.insertCareer(c2);
		cri.insertCareer(c3);
		cri.insertCareer(c4);
		cri.insertCareer(c5);
		cri.insertCareer(c6);

		sri.insertStudent(s1);
		sri.insertStudent(s2);
		sri.insertStudent(s3);
		sri.insertStudent(s4);
		sri.insertStudent(s5);
		sri.insertStudent(s6);
		sri.insertStudent(s7);
		sri.insertStudent(s8);
		sri.insertStudent(s9);
		sri.insertStudent(s10);
		sri.insertStudent(s11);

		scri.insertStudentCareer(sc1);
		scri.insertStudentCareer(sc2);
		scri.insertStudentCareer(sc3);
		scri.insertStudentCareer(sc4);
		scri.insertStudentCareer(sc5);
		scri.insertStudentCareer(sc6);
		scri.insertStudentCareer(sc7);
		scri.insertStudentCareer(sc8);
		scri.insertStudentCareer(sc9);
		scri.insertStudentCareer(sc10);
		scri.insertStudentCareer(sc11);
		scri.insertStudentCareer(sc12);

		System.out.println("---2c-----------------------------------------------------------------");
		sri.getAllOrderByDni();
		System.out.println("---2d-----------------------------------------------------------------");
		sri.getStudentByStudentId(24984L);
		System.out.println("---2e-----------------------------------------------------------------");
		sri.getAllStudentsByGenre('M');
		System.out.println("---2f-----------------------------------------------------------------");
		scri.getCareersOrderByQuantity();
		System.out.println("---2g-----------------------------------------------------------------");
		cri.getStudentsByCarrerAndCity("TUDAI", "Tandil");
		System.out.println("---3-----------------------------------------------------------------");
		List<CareerReportDTO> results = scri.getReport();
		results.forEach(r -> System.out.println(r));
	}

}
