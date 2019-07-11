package com.cts.bo;

import java.util.Date;

import com.cts.beans.User;
import com.cts.dao.UserDAO;

public class UserBO {
	UserDAO udao=null;
	
	public boolean addUser(String fullName,String userName,String password,String gender,String email,Date dob)
	{
		boolean valid=false;
		if(checkUser(fullName,userName,password,gender,email,dob))
		{
			udao=new UserDAO();
			User u=new User(fullName,userName,password,gender,email,dob);
			valid=udao.addUser(u);
		}
		return valid;
	}
	private boolean checkUser(String fullName,String userName,String password,String gender,String email,Date dob)
	{
		udao=new UserDAO();
		User u=new User(fullName,userName,password,gender,email,dob);
		String uName=udao.getUserName(u);
		if(uName==null)
			return true;
		else
			return false;
	}

}
