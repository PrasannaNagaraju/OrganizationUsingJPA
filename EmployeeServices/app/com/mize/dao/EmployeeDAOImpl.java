package com.mize.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mize.dto.Employee;
import com.mize.mapper.EmployeeRowMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		//String sql = queries.getProperty("selectAll");
		String sql="select * from new_employees";

		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	

	@Override
	public Employee findById(Employee emp) {

		//String sql = queries.getProperty("selectById");
		String sql="select * from new_employees where empid=?";
		@SuppressWarnings("unchecked")
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				new Object[] { emp.getId() }, new EmployeeRowMapper());
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByDepartment(Employee emp) {

		//String sql = queries.getProperty("selectByDepartment");
		String sql="select * from new_employees where department=?";
		return jdbcTemplate.query(sql, new Object[] { emp.getDepartment() },
				new EmployeeRowMapper());
	}

	@Override
	public boolean insertEmployee(Employee employee) {

		//String sql = queries.getProperty("insert");
		String sql="insert into new_employees values(?,?,?,?,?)";
		int count = jdbcTemplate.update(
				sql,
				new Object[] { employee.getId(), employee.getName(),
						employee.getDepartment(), employee.getSalary(),
						employee.getJoinDate() });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		//String sql = queries.getProperty("updateEmployee");
		String sql="update new_employees set name=?,department=?,salary=?,joindate=? where empid=?";
		int count = jdbcTemplate.update(
				sql,
				new Object[] { employee.getName(), employee.getDepartment(),
						employee.getSalary(), employee.getJoinDate(),
						employee.getId() });
		if (count > 0) {
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteEmployeeById(Employee emp) {

		//String sql = queries.getProperty("deleteEmpById");
		String sql="delete from new_employees where empid=?";
		int count = jdbcTemplate.update(sql, new Object[] { emp.getId() });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getAverageSalary() {

		//String sql = queries.getProperty("getAvgSal");
		String sql="select avg(salary) from new_employees";
		@SuppressWarnings("deprecation")
		int value = jdbcTemplate.queryForInt(sql);
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAvgSalByDept() {

		//String sql = queries.getProperty("getAvgSalByDep");
		String sql="select department,avg(salary) from new_employees group by department";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
		
	}

	@SuppressWarnings("deprecation")
	public int employeeCount() {
		//String sql = queries.getProperty("getEmpCount");
		String sql="getEmpCount=select count(*) from new_employees";

		return jdbcTemplate.queryForInt(sql);
	}

}
