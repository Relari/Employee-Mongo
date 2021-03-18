package com.pe.relari.employeemongodb.business.dao.repository;

import com.pe.relari.employeemongodb.business.model.entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<EmployeeEntity, String> {

  Flux<EmployeeEntity> findByPositionAndSex(String position, String sex);
}
