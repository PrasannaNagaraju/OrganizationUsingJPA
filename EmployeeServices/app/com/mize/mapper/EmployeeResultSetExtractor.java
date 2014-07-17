package com.mize.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mize.dto.Employee;


@SuppressWarnings("rawtypes")
public class EmployeeResultSetExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setDepartment(rs.getString(3));
		employee.setSalary(rs.getInt(4));
		employee.setJoinDate(rs.getString(5));
		return employee;
	}

}
