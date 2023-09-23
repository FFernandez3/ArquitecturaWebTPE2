package interfacesRepository;

import java.util.List;

import Entities.Student;
import dto.StudentDTO;

public interface StudentRepository {
	void insertStudent(Student student);//a
	List<StudentDTO> getAllOrderByDni(); //c
	StudentDTO getStudentByStudentId(long studentId);//d
	List<StudentDTO> getAllStudentsByGenre(char genre);//e
	
	
	
}
