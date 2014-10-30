package com.mycom.chartpoc.entity;
import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the employee_skill database table.
 * 
 */
@Entity
@Table(name="employee_skill")
@SqlResultSetMappings( {

@SqlResultSetMapping(name = "SkillRating", columns = { @ColumnResult(name = "AVG"),
    @ColumnResult(name = "Skill_Name") })

})
public class EmployeeSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeSkillPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DURATION")
	private Date endDuration;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DURATION")
	private Date startDuration;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID" , insertable=false, updatable=false)
	private Employee employee;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="SKILL_ID" , insertable=false, updatable=false)
	private Skill skill;
	
	@Column(name="EMPLOYEE_SKILL_RATING" , insertable=false, updatable=false)
	private int employeeSkillRating;
	
	@Column(name="EMPLOYEE_ID", insertable=false, updatable=false)
	private int employeeId;
	
	@Column(name="SKILL_ID", insertable=false, updatable=false)
	private int skillId;


	public EmployeeSkill() {
	}

	public EmployeeSkillPK getId() {
		return this.id;
	}

	public void setId(EmployeeSkillPK id) {
		this.id = id;
	}

	public Date getEndDuration() {
		return this.endDuration;
	}

	public void setEndDuration(Date endDuration) {
		this.endDuration = endDuration;
	}

	public Date getStartDuration() {
		return this.startDuration;
	}

	public void setStartDuration(Date startDuration) {
		this.startDuration = startDuration;
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

	public int getEmployeeSkillRating() {
		return employeeSkillRating;
	}

	public void setEmployeeSkillRating(int employeeSkillRating) {
		this.employeeSkillRating = employeeSkillRating;
	}
	
	public int getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSkillId() {
		return this.skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	
}