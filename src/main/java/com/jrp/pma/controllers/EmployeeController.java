package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProjectService projectService;

	@GetMapping
	public String showEmployees(Model model) {

		List<Employee> employees = (List<Employee>) employeeService.getAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String showEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String showEmployeeForm(Model model, Employee employee) {

		employeeService.save(employee);
		return "redirect:/employees";
	}
}
