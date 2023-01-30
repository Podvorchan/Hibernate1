package com.example.hibernate.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 29.01.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

  private Integer id;
  private String name;
  private String email;
  private List<MarkDto> marks;

}
