package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.datamodel.Employee;
import com.demo.service.EmployeeService;

@RestController
@ComponentScan(basePackages="com.demo.service")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getMessage")
	public String getMessage() {
		return "Helooo All";
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		logger.info("Create Employee called");
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));	
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		logger.info("Get All Employees called");
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") Long id){
		logger.info("Get Employee called for id "+id);
		return employeeService.getEmployee(id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
		logger.info("Update Employee called for id "+id);
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public Boolean deleteEmployee(@PathVariable("id") Long id){
		logger.info("Delete Employee called for id "+id);
		return employeeService.deleteEmployee(id);
	}
}
