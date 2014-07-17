package com.mize.dao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mize.dto.Employee;
import com.mize.mapper.EmployeeRowMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	Properties queries;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		String sql = queries.getProperty("selectAll");

		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	public Properties getQueries() {
		return queries;
	}

	public void setQueries(Properties queries) {
		this.queries = queries;
	}

	@Override
	public Employee findById(Employee emp) {

		String sql = queries.getProperty("selectById");
		@SuppressWarnings("unchecked")
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				new Object[] { emp.getId() }, new EmployeeRowMapper());
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByDepartment(Employee emp) {

		String sql = queries.getProperty("selectByDepartment");
		return jdbcTemplate.query(sql, new Object[] { emp.getDepartment() },
				new EmployeeRowMapper());
	}

	@Override
	public boolean insertEmployee(Employee employee) {

		String sql = queries.getProperty("insert");
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

		String sql = queries.getProperty("updateEmployee");
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

		String sql = queries.getProperty("deleteEmpById");
		int count = jdbcTemplate.update(sql, new Object[] { emp.getId() });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getAverageSalary() {

		String sql = queries.getProperty("getAvgSal");
		@SuppressWarnings("deprecation")
		int value = jdbcTemplate.queryForInt(sql);
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAvgSalByDept() {

		String sql = queries.getProperty("getAvgSalByDep");
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
		
	}

	@SuppressWarnings("deprecation")
	public int employeeCount() {
		String sql = queries.getProperty("getEmpCount");

		return jdbcTemplate.queryForInt(sql);
	}

}
