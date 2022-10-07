package com.saran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.model.Employee;
import com.saran.repo.EmployeeRepository;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmps() {
		 
		return (List<Employee>) repo.findAll();
	}

	@Override
	public void save(Employee emp) {
		repo.save(emp);
		
	}

	@Override
	public Employee getById(Integer id) {
		Optional<Employee> optional=repo.findById(id);
		Employee e=null;
		if(optional.isPresent()){
			e=optional.get();
		}else {
			throw new RuntimeException("Emp not found for id "+id);
		}
				
		
		return e;
	}

	@Override
	public void deleteEmpById(Integer id) {
		repo.deleteById(id);
	}

}
