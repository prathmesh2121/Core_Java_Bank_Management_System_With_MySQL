package com.banking3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.banking3.DBConnect;

public class AccountDetails {

	Scanner sc = new Scanner(System.in);
	int accNo;
	String name;
	String mob;
	int balance;
	void addUser()
	{
		System.out.println("Enter User Ac No : ");
		accNo = sc.nextInt();
		
		System.out.println("Enter User Name : ");
		name = sc.next();
		
		System.out.println("Enter User Contact : ");
		mob = sc.next();
		
		System.out.println("Enter User balance : ");
		balance = sc.nextInt();	
	
	
	try	{
		Connection con = DBConnect.getConnect();
		PreparedStatement ps1 = con.prepareStatement("insert into users values (?,?,?,?)");
		ps1.setInt(1, accNo);
		ps1.setString(2, name);
		ps1.setString(3, mob);
		ps1.setInt(4, balance);
		int i =ps1.executeUpdate();
		if (i>0)
			System.out.println("Succesfully inserted");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void viewUser()
	{
		System.out.println("Enter account no ");
		accNo = sc.nextInt();
		Connection con = DBConnect.getConnect();
		try{
		PreparedStatement ps2 = con.prepareStatement("Select * from users where acno=?");
		ps2.setInt(1, accNo);
		ResultSet rs = ps2.executeQuery();
		while(rs.next())
		{
			System.out.println("##########################################");
			System.out.println("Account no. is "+rs.getInt(1));
			System.out.println("Account Holder Names is "+rs.getString(2));
			System.out.println("Account Contact is "+rs.getString(3));
			System.out.println("Balance is "+rs.getInt(4));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	}
