package com.pe.relari.employeemongodb.business.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EmployeeResponse {

  private String id;
  private String name;
  private String fatherLastName;
  private String motherLastName;
  private String position;
  private String sex;
  private Double salary;

}
