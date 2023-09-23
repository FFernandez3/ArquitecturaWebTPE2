package interfacesRepository;

import java.util.List;

import Entities.Career;
import Entities.Student;
import dto.EnrolledDTO;
import dto.StudentDTO;

public interface CareerRepository {
	void insertCareer(Career career);
	void addStudent(Student student); //b
	List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName,String city); //g
}
