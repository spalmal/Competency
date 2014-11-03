package com.mycom.chartpoc.repository.jpa.springdatajpa;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycom.chartpoc.entity.EmployeeSkill;

@Repository
public interface EmployeeSkillDataRepository extends
		CrudRepository<EmployeeSkill, String> {
		
	@Query("SELECT e FROM EmployeeSkill e where e.employeeId = ?1")
	public List<EmployeeSkill> findAll(int employeeId);
	
	/*@Query("SELECT AVG(employeeSkillRating),s.skillName FROM EmployeeSkill es,Skill s WHERE es.skillId=s.skillId GROUP BY s.skillId")
	public List<Object> getSkillSets();*/
	
	@Query("SELECT e FROM EmployeeSkill e WHERE e.employeeId IN(SELECT m.menteeId FROM MentorMentee m WHERE m.mentorId=?1)")
	public List<EmployeeSkill> getSkillForMentees(int id);
		
}
