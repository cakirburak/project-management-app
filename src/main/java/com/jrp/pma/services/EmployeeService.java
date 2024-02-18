package com.jrp.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.EmployeeRepository;

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
}
