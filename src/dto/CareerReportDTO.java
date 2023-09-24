package dto;

import java.math.BigInteger;

import Entities.Career;
import Entities.Student;

public class CareerReportDTO {
	private Integer careerId;
	private String careerName;
	private Long dni;
	private Integer entryYear;
	private Integer graduationYear;
	private Integer years;
	private BigInteger graduates;
	private BigInteger registered;

	public CareerReportDTO() {

	}

	public CareerReportDTO(String careerName, Integer years, BigInteger registered, BigInteger graduates) {
		super();
		this.careerName = careerName;
		this.years = years;
		this.graduates = graduates;
		this.registered = registered;
	}

	public CareerReportDTO(Integer careerId, String careerName, Long dni, Integer entryYear, Integer graduationYear,
			Integer years, BigInteger graduates, BigInteger registered) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.dni = dni;
		this.entryYear = entryYear;
		this.graduationYear = graduationYear;
		this.years = years;
		this.graduates = graduates;
		this.registered = registered;
	}

	public CareerReportDTO(Integer careerId, String careerName, Long dni, Integer entryYear, Integer graduationYear) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.dni = dni;
		this.entryYear = entryYear;
		this.graduationYear = graduationYear;
	}

	public Integer getYears() {
		return years;
	}

	public BigInteger getGraduates() {
		return graduates;
	}

	public BigInteger getRegistered() {
		return registered;
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
		return "CareerReportDTO [careerName=" + careerName + ", years=" + years + ", graduates=" + graduates
				+ ", registered=" + registered + "]";
	}

	/*
	 * @Override public String toString() { return "CareerReportDTO [careerId=" +
	 * careerId + ", careerName=" + careerName + ", dni=" + dni + ", entryYear=" +
	 * entryYear + ", graduationYear=" + graduationYear + "]"; }
	 */

}
