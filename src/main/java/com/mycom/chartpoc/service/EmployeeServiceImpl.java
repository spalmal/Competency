package com.mycom.chartpoc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mycom.chartpoc.HomeController;
import com.mycom.chartpoc.entity.EmployeeSkill;
import com.mycom.chartpoc.repository.jpa.springdatajpa.EmployeeDataRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeServiceImpl.class);

	private EmployeeDataRepository employeeDataRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeDataRepository datarepository) {
		this.employeeDataRepository = datarepository;
	}

	@Override
	public List<EmployeeSkill> getEmployeSkils() throws DataAccessException {
		@SuppressWarnings("unchecked")
		ArrayList<EmployeeSkill> skills = (ArrayList<EmployeeSkill>) employeeDataRepository
				.findAll();

		return skills;
	}

	@Override
	public List<String> getMentorNames() throws DataAccessException {
	List<String> mentors = (ArrayList<String>) employeeDataRepository.getMentors();
	return mentors;
	}
	
	@Override
	public 	Map<String,String> getSkillSet() throws DataAccessException {
		logger.info("in skillset");
	//Map<String,String> skillSet = (HashMap<String,String>) employeeDataRepository.getSkillSets();
	//System.out.println(skillSet);
	return null;
	}
}
