package com.pe.relari.employeemongodb.business.service.impl;

import com.pe.relari.employeemongodb.business.dao.EmployeeDao;
import com.pe.relari.employeemongodb.business.model.domain.Employee;
import com.pe.relari.employeemongodb.business.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;

  @Override
  public Flux<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  public Flux<Employee> findByPositionAndSex(String position, String sex) {
    return employeeDao.findByPositionAndSex(position, sex);
  }

  @Override
  public Mono<Employee> findById(String id) {
    return employeeDao.findById(id);
  }

  @Override
  public Mono<Void> save(Employee employee) {
    return employeeDao.save(employee);
  }
}
