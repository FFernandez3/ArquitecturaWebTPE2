package dto;

import Entities.Career;
import Entities.Student;

public class EnrolledDTO {
	
	private Integer careerId;
	private String careerName;
	private String studentName;
	private String city;
	private Long quantity;

	public EnrolledDTO() {
		
	}

	public EnrolledDTO(Integer careerId, String careerName, String studentName, String city) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.studentName = studentName;
		this.city = city;
	}

	public EnrolledDTO(Integer careerId, String careerName, Long quantity) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.quantity = quantity;
	}

	public Integer getCareerId() {
		return careerId;
	}
	
	public Long getQuantity() {
		return quantity;
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

	/*@Override
	public String toString() {
		return "EnrolledDTO [careerId=" + careerId + ", careerName=" + careerName +
				   ", quantity=" + quantity + "]";
	}*/



	@Override
	public String toString() {
		return "EnrolledDTO [careerId=" + careerId + ", careerName=" + careerName + ", studentName=" + studentName
				+ ", city=" + city + ", quantity=" + quantity + "]";
	}
	
	




	
	
	
	

}
