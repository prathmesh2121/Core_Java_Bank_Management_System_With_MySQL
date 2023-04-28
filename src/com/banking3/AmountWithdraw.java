package com.banking3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.banking3.DBConnect;

public class AmountWithdraw extends AmountDeposit
{

	int wamount;
	Scanner sc= new Scanner(System.in);
	 void withdraw()
		{
		 	System.out.println("Enter account no ");
			accNo = sc.nextInt();
			System.out.println("Enter amount to be withdraw");
			wamount = sc.nextInt();
		 			try
		 					
						{	if ((wamount) >= 0 )
							{
							
							Connection con = DBConnect.getConnect();
							PreparedStatement ps3 = con.prepareStatement("update users set abal = abal - ? where acno=?");
							ps3.setInt(1, wamount);
							ps3.setInt(2, accNo);
							ps3.executeUpdate();
						
							PreparedStatement ps4 = con.prepareStatement("select abal from users where acno=?");
							ps4.setInt(1, accNo);
							ResultSet rs = ps4.executeQuery();
							while(rs.next())
							{
								System.out.println("########################################");						
								System.out.println("Current Balance is "+rs.getInt("abal"));
							}
							}	
							else
							{
								 System.out.println("Transaction Failed");
							}
						}
					catch(Exception e)
						{
							e.printStackTrace();
						}
			} 
			
}
		

