package com.employee.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.datamodel.Employee;

@Repository
public  interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE Employee e set name =?1, age=?2, address=?3, email=?4 where e.id = ?5",
	            nativeQuery = true)
	void updateEmployee(String name, int age,String address, String email, Long userId);
}
