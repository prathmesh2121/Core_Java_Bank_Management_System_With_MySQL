package com.banking3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class TransferAmount extends AmountWithdraw

{ 
	Scanner sc= new Scanner(System.in);
		int tamount;
		
		void transfer()
		{
			System.out.println("Enter account no. from where to transfer amount ");
			accNo = sc.nextInt();
			System.out.println("Enter Amount to be transferred : ");
			tamount = sc.nextInt();
			System.out.println("Enter account no. to transfer amount ");
			int accNo1 = sc.nextInt();
			try
			{	if ((tamount) >= 0 )
				{
					Connection con = DBConnect.getConnect();
					PreparedStatement ps3 = con.prepareStatement("update users set abal = abal - ? where acno=?");
					ps3.setInt(1, tamount);
					ps3.setInt(2, accNo);
					ps3.executeUpdate();
				
					PreparedStatement ps4 = con.prepareStatement("select abal,acno from users where acno=?");
					ps4.setInt(1, accNo);
					ResultSet rs = ps4.executeQuery();
					while(rs.next())
					{
						System.out.println("*****************************************");						
						System.out.println("Current Balance is "+rs.getInt("abal")+" From ac no. "+rs.getInt("acno"));
					}
					
				
					
			
					PreparedStatement ps5 = con.prepareStatement("update users set abal = abal + ? where acno=?");
					ps5.setInt(1, tamount);
					ps5.setInt(2, accNo1);
					ps5.executeUpdate();
				
					PreparedStatement ps6 = con.prepareStatement("select abal,acno from users where acno=?");
					ps6.setInt(1, accNo1);
					ResultSet r = ps6.executeQuery();
					while(r.next())
					{
						System.out.println("########################################");						
						System.out.println("Current Balance is "+r.getInt("abal")+" From ac no. "+r.getInt("acno"));
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
