package com.mycom.chartpoc.repository.jpa.springdatajpa;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycom.chartpoc.entity.EmployeeSkill;

@Repository
public interface EmployeeDataRepository extends
		CrudRepository<EmployeeSkill, String> {
	
	@Query("SELECT e.employeeName FROM Employee e WHERE e.employeeType='mentor'")
	public List<String> getMentors();
	
	/*@Query("SELECT AVG(employeeSkillRating),s.skillName FROM EmployeeSkill es,Skill s WHERE es.skillId=s.skillId GROUP BY es.employeeSkillId")
	public Map<String,String> getSkillSets();*/
	
}
