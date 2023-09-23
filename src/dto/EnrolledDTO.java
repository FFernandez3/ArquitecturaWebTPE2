package dto;

import Entities.Career;
import Entities.Student;

public class EnrolledDTO {
	
	private Integer careerId;
	private String careerName;
	private String studentName;
	private String city;

	public EnrolledDTO() {
		
	}



	public EnrolledDTO(Integer careerId, String careerName, String studentName, String city) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.studentName = studentName;
		this.city = city;
	}



	public Integer getCareerId() {
		return careerId;
	}



	public String getCareerName() {
		return careerName;
	}



	public String getStudentName() {
		return studentName;
	}



	public String getCity() {
		return city;
	}




	
	
	
	

}
