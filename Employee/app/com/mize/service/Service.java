package com.mize.service;

import java.util.List;

import com.mize.employee.Employee;

public interface Service {
	
	public abstract boolean removeFromEmpById(Employee emp);

	public abstract List<Employee> getAllEmployees();

	public abstract Employee getEmployeeById(Employee emp);

	public abstract boolean insertIntoemployees(Employee emp);
	
	public abstract boolean updateEmployee(Employee emp);


}
