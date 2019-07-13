package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Changepassword extends HttpServlet 
{
	int accno;
	String password;
	String conpass;
	Model m;
	int row;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		password=request.getParameter("npass");
		HttpSession session= request.getSession();
		accno=(int)session.getAttribute("acc_no");
		m=new Model();
		m.setPassword(password);
		m.setAcc_no(accno);
		row=m.changpass();
		
		if(row!=0)
		{
			response.sendRedirect("/BANK/changepasssuc.html");	
		}
		else
		{
			response.sendRedirect("/BANK/changepassfail.html");
		}
	}

	

}
