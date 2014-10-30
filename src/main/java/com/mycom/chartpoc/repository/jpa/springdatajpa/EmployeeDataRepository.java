package com.mycom.chartpoc.repository.jpa.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mycom.chartpoc.entity.Employee;

public interface EmployeeDataRepository extends CrudRepository<Employee, Integer>{
	
	
	/**
	 * @return
	 * 	list of employees where employee type is mentor
	 */
	@Query("SELECT e FROM Employee e WHERE e.employeeType='mentor'")
	public List<Employee> getMentors();
	
	@Query("SELECT e.employeeFirstName FROM Employee e WHERE e.employeeId IN(SELECT m.menteeId FROM MentorMentee m WHERE m.mentorId=?1)")
	public List<String> getMentees(int id);
	
	@Query("SELECT e.employeeId FROM Employee e WHERE e.employeeFirstName = ?1")
	public int getEmployeeIdFromName(String name);
	
	//public List<Employee> findByNameContainingIgnoreCaseName(String name);
	
}
