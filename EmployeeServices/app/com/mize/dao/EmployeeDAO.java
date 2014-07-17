package com.mize.dao;

import java.util.List;
import java.util.Map;

import com.mize.dto.Employee;


public interface EmployeeDAO {
	List<Employee> findAll();
    Employee findById(Employee emp);
    List<Employee> findByDepartment(Employee emp);
    boolean insertEmployee(Employee employee);  //insert new Employee Record
    boolean updateEmployee(Employee employee);	//Update an Employee Existing record
    boolean deleteEmployeeById(Employee emp);	
    int getAverageSalary();
    List<Map<String, Object>> getAvgSalByDept();
	int employeeCount();

}


