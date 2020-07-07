package com.renzo.desarrrollo.api.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;
import com.renzo.desarrrollo.api.employee.business.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/business/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public Flux<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping(path = "/find")
  public Flux<Employee> findByCargoAndSexo(@RequestParam(value = "cargo") String cargo,
      @RequestParam(value = "sexo") String sexo) {
    return employeeService.findByCargoAndSexo(cargo, sexo);
  }

  @GetMapping(path = "/{id}")
  public Mono<Employee> findById(@PathVariable(value = "id") int id) {
    return employeeService.findById(id);
  }
}
