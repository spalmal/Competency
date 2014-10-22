package com.mycom.chartpoc.repository.jpa.springdatajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mycom.chartpoc.entity.Employee;

public interface EmployeeDataRepository extends CrudRepository<Employee, Integer>{
	
	@Query("SELECT e.employeeId FROM Employee e WHERE e.employeeFirstName = ?1")
	public int getEmployeeIdFromName(String name);

}
