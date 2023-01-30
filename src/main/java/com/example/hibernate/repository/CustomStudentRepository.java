package com.example.hibernate.repository;

import com.example.hibernate.model.Student;
import java.util.List;

/**
 * @author Podvorchan Ruslan 29.01.2023
 */
public interface CustomStudentRepository {

  List<Student> getAllStudent();

  Student getStudentById(Integer id);

  void deleteStudent(Integer id);

  Student entityChanges(Student student);

}
