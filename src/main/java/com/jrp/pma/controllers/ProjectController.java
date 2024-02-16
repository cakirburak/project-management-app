package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("project", new Project());
		model.addAttribute("employees", employees);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String saveProject(@RequestParam List<Long> employees, Model model, Project project) {
		
		projectRepo.save(project);
		// use redirect to prevent multiple submits
		return "redirect:/projects";
	}
}
