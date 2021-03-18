package com.pe.relari.employeemongodb.business.dao.impl;

import com.pe.relari.employeemongodb.business.dao.EmployeeDao;
import com.pe.relari.employeemongodb.business.dao.repository.EmployeeRepository;
import com.pe.relari.employeemongodb.business.model.entity.EmployeeEntity;
import com.pe.relari.employeemongodb.business.model.domain.Employee;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
@AllArgsConstructor
class EmployeeDaoImpl implements EmployeeDao {

  private final EmployeeRepository employeeRepository;

  @Override
  public Mono<Void> save(Employee employee) {
    return Mono.fromCallable(() -> mapEmployeeEntity(employee))
            .flatMap(employeeRepository::save)
            .subscribeOn(Schedulers.immediate())
            .doOnSubscribe(subscription -> log.debug(""))
            .doOnSuccess(employeeEntity -> log.info(""))
            .thenEmpty(Mono::just);
  }

  @Override
  public Flux<Employee> findAll() {
    return employeeRepository.findAll()
            .map(this::mapEmployee)
            .subscribeOn(Schedulers.immediate());
  }

  @Override
  public Mono<Employee> findById(String id) {
    return employeeRepository.findById(id)
            .map(this::mapEmployee)
            .subscribeOn(Schedulers.immediate());
  }

  @Override
  public Flux<Employee> findByPositionAndSex(String position, String sex) {
    return employeeRepository.findByPositionAndSex(position, sex)
            .map(this::mapEmployee)
            .subscribeOn(Schedulers.immediate());
  }

  private EmployeeEntity mapEmployeeEntity(Employee employee) {
    return EmployeeEntity.builder()
            .id(UUID.randomUUID().toString())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .position(employee.getPosition())
            .name(employee.getName())
            .sex(employee.getSex())
            .salary(employee.getSalary())
            .isActive(employee.getIsActive())
            .build();
  }

  private Employee mapEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
            .id(employeeEntity.getId())
            .fatherLastName(employeeEntity.getFatherLastName())
            .motherLastName(employeeEntity.getMotherLastName())
            .position(employeeEntity.getPosition())
            .name(employeeEntity.getName())
            .sex(employeeEntity.getSex())
            .salary(employeeEntity.getSalary())
            .isActive(employeeEntity.getIsActive())
            .build();
  }

}
