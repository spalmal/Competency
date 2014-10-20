package com.mycom.chartpoc.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycom.chartpoc.entity.EmployeeSkill;

public interface EmployeeService {
	Collection<EmployeeSkill> getEmployeSkils() throws DataAccessException;
	
	List<String> getMentorNames() throws DataAccessException;

	Map<String, String> getSkillSet() throws DataAccessException;
	
	
}
