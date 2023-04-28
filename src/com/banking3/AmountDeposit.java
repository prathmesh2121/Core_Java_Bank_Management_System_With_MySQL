package com.banking3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.banking3.DBConnect;

public class AmountDeposit extends AccountDetails 
{	int amount;
	Scanner sc= new Scanner(System.in);


	
	void deposit()
	{  
		System.out.println("Enter account no ");
		accNo = sc.nextInt();
		System.out.println("Enter Amount to be deposit : ");
		amount = sc.nextInt();
		try
			
		{	if ((amount) >= 0 )
			{
			
			Connection con = DBConnect.getConnect();
			PreparedStatement ps3 = con.prepareStatement("update users set abal = abal + ? where acno=?");
			ps3.setInt(1, amount);
			ps3.setInt(2, accNo);
			ps3.executeUpdate();
		
			PreparedStatement ps4 = con.prepareStatement("select abal from users where acno=?");
			ps4.setInt(1, accNo);
			ResultSet rs = ps4.executeQuery();
			while(rs.next())
			{
				System.out.println("################################################");						
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
