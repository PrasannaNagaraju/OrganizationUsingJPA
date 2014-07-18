package com.mize.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mize.dao.EmployeeDAO;
import com.mize.dto.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public List<Employee> findAll() {

		return employeeDAO.findAll();

	}

	@Override
	public Employee findById(Employee emp) {

		return employeeDAO.findById(emp);
	}

	@Override
	public List<Employee> findByDepartment(Employee emp) {

		return employeeDAO.findByDepartment(emp);
	}

	@Override
	public boolean insertEmployee(Employee employee) {

		return employeeDAO.insertEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployeeById(Employee emp) {

		return employeeDAO.deleteEmployeeById(emp);
	}

	@Override
	public int getAverageSalary() {

		return employeeDAO.getAverageSalary();
	}

	@Override
	public List<Map<String, Object>> getAvgSalByDept() {

		return employeeDAO.getAvgSalByDept();
	}

	@Override
	public int empCount() {
		return employeeDAO.employeeCount();

	}

}
