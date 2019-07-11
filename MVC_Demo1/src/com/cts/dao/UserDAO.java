package com.cts.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.bean.User;
import com.cts.utilities.DBUtility;

public class UserDAO {

	public static List<User>getUsers()
	{
		
		List userList=new ArrayList<User>();
		//Obtaining database connection
		
		Connection con=DBUtility.getConnection();
		String queryString="select * from users101";
		Statement stmt=null;
		ResultSet result=null;
		try
		{
			stmt=con.createStatement();
			result=stmt.executeQuery(queryString);
			//obtaining value of each row
			
			while(result.next())
			{
				String fullName=result.getString(1);
				String username=result.getString(2);
				String password=result.getString(3);
				String gender=result.getString(4);
				String email=result.getString(5);
				Date dob=result.getDate(6);
				
				User user=new User(fullName,username,password,gender,email,dob);
				
				userList.add(user);
				
				
			}
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		return userList;
		
	}
	
	
	
}
