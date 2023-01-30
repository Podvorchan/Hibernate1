package com.example.hibernate.repository;

import com.example.hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 29.01.2023
 */
@Slf4j
@Repository
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public List<Student> getAllStudent() {

    log.info("call getAll");
    Query query = entityManager
        .createQuery("select s from Student s");
    return query.getResultList();
  }

  @Override
  @Transactional
  public Student getStudentById(Integer id) {
    log.info("call findById");
    Query query = entityManager
        .createQuery("select s from Student s where s.id = " + id);
    if (query == null) {
      throw new EntityNotFoundException("There is no Student with such ID!");
    }
    return (Student) query.getResultList().get(0);
  }

  @Override
  public void deleteStudent(Integer id) {
    Student student = getStudentById(id);
    if (student != null) {
      entityManager.remove(student);
    }
  }

  @Override
  public Student entityChanges(Student student) {
    Query query = entityManager.createQuery("update student : '" + student.getName()
        + "'");
    query.executeUpdate();
    return student;
  }
}

