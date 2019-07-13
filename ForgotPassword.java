package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class ForgotPassword extends HttpServlet
{
	String password;
	String email;
	int value;
	
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
	{
		password=request.getParameter("npass");
		Model m= new Model();
		m.setPassword(password);
		HttpSession session= request.getSession();
		email=(String)session.getAttribute("email");
		m.setEmail(email);
		
		value=m.forgotPassword();
		
		if(value==1)
		{
			System.out.println("Password Changed");
		}
		else
		{
		  System.out.println("Password not Changed");	
		}
	}
}