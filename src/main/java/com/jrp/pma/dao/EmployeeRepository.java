package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	public List<Employee> findAll();

	@Query(nativeQuery = true, value = "SELECT E.first_name as firstName, E.last_name as lastName, COUNT(PE.employee_id) as projectCount FROM employee E LEFT JOIN project_employee PE ON PE.employee_id = E.employee_id GROUP BY E.first_name, E.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjectsWithCount();
}
