package Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentCareer implements Serializable {
	@Id
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="career", referencedColumnName="id")
	private Career career;
	
	@Id
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="student", referencedColumnName="dni")
	private Student student;
	
	@Column(nullable=true)
	private Integer graduationYear;
	@Column(nullable=false)
	private Integer entryYear;
	@Column(nullable=false)
	private boolean isGraduated;
	
	
	
	public StudentCareer() {
		super();
	}
	
	public StudentCareer(Career career, Student student, Integer graduationYear, Integer entryYear, boolean isGraduated) {
		super();
		this.career = career;
		this.student = student;
		this.graduationYear = graduationYear;
		this.entryYear = entryYear;
		this.isGraduated = isGraduated;
	}
	
	

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}
	public int getEntryYear() {
		return entryYear;
	}
	public void setEntryYear(int entryYear) {
		this.entryYear = entryYear;
	}
	public boolean isGraduated() {
		return isGraduated;
	}
	public void setGraduated() {
		if(graduationYear==null) {
			this.isGraduated=false;
		}
		else {
			this.isGraduated=true;
		}
	
	}
	
	

}
