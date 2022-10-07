package com.saran.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saran.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
