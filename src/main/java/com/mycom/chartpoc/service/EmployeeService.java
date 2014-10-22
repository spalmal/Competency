package com.mycom.chartpoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycom.chartpoc.entity.EmployeeSkill;

public interface EmployeeService {
	List<EmployeeSkill> getEmployeSkills() throws DataAccessException;
	
	List<String> getMentorNames() throws DataAccessException;

	Map<String, String> getSkillSet() throws DataAccessException;

	List<EmployeeSkill> getEmployeSkills(String name) throws DataAccessException;
	
	
}
