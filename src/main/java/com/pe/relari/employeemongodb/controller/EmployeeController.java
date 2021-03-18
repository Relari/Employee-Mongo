package com.pe.relari.employeemongodb.controller;

import com.pe.relari.employeemongodb.business.model.api.EmployeeRequest;
import com.pe.relari.employeemongodb.business.model.api.EmployeeResponse;
import com.pe.relari.employeemongodb.business.model.domain.Employee;
import com.pe.relari.employeemongodb.business.service.EmployeeService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping
  public Flux<EmployeeResponse> findAll() {
    return employeeService.findAll()
            .map(this::mapEmployeeResponse);
  }

  private EmployeeResponse mapEmployeeResponse(Employee employee) {
    return EmployeeResponse.builder()
            .id(employee.getId())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .position(employee.getPosition())
            .name(employee.getName())
            .sex(employee.getSex())
            .salary(employee.getSalary())
            .build();
  }

  @GetMapping(path = "/find")
  public Flux<EmployeeResponse> findByPositionAndSex(
          @RequestParam(value = "position") String position,
          @RequestParam(value = "sex") String sex) {
    return employeeService.findByPositionAndSex(position, sex)
            .map(this::mapEmployeeResponse);
  }

  @GetMapping(path = "/{id}")
  public Mono<EmployeeResponse> findById(
          @PathVariable(value = "id") UUID id) {
    return employeeService.findById(id.toString())
            .map(this::mapEmployeeResponse);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public Mono<Void> save(@RequestBody EmployeeRequest employeeRequest) {
    return Mono.fromCallable(() -> mapEmployee(employeeRequest))
            .flatMap(employeeService::save);
  }

  private Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .fatherLastName(employeeRequest.getFatherLastName())
            .motherLastName(employeeRequest.getMotherLastName())
            .position(employeeRequest.getPosition())
            .name(employeeRequest.getName())
            .sex(employeeRequest.getSex())
            .salary(employeeRequest.getSalary())
            .isActive(Boolean.TRUE)
            .build();
  }
}
