package com.cts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.cts.beans.User;
import com.cts.utilities.DBUtility;


public class UserDAO {
	
	public String getUserName(User u)
	{
	  Connection con=DBUtility.getConnection();	
	  PreparedStatement pstmt=null;
	  String queryString="select * from users101 where username=?";
	  ResultSet result=null;
	  String uName=null;
	  try
	  {
		 pstmt=con.prepareStatement(queryString);
		 System.out.println("Username "+u.getUsername());
		 pstmt.setString(1, u.getUsername().trim());
		 result=pstmt.executeQuery();
		 if(result.next())
		  uName=result.getString(2);
	  }
	  catch(SQLException sql)
	  {
		  sql.printStackTrace();
	  }
	  return uName;
	}
	public boolean addUser(User u)
	{
		Connection con=DBUtility.getConnection();
		String insertString="insert into users101 values (?,?,?,?,?,to_date(?,'dd-MON-yyyy'))";
		PreparedStatement pstmt=null;
		boolean valid=false;
		try
		{
			pstmt=con.prepareStatement(insertString);
			pstmt.setString(1, u.getFullName());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4,u.getGender());
			pstmt.setString(5, u.getEmail());
			System.out.println(new SimpleDateFormat("dd-MMM-yyyy"));
			pstmt.setString(6,  (new SimpleDateFormat("dd-MMM-yyyy")).format(u.getDob()));
			pstmt.executeUpdate();
			valid=true;
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		return valid;
	}

}
