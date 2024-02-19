package com.jrp.pma.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

@Repository
@Profile("dev")
public class EmployeeRepository2 implements EmployeeRepository {

	@Override
	public List<Employee> findAll() {
		Employee emp1 = new Employee("", "", "");
		Employee emp2 = new Employee("", "", "");
		Employee emp3 = new Employee("", "", "");

		return Arrays.asList(emp1, emp2, emp3);
	}

	@Override
	public List<EmployeeProject> employeeProjectsWithCount() {
		EmployeeProject empProj = new EmployeeProject() {

			@Override
			public String getFirstName() {
				return "Mike";
			}

			@Override
			public String getLastName() {
				return "Mike";
			}

			@Override
			public int getProjectCount() {
				return 10;
			}
		};

		return Arrays.asList(empProj);
	}

	@Override
	public <S extends Employee> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Employee> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
