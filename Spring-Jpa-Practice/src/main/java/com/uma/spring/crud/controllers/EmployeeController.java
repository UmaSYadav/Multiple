package com.uma.spring.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.spring.crud.cutomExceptions.BusinessException;
import com.uma.spring.crud.cutomExceptions.ControllerException;
import com.uma.spring.crud.dtos.Employee;
import com.uma.spring.crud.services.EmployeeServices;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired private EmployeeServices vEmployeeServices;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee pEmployee) {
		try {
			if(pEmployee.getName().isEmpty() || pEmployee.getName().length() == 0)
				throw new ControllerException("601", "Please send proper name.");
			if(pEmployee.getId() != 0)
				throw new ControllerException("604", "to add, Id must not be provided.");
			Employee vEmp= vEmployeeServices.addEmployee(pEmployee);
			return new ResponseEntity<Employee>(vEmp, HttpStatus.CREATED);
		}
		catch(BusinessException e) {
			ControllerException vControllerException= new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(vControllerException, HttpStatus.BAD_REQUEST);
		}
		catch(ControllerException e) {
			return new ResponseEntity<ControllerException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee pEmployee) {
		try {
			if(pEmployee.getName().isEmpty() || pEmployee.getName().length() == 0)
				throw new ControllerException("601", "Please send proper name.");
			if(pEmployee.getId()== 0)
				throw new ControllerException("604", "to add, Id must be provided.");
			Employee vEmp= vEmployeeServices.addEmployee(pEmployee);
			return new ResponseEntity<Employee>(vEmp, HttpStatus.CREATED);
		}
		catch (BusinessException e) {
			ControllerException vControllerException= new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(vControllerException, HttpStatus.BAD_REQUEST);
		}
		catch (ControllerException e) {
			return new ResponseEntity<ControllerException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllEmployees() {
		try {
			List<Employee> vAllEmps= vEmployeeServices.getAllEmployees();
			if(vAllEmps.isEmpty())
				throw new ControllerException("605", "No data available.");
			return new ResponseEntity<>(vAllEmps, HttpStatus.OK);
		}
		catch (BusinessException e) {
			ControllerException vControllerException= new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(vControllerException, HttpStatus.BAD_REQUEST);
		}
		catch (ControllerException e) {
			return new ResponseEntity<ControllerException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getId/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long pId) {
		try {
			if(pId == 0)
				throw new ControllerException("606", "to update, Id must be provided.");
			Employee vEmps= vEmployeeServices.getEmployee(pId);
			return new ResponseEntity<>(vEmps, HttpStatus.OK);
		}
		catch (BusinessException e) {
			System.out.println("1. "+e.getErrorCode());
			ControllerException vControllerException= new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(vControllerException, HttpStatus.BAD_REQUEST);
		}
		catch (ControllerException e) {
			System.out.println("2. "+e.getErrorCode());
			return new ResponseEntity<ControllerException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long pId) {
		try {
			if(pId == 0)
				throw new ControllerException("606", "to update, Id must be provided.");
			vEmployeeServices.deleteEmployee(pId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (BusinessException e) {
			ControllerException vControllerException= new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(vControllerException, HttpStatus.BAD_REQUEST);
		}
		catch (ControllerException e) {
			return new ResponseEntity<ControllerException>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
