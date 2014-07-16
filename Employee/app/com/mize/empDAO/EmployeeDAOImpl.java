package com.mize.empDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mize.db.connection.DBConnection;
import com.mize.employee.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	String remove = "delete from emp where id=?";
	String query = "insert into emp(id,name,salary) values(?,?,?)";
	String getAllEmployees = "select * from emp ";
	String getEmployee = "select * from emp where id=?";
	String updateEmployee = "update emp set name=?,salary=? where id=?";

	@Override
	public boolean insertIntoemployees(Employee emp) {
		play.Logger.debug("Entered into Insertion ");
		Connection connection;
		PreparedStatement pstmt;
		int k;

		try {
			connection = DBConnection.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			k = pstmt.executeUpdate();

			if (k != 0) {
				return true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			play.Logger.error("INTERNAL Server Exception"+e.getMessage());
			
		}

		return false;

	}

	@Override
	public List<Employee> getAllEmployees() {
		play.Logger.debug("Entered into ListEmployees Operation..!");
		Statement statement;
		Connection connection;
		ResultSet resultset;

		List<Employee> list = new ArrayList<Employee>();
		try {
			connection = DBConnection.getconnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(getAllEmployees);
			Employee employee = null;
			while (resultset.next()) {
				employee = new Employee();
				employee.setId(resultset.getInt(1));
				employee.setName(resultset.getString(2));
				employee.setSalary(resultset.getDouble(3));

				list.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			play.Logger.error("INTERNAL Server Exception"+e.getMessage());
		}

		return list;

	}

	@Override
	public boolean removeFromEmpById(Employee emp) {
		play.Logger.debug("Entered into ListEmployees Operation..!");
		Connection connection;
		try {
			connection = DBConnection.getconnection();
			PreparedStatement pstmt = connection.prepareStatement(remove);
			pstmt.setInt(1, emp.getId());
			int s = pstmt.executeUpdate();

			if (s != 0)
				return true;
		} catch (ClassNotFoundException | SQLException e) {
			play.Logger.error("INTERNAL Server Exception"+e.getMessage());
		}
		return false;
	}

	@Override
	public Employee getEmployeeById(Employee emp) {
		play.Logger.debug("Entered into getEmployee Operation..!");

		try {

			Connection connection = DBConnection.getconnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from emp where id="
					+ emp.getId());
			Employee employee = new Employee();
			if (rs.next()) {

				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				return employee;
			}
		} catch (Exception e) {
			play.Logger.error("INTERNAL Server Exception"+e.getMessage());
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		play.Logger.debug("Entered into UpdateEmployees Operation..!");
		try {

			Connection connection = DBConnection.getconnection();
			PreparedStatement pstmt = connection
					.prepareStatement(updateEmployee);
			pstmt.setInt(3, emp.getId());
			pstmt.setString(1, emp.getName());
			pstmt.setDouble(2, emp.getSalary());
			int i = pstmt.executeUpdate();
			if (i > 0)
				return true;
		} catch (Exception e) {
			
			play.Logger.error("INTERNAL Server Exception"+e.getMessage());
		}
		return false;
	}

}
