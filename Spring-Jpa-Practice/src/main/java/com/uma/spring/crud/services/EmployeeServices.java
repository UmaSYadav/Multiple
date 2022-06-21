package com.uma.spring.crud.services;

import java.util.List;

import com.uma.spring.crud.dtos.Employee;

public interface EmployeeServices {

	public List<Employee> getAllEmployees();
	public Employee getEmployee(Long pEmpId);
	public Employee getEmployeeNew(Long pEmpId);
	public Employee addEmployee(Employee pEmployee);
	public Employee updateEmployee(Employee pEmployee);
	public void deleteEmployee(Long pEmpId);
}
