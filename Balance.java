package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Balance extends HttpServlet
{

	int accno;
	boolean value;
	int balance;
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		HttpSession session= request.getSession();
		accno=(int)session.getAttribute("acc_no");
		Model m= new Model();
		m.setAcc_no(accno);
		
		value=m.bal();
		balance=m.getBalance();
		session.setAttribute("balance", balance);
		
		if(value==true)
		{
			response.sendRedirect("/BANK/balance.jsp");
		}
		else
		{
              response.sendRedirect("/BANK/balancefail.html");			
              
		}
	}
}