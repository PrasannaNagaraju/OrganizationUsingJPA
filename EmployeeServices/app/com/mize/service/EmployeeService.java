package com.mize.service;

import java.util.List;
import java.util.Map;

import com.mize.dto.Employee;

public interface EmployeeService {

	//public void setEmployeeDAO(EmployeeDAOImpl employeeDAO);

	public List<Employee> findAll();

	public Employee findById(Employee emp);

	public List<Employee> findByDepartment(Employee emp);

	public boolean insertEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployeeById(Employee emp);

	public int getAverageSalary();

	public List<Map<String, Object>> getAvgSalByDept();

	public int empCount();

}