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
public class Employee {

	//@GeneratedValue(strategy=GenerationType.AUTO) This gives hybernate(JPA) to controll for generation. //
	// This(GenerationType.IDENTITY) makes database responsible for generation. If you want to seed application with a sql
	// you have to give controll to database over id generation to prevent occupying the same id for newly
	// created records
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeId;
	
	private String firstName;
	private String lastName;
	private String email;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", joinColumns=@JoinColumn(name= "employee_id"), inverseJoinColumns=@JoinColumn(name="project_id"))
	private List<Project> projects;
	

	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addProject(Project peoject) {
		if(this.projects == null) {
			this.projects = new ArrayList<>();
		}
		this.projects.add(peoject);
	}
}
