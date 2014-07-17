package com.mize.service;

import java.util.List;
import java.util.Map;

import com.mize.dto.Employee;

public interface EmployeeService {

	//public abstract void setEmployeeDAO(EmployeeDAOImpl employeeDAO);

	public abstract List<Employee> findAll();

	public abstract Employee findById(Employee emp);

	public abstract List<Employee> findByDepartment(Employee emp);

	public abstract boolean insertEmployee(Employee employee);

	public abstract boolean updateEmployee(Employee employee);

	public abstract boolean deleteEmployeeById(Employee emp);

	public abstract int getAverageSalary();

	public abstract List<Map<String, Object>> getAvgSalByDept();

	public abstract int empCount();

}