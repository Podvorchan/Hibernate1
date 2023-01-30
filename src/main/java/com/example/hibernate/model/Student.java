package com.example.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String name;

  @Column
  private String email;

  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
  private List<Mark> marks;

}
