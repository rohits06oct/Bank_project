package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Login extends HttpServlet
{
	String userid;
	String password;
	boolean val;
	Model m;
	int accno;
	String name;
	int balance;
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException	
  {
	userid=request.getParameter("userid");
	password=request.getParameter("password");
       m = new Model();
       m.setUserid(userid);
       m.setPassword(password);
       
	   val=m.login();
	   accno=m.getAcc_no();
	   name=m.getName();
	HttpSession session=request.getSession(true);
	session.setAttribute("acc_no",accno);
	session.setAttribute("name", name);
	if(val==true)
	{
		response.sendRedirect("/BANK/Home.jsp");
	}
	else
	{
		response.sendRedirect("/BANK/loginfailure.html");
	}
  }
}