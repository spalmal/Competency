package com.mycom.chartpoc.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the employee_skill database table.
 * 
 */
@Embeddable
public class EmployeeSkillPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EMPLOYEE_ID", insertable=false, updatable=false)
	private int employeeId;

	@Column(name="SKILL_ID", insertable=false, updatable=false)
	private int skillId;

	@Column(name="EMPLOYEE_SKILL_RATING", insertable=false, updatable=false)
	private int employeeSkillRating;

	public EmployeeSkillPK() {
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
	public int getEmployeeSkillRating() {
		return this.employeeSkillRating;
	}
	public void setEmployeeSkillRating(int employeeSkillRating) {
		this.employeeSkillRating = employeeSkillRating;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeeSkillPK)) {
			return false;
		}
		EmployeeSkillPK castOther = (EmployeeSkillPK)other;
		return 
			(this.employeeId == castOther.employeeId)
			&& (this.skillId == castOther.skillId)
			&& (this.employeeSkillRating == castOther.employeeSkillRating);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.employeeId;
		hash = hash * prime + this.skillId;
		hash = hash * prime + this.employeeSkillRating;
		
		return hash;
	}
}