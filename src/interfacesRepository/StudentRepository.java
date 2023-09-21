package interfacesRepository;

import java.util.List;

import Entities.Student;

public interface StudentRepository {
	void insertStudent(Student student);//a
	List<Student> getAllOrderByDni(); //c
	Student getStudentByStudentId(long studentId);//d
	List<Student> getAllStudentsByGenre(char genre);//e
	
	
	
}
