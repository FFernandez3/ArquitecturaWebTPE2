package dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import Entities.StudentCareer;

public class StudentDTO {
	private Long dni;

	private String name;
	
	private String surname;
	
	private char genre;
	
	private int age;
	
	private Long studentId;
	
	private String city;
	
	public StudentDTO() {
		
	}

	public StudentDTO(Long dni, String name, String surname, char genre, int age, Long studentId, String city) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.genre = genre;
		this.age = age;
		this.studentId = studentId;
		this.city = city;
	}

	public Long getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public char getGenre() {
		return genre;
	}

	public int getAge() {
		return age;
	}

	public Long getStudentId() {
		return studentId;
	}

	public String getCity() {
		return city;
	}
	
	

}
