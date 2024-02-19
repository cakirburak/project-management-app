package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;

	public Project save(Project project) {
		return projectRepo.save(project);
	}

	public List<Project> getAll() {
		return projectRepo.findAll();
	}

	public List<ChartData> getChartData() {
		return projectRepo.chartData();
	}

}
