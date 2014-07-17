package com.mize.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection=null;
//	private static InputStream input=null;
	//private static Properties properties=null;
	
	
	
	public static Connection getconnection() throws SQLException, ClassNotFoundException
	{
		if(connection==null)
		{
			String url="jdbc:mysql://23.23.109.69/training";
			String userId="fresh_training";
			String password="fresh_training123";
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url,userId,password);
			
		
		}
		
		return connection;
		
	}


	/*public static void loadproperties() {
		try
		{
			
		
		input=new FileInputStream("E:/TrainingOnJava/config.properties");
		properties=new Properties();
		properties.load(input);
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
