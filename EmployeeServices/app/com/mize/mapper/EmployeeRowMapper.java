package com.mize.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class EmployeeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		// TODO Auto-generated method stub
		EmployeeResultSetExtractor extractor=new EmployeeResultSetExtractor();
		return extractor.extractData(rs);
		
	}
	

}
