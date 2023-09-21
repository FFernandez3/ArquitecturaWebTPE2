package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	private long dni;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String surname;
	@Column(nullable=false)
	private char genre;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	private long studentId;
	@Column(nullable=false)
	private String city;
	@OneToMany(mappedBy="career")
	private List<StudentCareer>careers;
	
	
	public Student() {
		super();
		this.careers=new ArrayList<StudentCareer>();
	}
	
	public Student(long dni, String name, String surname, char genre, int age, long studentId, String city) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.genre = genre;
		this.age = age;
		this.studentId = studentId;
		this.city = city;
		this.careers=new ArrayList<StudentCareer>();
	}
	public ArrayList<StudentCareer> getCareers() {
		return new ArrayList<StudentCareer>(this.careers);
	}
	
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public char getGenre() {
		return genre;
	}
	public void setGenre(char genre) {
		this.genre = genre;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
