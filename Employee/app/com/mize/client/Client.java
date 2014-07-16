package com.mize.client;

import java.sql.SQLException;

import com.mize.empDAO.EmployeeDAOImpl;

public class Client {
	
	/*EmployeeDAO employeeDAO=new EmployeeDAO();
	List<Employee> employeelist=null;
	
	public void displayAllEmployees() throws ClassNotFoundException, SQLException
	{
		System.out.println("Employee List is:");
		employeelist=employeeDAO.getAllEmployees();
		Iterator<Employee> iterator=employeelist.iterator();
		Employee employee=null;
		while(iterator.hasNext())
		{
			employee=iterator.next();
			
			displayEmployee(employee);
			
			
		}
	}
	public void insertEmployee(int id,String name,double salary) throws ClassNotFoundException, SQLException
	{
		System.out.println("WAIT Inserting Record Into DB....");
		employeeDAO.insertIntoemployees(id, name, salary);
	}
	
	public void displayEmployee(Employee employee) {
		
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		
	}
	public void closeConnection() throws SQLException
	{
		System.out.println("Connections are closing.....");
		employeeDAO.closeConnection();
		System.out.println("Connection are Closed....!");
	}
	public void removeEmployeeById(int id) throws ClassNotFoundException, SQLException
	{
		System.out.println();
		employeeDAO.removeFromEmpById(id);
	}*/

	public static void main(String s[]) throws ClassNotFoundException, SQLException
	{
		/*Client client=new Client();
		client.insertEmployee(101, "prasanna", 35000);
		client.insertEmployee(102, "kumar",10000);
		client.insertEmployee(103, "Ganesh",30000);
		client.insertEmployee(104, "ram",80000);
		client.insertEmployee(105, "Krish",90000);
	
		client.displayAllEmployees();
		client.removeEmployeeById(104);
		System.out.println("Updated list is....");
		client.displayAllEmployees();
		client.closeConnection();*/
		//System.out.println(new EmployeeDAOImpl().getEmployeeById(101));
		
		//new EmployeeDAOImpl().insertIntoemployees(200, "prasanna", 35000);
		
	}

}