package dto;

import Entities.Career;
import Entities.Student;

public class CareerReportDTO {
	private Integer careerId;
	private String careerName;
	private Long dni;
	private Integer entryYear;
	private Integer graduationYear;
	
	public CareerReportDTO() {
		
	}

	

	public CareerReportDTO(Integer careerId, String careerName, Long dni, Integer entryYear, Integer graduationYear) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.dni = dni;
		this.entryYear = entryYear;
		this.graduationYear = graduationYear;
	}


	public Integer getCareerId() {
		return careerId;
	}



	public String getCareerName() {
		return careerName;
	}



	public Long getDni() {
		return dni;
	}



	public Integer getEntryYear() {
		return entryYear;
	}

	public Integer getGraduationYear() {
		return graduationYear;
	}



	@Override
	public String toString() {
		return "CareerReportDTO [careerId=" + careerId + ", careerName=" + careerName + ", dni=" + dni + ", entryYear="
				+ entryYear + ", graduationYear=" + graduationYear + "]";
	}
	

}
