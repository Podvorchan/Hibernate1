package com.example.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 29.01.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

  private Integer id;
  private String discipline;
  private String value;

}
