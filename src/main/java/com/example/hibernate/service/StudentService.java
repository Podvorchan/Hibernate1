package com.example.hibernate.service;

import com.example.hibernate.dto.StudentDto;
import com.example.hibernate.model.Mark;
import com.example.hibernate.model.Student;
import com.example.hibernate.repository.MarkRepository;
import com.example.hibernate.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 29.01.2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

  private final StudentRepository studentRepository;
  private final ObjectMapper objectMapper;
  private final MarkRepository markRepository;

  public StudentDto createStudent(StudentDto studentDto) {
    Student student = objectMapper.convertValue(studentDto, Student.class);
    studentRepository.save(student);
    studentDto.setId(student.getId());
    List<Mark> marks = studentDto.getMarks().stream()
        .map(p -> objectMapper.convertValue(p, Mark.class)).toList();
    for (Mark m : marks) {
      m.setStudent(student);
      markRepository.save(m);
    }

    student.setMarks(marks);

    return studentDto;
  }

  public List<StudentDto> getAllStudents() {
    return studentRepository.getAllStudent().stream()
        .map(p -> objectMapper.convertValue(p, StudentDto.class)).toList();
  }

  public StudentDto getStudentById(int id) {
    Student studentById = studentRepository.getStudentById(id);
    if (studentById != null) {
      return objectMapper.convertValue(studentById, StudentDto.class);
    } else {
      return null;
    }
  }


  public void deleteStudent(Integer id) {
    studentRepository.deleteStudent(id);

  }

  public StudentDto entityChanges(StudentDto studentDto) {
    Student student = objectMapper.convertValue(studentDto, Student.class);
    return objectMapper.convertValue(studentRepository.entityChanges(student), StudentDto.class);
  }


}



