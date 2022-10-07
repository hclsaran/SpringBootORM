package com.saran.service;

import java.util.List;

import com.saran.model.Employee;

public interface EmpService {
	
	List<Employee> getAllEmps();
	void save(Employee emp);
	Employee getById(Integer id);
	void deleteEmpById(Integer id);
	
	

}
