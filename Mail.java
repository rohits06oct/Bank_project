package Controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SendMail")

public class Mail extends HttpServlet
{
	String email;
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
	{
		email=request.getParameter("email");
		HttpSession session1=request.getSession(true);
		session1.setAttribute("email", email);
		
		
		String fromEmail="rohits.06oct@gmail.com"; //sender's mail id.
		String pwd="9806453700";		//sender's mail pwd.
		String toEmail=email;  //reciever's mail id.

		String subject="DO NOT REPLY: Reset your password"; // mail subject line
		String msg1="Hi,How are you?";
		String msg="http://localhost:9898/BANK/"; //mail body

		//Creating Session Object
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
				return new PasswordAuthentication(fromEmail, pwd);
			}
		});

		try 
		{
			//Composing the Mail
			MimeMessage mesg = new MimeMessage(session);
			mesg.setFrom(new InternetAddress(fromEmail));
			mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			mesg.setSubject(subject);  
			mesg.setText(msg);  

			//Sending the Mail
			Transport.send(mesg);
			System.out.println("Mail Sent!!");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}