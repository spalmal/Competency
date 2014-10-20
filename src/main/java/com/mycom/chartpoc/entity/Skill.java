package com.mycom.chartpoc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SKILL_ID")
	private String skillId;

	@Column(name="SKILL_NAME")
	private String skillName;

	//bi-directional many-to-one association to EmployeeSkill
	@OneToMany(mappedBy="skill")
	private List<EmployeeSkill> employeeSkills;

	public Skill() {
	}

	public String getSkillId() {
		return this.skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<EmployeeSkill> getEmployeeSkills() {
		return this.employeeSkills;
	}

	public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().add(employeeSkill);
		employeeSkill.setSkill(this);

		return employeeSkill;
	}

	public EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().remove(employeeSkill);
		employeeSkill.setSkill(null);

		return employeeSkill;
	}

}