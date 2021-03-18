package com.pe.relari.employeemongodb.business.model.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String fatherLastName;

  @NotBlank
  private String motherLastName;

  @NotBlank
  private String position;

  @NotBlank
  @Pattern(regexp = "(M|F)")
  private String sex;

  @NotNull
  private Double salary;

}
