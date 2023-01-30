package com.example.hibernate;

import com.example.hibernate.dto.MarkDto;
import com.example.hibernate.dto.StudentDto;
import com.example.hibernate.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class HibernateApplication {

  @Autowired
  private StudentService studentService;

  public static void main(String[] args) {
    SpringApplication.run(HibernateApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void start() {

    List<MarkDto> listMarkDto = new ArrayList<>();
    MarkDto computerScience = new MarkDto(1, "Сomputer science", "Very Good");
    MarkDto mathematics = new MarkDto(2, "Mathematics", "Satisfy");
    MarkDto history = new MarkDto(3, "History", "Satisfy");

    listMarkDto.add(computerScience);
    listMarkDto.add(mathematics);
    listMarkDto.add(history);

    StudentDto studentDto = new StudentDto(null, "Ruslan", "porubo@ukr.net", listMarkDto);

    studentService.createStudent(studentDto);

    log.info(String.valueOf(studentService.getAllStudents()));

    log.info(String.valueOf(studentService.getStudentById(1)));

    log.info(String.valueOf(studentService.entityChanges(studentDto)));

    studentService.deleteStudent(1);

  }

}
