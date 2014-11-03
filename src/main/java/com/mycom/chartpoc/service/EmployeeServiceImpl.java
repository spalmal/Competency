package com.mycom.chartpoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mycom.chartpoc.entity.Employee;
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
	public List<EmployeeSkill> getEmployeSkills(int id)
			throws DataAccessException {
		@SuppressWarnings("unchecked")
		ArrayList<EmployeeSkill> skills = (ArrayList<EmployeeSkill>) employeeSkillDataRepository
				.	getSkillForMentees(id);

		return skills;
	}
	@Override
	public List<Employee> getMentorNames() throws DataAccessException {
		List<Employee> mentors = (ArrayList<Employee>) employeeDataRepository
				.getMentors();
		return mentors;
	}

	@Override
	public Map<Integer, String> getSkillSet() throws DataAccessException {
		logger.info("in skillset");
		// List<Object> skillSet = employeeSkillDataRepository.getSkillSets();
		// System.out.println(skillSet);
		return null;
	}

	@Override
	public List<EmployeeSkill> getEmployeSkills() throws DataAccessException {
		ArrayList<EmployeeSkill> skills = (ArrayList<EmployeeSkill>) employeeSkillDataRepository
				.findAll();
		return skills;
	}

	@Override
	public List<String> getMenteeName(int employeeId) {
		List<String> mentees = (List<String>) employeeDataRepository.getMentees(employeeId);
		System.out.println("Inside EmployeeServiceImpl "+mentees.size());
		return mentees  ;
	}

}
