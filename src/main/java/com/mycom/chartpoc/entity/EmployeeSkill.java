package com.mycom.chartpoc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Slice;

/**
 * The persistent class for the employee_skill database table.
 * 
 */
@Entity
@Table(name = "employee_skill")
@NamedQuery(name = "EmployeeSkill.findAll", query = "SELECT e FROM EmployeeSkill e")
public class EmployeeSkill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_SKILL_ID")
	private String employeeSkillId;

	@Column(name = "EMPLOYEE_SKILL_RATING")
	private int employeeSkillRating;

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	// bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name = "SKILL_ID")
	private Skill skill;

	public String getEmployeeSkillId() {
		return this.employeeSkillId;
	}

	public void setEmployeeSkillId(String employeeSkillId) {
		this.employeeSkillId = employeeSkillId;
	}

	public int getEmployeeSkillRating() {
		return this.employeeSkillRating;
	}

	public void setEmployeeSkillRating(int employeeSkillRating) {
		this.employeeSkillRating = employeeSkillRating;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}