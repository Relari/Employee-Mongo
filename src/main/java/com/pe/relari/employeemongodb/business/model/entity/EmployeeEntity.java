package com.pe.relari.employeemongodb.business.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "EMPLOYEE")
public class EmployeeEntity {

  @Id
  private String id;
  private String name;
  private String fatherLastName;
  private String motherLastName;
  private String position;
  private String sex;
  private Double salary;
  private Boolean isActive;
}
