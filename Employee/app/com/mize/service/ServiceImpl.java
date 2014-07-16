package com.mize.service;

import java.util.List;

import com.mize.empDAO.EmployeeDAOImpl;
import com.mize.employee.Employee;

public class ServiceImpl implements Service{
	
	EmployeeDAOImpl employeeDAOImpl=new EmployeeDAOImpl();

	@Override
	public boolean removeFromEmpById(Employee emp) {
		return employeeDAOImpl.removeFromEmpById(emp);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDAOImpl.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(Employee emp) {
		
		return	employeeDAOImpl.getEmployeeById(emp);
		
	}

	@Override
	public boolean insertIntoemployees(Employee emp) {
		return employeeDAOImpl.insertIntoemployees(emp);
		
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		
		return employeeDAOImpl.updateEmployee(emp);
	}

	
	

}
