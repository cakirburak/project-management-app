package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	ProjectService projectService;
	@Autowired
	EmployeeService employeeService;

//	@Autowired
//	Car car;

	@GetMapping
	public String displayHome(Model model) throws JsonProcessingException {

		List<Project> projects = (List<Project>) projectService.getAll();
		List<EmployeeProject> employeesWithCnt = (List<EmployeeProject>) employeeService.employeeProjects();

//		Map<String, Object> map = new HashMap<>();
		List<ChartData> projectData = projectService.getChartData();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);

		model.addAttribute("chartData", jsonString);
		model.addAttribute("projects", projects);
		model.addAttribute("employeesWithCnt", employeesWithCnt);
		return "main/home";
	}
}
