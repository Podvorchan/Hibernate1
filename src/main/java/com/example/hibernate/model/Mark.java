package com.example.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Podvorchan Ruslan 29.01.2023
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "my_university")
public class Mark {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String discipline;

  @Column
  private String value;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  @JsonIgnore
  private Student student;

}
