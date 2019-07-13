package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class GetStatement extends HttpServlet 
{
    boolean val1;
    boolean val2;
	int accno;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session=request.getSession();
		accno=(int)session.getAttribute("acc_no");
		
		Model m= new Model();
		m.setAcc_no(accno);
		
		ArrayList al1=m.getStatement1();
		ArrayList al2=m.getStatement2();
		
		val1=al1.isEmpty();
		val2=al2.isEmpty();
		
		if((val1==false)&&(val2==false))
		{
			session.setAttribute("debit", al1);
			session.setAttribute("credit", al2);
			response.sendRedirect("/BANK/getStatement.jsp");
		}
		else
		{
			response.sendRedirect("/BANK/getStatementfail.html");
		}
		
		
	}
}
