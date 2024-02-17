package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	public List<Project> findAll();

	@Query(nativeQuery = true, value = "SELECT P.stage as projectStage, COUNT(P.project_id) as pidCount FROM project P Group by P.stage")
	public List<ChartData> chartData();
}
