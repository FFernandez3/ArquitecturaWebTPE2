package RepositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Career;
import Entities.Student;
import dto.StudentDTO;
import interfacesRepository.StudentRepository;

public class StudentRepositoryImpl implements StudentRepository {
	private EntityManager em;

	public StudentRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insertStudent(Student student) {
		this.em.getTransaction().begin();
		this.em.persist(student);
		this.em.getTransaction().commit();
	}

	@Override
	public List<StudentDTO> getAllOrderByDni() {
		this.em.getTransaction().begin();
		String jpql="SELECT s FROM Student s ORDER BY s.dni DESC";
		Query query=this.em.createQuery(jpql);
		List<StudentDTO> results=query.getResultList();
		this.em.getTransaction().commit();
		return results;
	}

	@Override
	public StudentDTO getStudentByStudentId(long studentId) { //hecha con TypedQuery
		this.em.getTransaction().begin();
		String jpql="SELECT s FROM Student s WHERE s.id = :studentId;";
		TypedQuery<StudentDTO> typedQuery=this.em.createQuery(jpql, StudentDTO.class);
		typedQuery.setParameter("studentId", studentId);
	    StudentDTO result = (StudentDTO)typedQuery.getSingleResult();
		this.em.getTransaction().commit();
		return result;
	}

	@Override
	public List<StudentDTO> getAllStudentsByGenre(char genre) {
		this.em.getTransaction().begin();
		String jpql="SELECT new StudentDTO (s.dni, s.name, s.surname, s.genre, s.age)"+ 
		"FROM Student s"
		+ " WHERE s.genre LIKE ?1";
		Query query=this.em.createQuery(jpql);
		query.setParameter(1, genre);
		List<StudentDTO> results=query.getResultList();
		return results;
	}

	public Student saveStudent(Student s) {
		if (s.getDni() == null) {
			em.persist(s);
		} else {
			s = em.merge(s);
		}
		return s;
	}

}
