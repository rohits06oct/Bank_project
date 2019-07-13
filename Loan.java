package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Loan extends HttpServlet 
{
        int accno;
        boolean value;
        String email;
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			HttpSession session= request.getSession();
			accno=(int)session.getAttribute("acc_no");
			Model m= new Model();
			m.setAcc_no(accno);
			value=m.loan();
			
			email=m.getEmail();
			session.setAttribute("email", email);
			if(value==true)
			{
				response.sendRedirect("/BANK/loansucss.jsp");
			}
			else
			{
				response.sendRedirect("/BANK/loanfail.html");
			}
		
	    }

}
