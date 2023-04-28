package com.banking3;
import java.util.Scanner;

public class Banking 
{		
 static Scanner sc = new Scanner(System.in);
	public static void main(String ab[])
	{
	TransferAmount a = new TransferAmount();
	
		while(true)
		{
			System.out.println("#####################");
			System.out.println("1. Add User ");
			System.out.println("2. View User ");
			System.out.println("3. Deposit ");
			System.out.println("4. Withdraw ");
			System.out.println("5. Transfer Amount");
			System.out.println("6. Exit");
			System.out.println("Enter Your Choice : ");
			int ch = sc.nextInt();
			switch(ch)
			{
			 case 1:
			   System.out.println("##Add User##");
			   a.addUser();
			   break;
			 case 2:
			   System.out.println("##View User##");
			   a.viewUser();
			   break;
			 case 3:
				   System.out.println("##Deposit##");
				   a.deposit();
				 break;
			 case 4:
				 System.out.println("##Withdraw##");
				   a.withdraw();
				 break;
			 case 5:
				 System.out.println("##Transfer Amount##");
				   a.transfer();
				 break;
			 case 6:
				   return;
			  default:
			   System.out.println("**Invalid Choice**");
			   break;
			}
		}
	}		
}
