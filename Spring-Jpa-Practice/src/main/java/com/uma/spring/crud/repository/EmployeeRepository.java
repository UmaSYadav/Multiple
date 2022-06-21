package com.uma.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uma.spring.crud.dtos.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	/*
	 * public List<Employee> getAllEmployee(); public Employee getEmployee(int
	 * pEmpId); public boolean addEmployee(Employee pEmployee); public boolean
	 * editEmployee(Employee pEmployee); public boolean deleteEmployee(int pEmpId);
	 */
	
	
}
