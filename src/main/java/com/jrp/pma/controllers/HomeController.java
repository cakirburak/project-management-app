package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("")
	public String displayHome(Model model) {
		List<Project> projects =  (List<Project>) projectRepo.findAll();
		List<Employee> employees =  (List<Employee>) employeeRepo.findAll();
		
		model.addAttribute("projects",projects);
		model.addAttribute("employees",employees);
		return "home";
	}
}
