package com.pe.relari.employeemongodb.business.service;

import com.pe.relari.employeemongodb.business.model.domain.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

  Flux<Employee> findAll();

  Flux<Employee> findByPositionAndSex(String cargo, String sexo);

  Mono<Employee> findById(String id);

  Mono<Void> save(Employee employee);
}
