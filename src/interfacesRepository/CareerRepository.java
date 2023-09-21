package interfacesRepository;

import java.util.List;

import Entities.Career;
import Entities.Student;

public interface CareerRepository {
	void insertCareer(Career career);
	void addStudent(Student student); //b
	List<Student> getStudentsByCarrerandCity(String careerName,String city); //g
}
