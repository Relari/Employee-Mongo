package com.pe.relari.employeemongodb.business.dao;

import com.pe.relari.employeemongodb.business.model.domain.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeDao {

  Mono<Void> save(Employee employee);

  Flux<Employee> findAll();

  Mono<Employee> findById(String id);

  Flux<Employee> findByPositionAndSex(String position, String sex);
}
