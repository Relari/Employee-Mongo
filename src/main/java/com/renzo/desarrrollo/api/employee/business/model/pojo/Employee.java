package com.renzo.desarrrollo.api.employee.business.model.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "employee")
public class Employee {

  @Id
  private Integer id;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String cargo;
  private String sexo;
  private Double sueldo;

}
