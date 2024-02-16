package com.jrp.pma.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	
	//@GeneratedValue(strategy=GenerationType.AUTO) This gives hybernate(JPA) to controll for generation. //
	// This(GenerationType.IDENTITY) makes database responsible for generation. If you want to seed application with a sql
	// you have to give controll to database over id generation to prevent occupying the same id for newly
	// created records
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long projectId;
	
	private String name;
	private String stage; // NOTSTARTED, COMPLETED, INPROGRESS
	private String description;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", joinColumns=@JoinColumn(name= "project_id"), inverseJoinColumns=@JoinColumn(name="employee_id"))
	private List<Employee> employees;
	
	public Project() {
		
	}
	
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
	
	
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	public void addEmployee(Employee emp) {
		if(this.employees == null) {
			this.employees = new ArrayList<>();
		}
		this.employees.add(emp);
	}

}
