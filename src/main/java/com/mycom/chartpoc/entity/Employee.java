package com.mycom.chartpoc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private int employeeId;

	@Column(name="EMPLOYEE_FIRST_NAME")
	private String employeeFirstName;

	@Column(name="EMPLOYEE_LAST_NAME")
	private String employeeLastName;

	@Column(name="EMPLOYEE_TYPE")
	private String employeeType;

	//bi-directional many-to-one association to EmployeeSkill
	@OneToMany(mappedBy="employee")
	private List<EmployeeSkill> employeeSkills;

	//bi-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="mentor_mentee"
		, joinColumns={
			@JoinColumn(name="MENTEE_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="MENTOR_ID")
			}
		)
	private List<Employee> employees1;

	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="employees1")
	private List<Employee> employees2;

	public Employee() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return this.employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return this.employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeType() {
		return this.employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public List<EmployeeSkill> getEmployeeSkills() {
		return this.employeeSkills;
	}

	public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().add(employeeSkill);
		employeeSkill.setEmployee(this);

		return employeeSkill;
	}

	public EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().remove(employeeSkill);
		employeeSkill.setEmployee(null);

		return employeeSkill;
	}

	public List<Employee> getEmployees1() {
		return this.employees1;
	}

	public void setEmployees1(List<Employee> employees1) {
		this.employees1 = employees1;
	}

	public List<Employee> getEmployees2() {
		return this.employees2;
	}

	public void setEmployees2(List<Employee> employees2) {
		this.employees2 = employees2;
	}

}