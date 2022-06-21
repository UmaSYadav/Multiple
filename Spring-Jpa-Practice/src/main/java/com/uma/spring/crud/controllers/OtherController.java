package com.uma.spring.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.spring.crud.dtos.Employee;
import com.uma.spring.crud.services.EmployeeServices;

@RestController
@RequestMapping("/employee1")
public class OtherController {

	@Autowired private EmployeeServices vEmployeeServices;

	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee pEmployee) {
		Employee vEmp= vEmployeeServices.addEmployee(pEmployee);
		return new ResponseEntity<Employee>(vEmp, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee pEmployee) {
		Employee vEmp= vEmployeeServices.addEmployee(pEmployee);
		return new ResponseEntity<Employee>(vEmp, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> vAllEmps= vEmployeeServices.getAllEmployees();
		return new ResponseEntity<>(vAllEmps, HttpStatus.OK);
	}

	@GetMapping("/getId/{id}")
	public ResponseEntity<?> getEmployeeNew(@PathVariable("id") Long pId) {
		Employee vEmps= vEmployeeServices.getEmployeeNew(pId);
		return new ResponseEntity<>(vEmps, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long pId) {
		vEmployeeServices.deleteEmployee(pId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
