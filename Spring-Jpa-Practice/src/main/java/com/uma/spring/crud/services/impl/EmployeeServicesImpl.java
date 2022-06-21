package com.uma.spring.crud.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uma.spring.crud.cutomExceptions.BusinessException;
import com.uma.spring.crud.dtos.Employee;
import com.uma.spring.crud.repository.EmployeeRepository;
import com.uma.spring.crud.services.EmployeeServices;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired EmployeeRepository vEmployeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		try {
			List<Employee> vAllEmps= vEmployeeRepository.findAll();
			if(vAllEmps.isEmpty())
				throw new BusinessException("605", "No data available.");
			return vAllEmps;
		}
		catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service- "+e.getMessage());
		}
	}

	@Override
	public Employee getEmployee(Long pEmpId) {
		try {
			if(pEmpId == 0)
				throw new BusinessException("606", "to update, Id must be provided.");
			return vEmployeeRepository.findById(pEmpId).get();
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee is null.");
		}
		catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service- "+e.getMessage());
		}
	}

	@Override
	public Employee addEmployee(Employee pEmployee) {
		try {
			if(pEmployee.getName().isEmpty() || pEmployee.getName().length() == 0)
				throw new BusinessException("601", "Please send proper name.");
			if(pEmployee.getId() != 0)
				throw new BusinessException("604", "to add, Id must not be provided.");return vEmployeeRepository.save(pEmployee);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee is null.");
		}
		catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service- "+e.getMessage());
		}
	}

	@Override
	public Employee updateEmployee(Employee pEmployee) {
		try {
			if(pEmployee.getId() == 0)
				throw new BusinessException("606", "to update, Id must be provided.");
			if(pEmployee.getName().isEmpty() || pEmployee.getName().length() == 0)
				throw new BusinessException("601", "Please send proper name.");
			return vEmployeeRepository.save(pEmployee);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee is null.");
		}
		catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service- "+e.getMessage());
		}
	}

	@Override
	public void deleteEmployee(Long pEmpId) {
		try {
			if(pEmpId == 0)
				throw new BusinessException("606", "to update, Id must be provided.");
			vEmployeeRepository.deleteById(pEmpId);
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee is null.");
		}
		catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service- "+e.getMessage());
		}
	}
	
	@Override
	public Employee getEmployeeNew(Long pEmpId) {
		try {
			if(pEmpId == 0)
				throw new BusinessException("606", "to update, Id must be provided.");
			return vEmployeeRepository.findById(pEmpId).get();
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee is null.");
		}
		catch (Exception e) {
			throw e;
		}
	}
}
