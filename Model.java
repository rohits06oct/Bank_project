package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	Connection con;
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	PreparedStatement pstmt;
	String name;
	String userid;
	String password;
	int acc_no;
	int balance;
	String email;
	ResultSet res;
    boolean value;
    String us="rohit";
    String pw="root";
    int row;
    int amount;
    int rvcno;
    ArrayList al1= new ArrayList();
    ArrayList al2= new ArrayList();
    int temp;
    String forgotPassword;
    
	public Model()
    {
    try 
	{
		DriverManager.registerDriver(new OracleDriver());
	    con=DriverManager.getConnection(url, us, pw);
	} 
	catch (Exception e) 
	{
	e.printStackTrace();	
	}
	}
    public void setName(String name) {
		this.name = name;
	}
    public void setRvcno(int rvcno)
    {
    	this.rvcno=rvcno;
    }
    public int getRvcno()
    {
    	return rvcno;
    }
    
    public void setAmount(int amount)
    {
    	this.amount=amount;
    }
    public int getAmount()
    {
    	return amount;
    }
    
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	
	public String getName() {
		return name;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public boolean login()
	{
		try 
		{
			pstmt=con.prepareStatement("SELECT * FROM BANK WHERE USERID  = ? AND PASSWORD = ?");
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			value=res.next();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(value==true)
		{
			try {
				acc_no=res.getInt("acc_no");
				name=res.getString(1);
				//balance=res.getInt(5);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return value;
	}
	public boolean bal()
	{
		try 
		{
			pstmt=con.prepareStatement("select * from bank where acc_no=?");
			pstmt.setInt(1, acc_no);
			res=pstmt.executeQuery();
			value=res.next();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(value==true)
		{
			try 
			{
				balance=res.getInt(5);
				System.out.println(balance);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return value;
		
	}
	
	public int changpass()
	{
		try 
		{
			pstmt=con.prepareStatement("update bank set password=? where acc_no=?");
			pstmt.setString(1, password);
			pstmt.setInt(2, acc_no);
			row=pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			System.out.println("error in model password");
		}
		return row;
	}
	
	public boolean trnsfer1()
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE-? WHERE ACC_NO=?");
			pstmt.setInt(1,amount);
			pstmt.setInt(2,acc_no);
			row=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(row!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean transfer2()
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE +? WHERE ACC_NO=?");
			pstmt.setInt(1,amount);
			pstmt.setInt(2,rvcno);
			row=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(row!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean transfer3()
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE+? WHERE ACC_NO=?");
			pstmt.setInt(1,amount);
			pstmt.setInt(2,acc_no);
			row=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(row!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void statement1()
	{
		try 
		{
		pstmt=con.prepareStatement("INSERT INTO STATEMENT(acc_no,debit) values(?,?)");
				pstmt.setInt(1, acc_no);
				pstmt.setInt(2, amount);
				pstmt.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void statement2()
	{
		try 
		{
		pstmt=con.prepareStatement("INSERT INTO STATEMENT(acc_no,credit) values(?,?)");
				pstmt.setInt(1, rvcno);
				pstmt.setInt(2, amount);
				pstmt.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList getStatement1()
	{
		try 
		{
		pstmt=con.prepareStatement("select debit from statement where acc_no=?");
				pstmt.setInt(1, acc_no);
				res=pstmt.executeQuery();
				
				while(res.next()==true)
				{
					temp=res.getInt("debit");
					al1.add(temp);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al1;
	}
	
	public ArrayList getStatement2()
	{
		try {
		pstmt=con.prepareStatement("select credit from statement where acc_no=?");
				pstmt.setInt(1, acc_no);
				res=pstmt.executeQuery();
				
				
				while(res.next()==true)
				{
					temp=res.getInt("credit");
					al2.add(temp);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al2;
	}
	
	public boolean loan()
	{
		try 
		{
			pstmt=con.prepareStatement("select * from bank where acc_no=?");
					pstmt.setInt(1,acc_no);
					res=pstmt.executeQuery();
					value=res.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(value==true)
		{
			try 
			{
				email=res.getString("e-mail");
				System.out.println(email);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return value;
	}
	
	public int forgotPassword()
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE E-MAIL=?");
			pstmt.setString(1,password);
			pstmt.setString(2,email);
			row=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(row!=0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
}
