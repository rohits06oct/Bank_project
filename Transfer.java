package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Model;

public class Transfer extends HttpServlet 
{ 
	String rvc;
	String amt;
	int rvcno;
	int amount;
	int accno;
	boolean value;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		rvc=request.getParameter("rvcno");
		rvcno=Integer.parseInt(rvc);
		
		amt=request.getParameter("amount");
		amount=Integer.parseInt(amt);
		
		HttpSession session=request.getSession();
		accno=(int)session.getAttribute("acc_no");
		
		Model m=new Model();
		m.setAcc_no(accno);
		m.setRvcno(rvcno);
		m.setAmount(amount);
		
		value=m.trnsfer1();
		if(value==true)
		{
			m.statement1();
			value=m.transfer2();
		}
		else
		{
			response.sendRedirect("/BANK/transferfail.html");
		}
		if(value==true)
		{
			m.statement2();
			response.sendRedirect("/BANK/transfersucc.html");
		}
		else
		{
			response.sendRedirect("/BANK/transferfail.html");
		}
	}
}
