package com.cts.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.bo.UserBO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName=request.getParameter("fullName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String strDob=request.getParameter("dob");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		Date dob=null;
		try
		{
			dob=sdf.parse(strDob);
		}
		catch(ParseException p)
		{
			p.printStackTrace();
		}
		RequestDispatcher rd=null;
		UserBO ubo=new UserBO();
		if(ubo.addUser(fullName, username, password, gender, email, dob))
		{
			rd=request.getRequestDispatcher("SuccessPage.jsp");
			request.setAttribute("fName", fullName);
			rd.forward(request, response);
		}
		else
			response.sendRedirect("ErrorPage.html");
			
	}

}
