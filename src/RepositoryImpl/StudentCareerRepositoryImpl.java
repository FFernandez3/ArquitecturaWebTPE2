package RepositoryImpl;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.internal.build.AllowSysOut;

import Entities.Career;
import Entities.Student;
import Entities.StudentCareer;
import dto.CareerReportDTO;
import dto.EnrolledDTO;
import dto.StudentDTO;
import interfacesRepository.StudentCareerRepository;

public class StudentCareerRepositoryImpl implements StudentCareerRepository {
	private EntityManager em;

	public StudentCareerRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void insertStudentCareer(StudentCareer studentcareer) {
		this.em.getTransaction().begin();
		this.em.persist(studentcareer);
		this.em.getTransaction().commit();

	}

	@Override
	public List<EnrolledDTO> getCareersOrderByQuantity() {
		String jpql = "SELECT new dto.EnrolledDTO (c.id, c.name, COUNT(c.id) AS quantity) FROM Career c JOIN StudentCareer sc ON c.id = sc.career  GROUP BY c.name ORDER BY quantity";
		Query query = this.em.createQuery(jpql);
		List<EnrolledDTO> results = query.getResultList();
		results.forEach(r -> System.out.println(r));
		return results;
	}

	public StudentCareer saveStudentCareer(StudentCareer sc) {
		if (sc.getCareer() == null && sc.getStudent() == null) {
			em.persist(sc);
		} else {
			sc = em.merge(sc);
		}
		return sc;
	}


	@Override
	public List<CareerReportDTO> getReport() {
		String sql = "SELECT \r\n" + "    c.career_name AS nombre_carrera,\r\n" + "    years.anio AS anio,\r\n"
				+ "    COALESCE(inscriptos.count, 0) AS inscriptos,\r\n"
				+ "    COALESCE(egresados.count, 0) AS egresados\r\n" + "FROM\r\n" + "    career c\r\n"
				+ "CROSS JOIN (\r\n" + "    SELECT DISTINCT entryYear AS anio FROM studentcareer\r\n" + "    UNION\r\n"
				+ "    SELECT DISTINCT graduationYear AS anio FROM studentcareer WHERE graduationYear IS NOT NULL\r\n"
				+ ") years\r\n" + "LEFT JOIN (\r\n" + "    SELECT\r\n" + "        sc.career,\r\n"
				+ "        sc.entryYear AS anio,\r\n" + "        COUNT(DISTINCT s.dni) AS count\r\n" + "    FROM\r\n"
				+ "        studentcareer sc\r\n" + "    JOIN\r\n" + "        student s ON sc.student = s.dni\r\n"
				+ "    GROUP BY\r\n" + "        sc.career, sc.entryYear\r\n"
				+ ") inscriptos ON c.id = inscriptos.career AND years.anio = inscriptos.anio\r\n" + "LEFT JOIN (\r\n"
				+ "    SELECT\r\n" + "        sc.career,\r\n" + "        sc.graduationYear AS anio,\r\n"
				+ "        COUNT(DISTINCT s.dni) AS count\r\n" + "    FROM\r\n" + "        studentcareer sc\r\n"
				+ "    JOIN\r\n" + "        student s ON sc.student = s.dni\r\n" + "    WHERE\r\n"
				+ "        sc.graduationYear IS NOT NULL\r\n" + "    GROUP BY\r\n"
				+ "        sc.career, sc.graduationYear\r\n"
				+ ") egresados ON c.id = egresados.career AND years.anio = egresados.anio\r\n" + "ORDER BY\r\n"
				+ "    c.career_name, years.anio";

		Query query = this.em.createNativeQuery(sql);
		List<Object[]> results = query.getResultList();
		// results.forEach(r->System.out.println(r));
		/*
		 * results.stream().forEach(r->{ System.out.println(r[0]);
		 * System.out.println((Integer)r[1]);
		 * System.out.println(((BigInteger)r[2]).longValue());
		 * System.out.println((r[3])); });
		 */

		return results.stream()
				.map(r -> new CareerReportDTO((String) r[0], (Integer) r[1], (BigInteger) r[2], (BigInteger) r[3]))
				.collect(Collectors.toList());

	}

}
