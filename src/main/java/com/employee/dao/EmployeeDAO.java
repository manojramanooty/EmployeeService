package com.employee.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.employee.datamodel.Employee;
import com.employee.datamodel.ResourceNotFoundException;

@Repository
@EntityScan("com.employee.datamodel")
@EnableJpaRepositories("com.employee.dao")
public class EmployeeDAO {
	
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAO.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee employee) {
		Employee empCreated = employeeRepository.save(employee);
		logger.info("Employee is created "+employee);
		return empCreated;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employeeList =  employeeRepository.findAll();
		logger.info("Get all employees is successful "+employeeList);
		return employeeList;
	}
	
	public Employee updateEmployee(Long id,Employee employee) {
		Optional<Employee> employeeFound = employeeRepository.findById(id);
		if(!employeeFound.isPresent()) {
			logger.error("Employee is not found for update ", id);
			throw new ResourceNotFoundException("ERR101", "Employee is not found for update", id);
		}
		employeeRepository.updateEmployee(employee.getName(), employee.getAge(), employee.getAddress(), employee.getEmail(), id);
		logger.info("Employee is updated "+employee);
		return employee;
	}

	public Employee getEmployee(Long id) {
		Optional<Employee> employeeFound = employeeRepository.findById(id);
		if(!employeeFound.isPresent()) {
			logger.error("Employee is not found with ", id);
			throw new ResourceNotFoundException("ERR101", "Employee is not found for given id", id);
		}
		logger.info("Get all employees is successful "+employeeFound.get());
		return employeeFound.get();
	}

	public Boolean deleteEmployee(Long id) {
		Optional<Employee> employeeFound = employeeRepository.findById(id);
		if(!employeeFound.isPresent()) {
			logger.error("Employee is not found for delete ", id);
			throw new ResourceNotFoundException("ERR101", "Employee is not found for given id", id);
		}
		employeeRepository.deleteById(id);
		logger.info("Delete employee is successful for id"+id);
		return true;
	}
	
	
}