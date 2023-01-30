package com.example.hibernate.repository;

import com.example.hibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Podvorchan Ruslan 29.01.2023
 */
public interface StudentRepository extends JpaRepository<Student, Integer>,
    CustomStudentRepository {

}
