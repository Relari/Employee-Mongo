package com.renzo.desarrrollo.api.employee.business.repository;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {

  Flux<Employee> findByCargoAndSexo(String cargo, String sexo);
}
