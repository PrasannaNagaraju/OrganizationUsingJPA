package com.mize.empDAO;

import java.util.List;

import com.mize.employee.Employee;

public interface EmployeeDAO {

	public abstract boolean removeFromEmpById(Employee emp);

	public abstract List<Employee> getAllEmployees();

	public abstract Employee getEmployeeById(Employee emp);

	public abstract boolean insertIntoemployees(Employee emp);
	
	public abstract boolean updateEmployee(Employee emp);

}