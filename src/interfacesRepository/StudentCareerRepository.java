package interfacesRepository;

import java.util.List;

import Entities.Career;
import dto.CareerReportDTO;
import dto.EnrolledDTO;

public interface StudentCareerRepository {
	List<EnrolledDTO>getCareersOrderByQuantity();//f
	List<CareerReportDTO>getReport();
	

}
