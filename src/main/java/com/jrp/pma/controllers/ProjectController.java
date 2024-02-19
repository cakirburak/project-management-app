package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("project", new Project());
		model.addAttribute("employees", employees);
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String saveProject(@RequestParam List<Long> employees, Model model, Project project) {

		projectService.save(project);
		// use redirect to prevent multiple submits
		return "redirect:/projects";
	}
}
