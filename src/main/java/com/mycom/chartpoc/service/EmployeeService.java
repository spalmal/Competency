package com.mycom.chartpoc.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycom.chartpoc.entity.Employee;
import com.mycom.chartpoc.entity.EmployeeSkill;

public interface EmployeeService {
	
	
	List<EmployeeSkill> getEmployeSkills() throws DataAccessException;
	
	List<String> getMenteeName(int employeeId) throws DataAccessException;
	
	List<Employee> getMentorNames() throws DataAccessException;

	Map<Integer, String> getSkillSet() throws DataAccessException;

	List<EmployeeSkill> getEmployeSkills(String name) throws DataAccessException;

	List<EmployeeSkill> getEmployeSkills(int id) throws DataAccessException;
	
	}
