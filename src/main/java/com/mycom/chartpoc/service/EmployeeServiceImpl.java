package com.mycom.chartpoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mycom.chartpoc.entity.EmployeeSkill;
import com.mycom.chartpoc.repository.jpa.springdatajpa.EmployeeDataRepository;
import com.mycom.chartpoc.repository.jpa.springdatajpa.EmployeeSkillDataRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeServiceImpl.class);

	private EmployeeSkillDataRepository employeeSkillDataRepository;
	
	private EmployeeDataRepository employeeDataRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeSkillDataRepository datarepository,EmployeeDataRepository empDataRepo) {
		this.employeeSkillDataRepository = datarepository;
		this.employeeDataRepository = empDataRepo;
	}

	@Override
	public List<EmployeeSkill> getEmployeSkills(String name)
			throws DataAccessException {
		@SuppressWarnings("unchecked")
		int id = employeeDataRepository.getEmployeeIdFromName(name);
		ArrayList<EmployeeSkill> skills = (ArrayList<EmployeeSkill>) employeeSkillDataRepository
				.findAll(id);

		return skills;
	}

	@Override
	public List<String> getMentorNames() throws DataAccessException {
		List<String> mentors = (ArrayList<String>) employeeSkillDataRepository
				.getMentors();
		return mentors;
	}

	@Override
	public Map<String, String> getSkillSet() throws DataAccessException {
		logger.info("in skillset");
		// Map<String,String> skillSet = (HashMap<String,String>)
		// employeeDataRepository.getSkillSets();
		// System.out.println(skillSet);
		return null;
	}

	@Override
	public List<EmployeeSkill> getEmployeSkills() throws DataAccessException {
		ArrayList<EmployeeSkill> skills = (ArrayList<EmployeeSkill>) employeeSkillDataRepository
				.findAll();
		return skills;
	}

}
