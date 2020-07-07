package com.renzo.desarrrollo.api.employee.business.service;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

  Flux<Employee> findAll();

  Flux<Employee> findByCargoAndSexo(String cargo, String sexo);

  Mono<Employee> findById(int id);
}
