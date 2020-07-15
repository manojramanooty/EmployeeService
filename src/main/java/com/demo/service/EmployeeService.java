package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDAO;
import com.demo.datamodel.Employee;

@Service
@ComponentScan(basePackages="com.demo.dao")
public class EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	public Employee createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);	
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}
	
	public Employee updateEmployee(Long id, Employee employee) {
		return employeeDAO.updateEmployee(id, employee);
	}

	public Employee getEmployee(Long id) {
		return employeeDAO.getEmployee(id);
	}

	public Boolean deleteEmployee(Long id) {
		return employeeDAO.deleteEmployee(id);
	}
}


