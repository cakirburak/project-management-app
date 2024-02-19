package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

@Service
public class EmployeeService {

	// Field Injection
	@Autowired
	EmployeeRepository employeeRepo;

//	// Constructor Injection, injection takes places bc EmployeeController has @Service, no need @Autowired
//	public EmployeeService(EmployeeRepository employeeRepo) {
//		this.super();
//		this.employeeRepo = employeeRepo;
//	}

//	// Setter Injection, injection takes places bc EmployeeController has @Controller
//	@Autowired
//	public void SetEmployeeRepo(EmployeeRepository employeeRepo) {
//		this.employeeRepo = employeeRepo;
//	}

	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}

	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	public List<EmployeeProject> employeeProjects() {
		return employeeRepo.employeeProjectsWithCount();
	}
}
