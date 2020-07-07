package com.renzo.desarrrollo.api.employee.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;
import com.renzo.desarrrollo.api.employee.business.repository.EmployeeRepository;
import com.renzo.desarrrollo.api.employee.business.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Flux<Employee> findAll() {
    log.info("Starting EmployeeServiceImpl class findAll method");
    return employeeRepository.findAll()
        .doOnComplete(() -> log.info("Ending EmployeeServiceImpl class findAll method"));
  }

  @Override
  public Flux<Employee> findByCargoAndSexo(String cargo, String sexo) {
    log.info("Starting EmployeeServiceImpl class findByCargoAndSexo method");
    return employeeRepository.findByCargoAndSexo(cargo, sexo)
        .doOnComplete(() -> log.info("Ending EmployeeServiceImpl class findByCargoAndSexo method"));
  }

  @Override
  public Mono<Employee> findById(int id) {
    return employeeRepository.findById(id);
  }
}
