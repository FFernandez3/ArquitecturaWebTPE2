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
		//this.em.getTransaction().begin();
		String jpql="SELECT new dto.StudentDTO (s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city) FROM Student s ORDER BY s.dni DESC";
		Query query=this.em.createQuery(jpql);
		List<StudentDTO> results=query.getResultList();
		results.forEach(r->System.out.println(r));
		//this.em.getTransaction().commit();
		//this.em.close();
		return results;
	}
	/*@Override
	public List<StudentDTO> getStudentByStudentId(long studentId) { //hecha con TypedQuery
		this.em.getTransaction().begin();
		String jpql="SELECT new dto.StudentDTO (s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city) FROM Student s WHERE s.studentId = :studentId";
		Query query=this.em.createQuery(jpql);
		query.setParameter("studentId", studentId);
		List<StudentDTO> results=query.getResultList();
		results.forEach(r->System.out.println(r));
		//this.em.getTransaction().commit();
	    this.em.close();
		return results;
	}*/
	@Override
	public StudentDTO getStudentByStudentId(long studentId) { //hecha con TypedQuery
		//this.em.getTransaction().begin();
		String jpql="SELECT new dto.StudentDTO (s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city) FROM Student s WHERE s.studentId = :studentId";
		Query query=this.em.createQuery(jpql);
		query.setParameter("studentId", studentId);
	    StudentDTO result = (StudentDTO)query.getSingleResult();
		//this.em.getTransaction().commit();
	    System.out.println(result);
	   // this.em.close();
		return result;
	}
	/*@Override
	public StudentDTO getStudentByStudentId(long studentId) { //hecha con TypedQuery
		this.em.getTransaction().begin();
		String jpql="SELECT new dto.StudentDTO (s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city) FROM Student s WHERE s.id = :studentId";
		TypedQuery<StudentDTO> typedQuery=this.em.createQuery(jpql, StudentDTO.class);
		typedQuery.setParameter("studentId", studentId);
	    StudentDTO result = (StudentDTO)typedQuery.getSingleResult();
		//this.em.getTransaction().commit();
	    this.em.close();
		return result;
	}*/

	@Override
	public List<StudentDTO> getAllStudentsByGenre(char genre) {
		//this.em.getTransaction().begin();
		String jpql="SELECT new dto.StudentDTO (s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city)"+ 
		"FROM Student s"
		+ " WHERE s.genre LIKE ?1";
		Query query=this.em.createQuery(jpql);
		query.setParameter(1, genre);
		List<StudentDTO> results=query.getResultList();
		
		results.forEach(r->System.out.println(r));
		//this.em.close();
		
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
