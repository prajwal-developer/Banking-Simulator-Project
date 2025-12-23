package com.kodnest.java.Bank;
import java.util.ArrayList;
import java.util.Scanner;
public class Bank {
	
	
	private ArrayList<Account> accounts = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);
	
	public void start()
	{
		
		
		while(true)
		{
			System.out.println("\n=========Bank Menu=========");
			System.out.println("1. Craete Account: ");
			System.out.println("2. Deposite: ");
			System.out.println("3. WithDraw: ");
			System.out.println("4. Check Balance: ");
			System.out.println("5. Transfer Money: ");
			System.out.println("6. Transcation History: ");
			System.out.println("7. Exit: ");
			
			System.out.println("Enter Choice: ");
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1 -> createAccount();
			case 2 -> deposite();
			case 3-> withdraw();
			case 4 -> checkBalance();
			case 5->  transfer();
			case 6 -> transactionHistory();
			case 7 -> System.out.println("Thank you for using Bank! ");
			default -> System.out.println("Invalid Choice!");
				
			}
			 
		}
	}
            
	         public void createAccount()
	         {
	        	 System.out.println("Enter Name: ");
	        	 scan.nextLine();
	        	 String name = scan.nextLine();
	        	 
	        	 System.out.println("Enter Account No: ");
	        	 int accountNum = scan.nextInt();
	        	 
	        	 System.out.println("set 4 - digit pin");
	        	 int pin = scan.nextInt();
	        	 
	        	 System.out.println("Initial Deposite: ");
	        	 double balance = scan.nextDouble();
	        	 
	        	 
	        	 accounts.add(new Account (name, accountNum, pin, balance));
	        	 System.out.println("account craeted successfully: ");
	        	 
	         }
	         
	         private Account findAccount(int accNo)
	         {
	        	  for (Account acc:accounts)
	        	  {
	        		  if (acc.getAccountNum() == accNo)
	        		  {
	        			  return acc;
	        		  }
	        	  }
	        	  return null;
	         }
	         
	         private Account authenticate()
	         {
	        	 System.out.println("Enter Acc No: ");
	        	 int accNo = scan.nextInt();
	        	 Account acc = findAccount(accNo);
	        	 
	        	 if (acc == null)
	        	 {
	        		System.out.println("Account not found");
	        		return null;
	        	 }
	        	 
	        	 System.out.println("Enter PIN: ");
	        	 int pin = scan.nextInt();
	        	 
	        	 if (!acc.validatePin(pin))
	        	 {
	        		 System.out.println("Invalid PIN:  ");
	        		 return null;
	        	 }
	        	 return acc;
	         }
	         
	         private void deposite()
	         {
	        	 Account acc = authenticate();
	        	 
	        	 if (acc == null)
	        		 return;
	        	 
	        	 System.out.println("Enter Amount: ");
	        	 double amount = scan.nextDouble();
	        	 
	        	 if (amount <= 0)
	        	 {
	        		 System.out.println("Invalid Amount!");
	        		 return;
	        	 }
	        	 acc.deposite(amount);
	        	 System.out.println("Deposited successfully!");
	        	 
	         }
	         
	         
	         private void withdraw()
	         {
	        	 Account acc= authenticate();
	        	 
	        	 if (acc == null)
	        		 return;
	        	 
	        	 System.out.println("Enter Amount: ");
	        	 double amount = scan.nextDouble();
	        	 
	        	 if (amount <= 0 || !acc.withDraw(amount))
	        	 {
	        		 System.out.println("Insufficient balance || Invalid amount");
	        		 
	        	 }
	        	 else
	        	 {
	        		 System.out.println("Withdrawal succesfully!");
	        	 }
	         }
	         
	         private void checkBalance()
	         {
	        	 Account acc = authenticate();
	        	if (acc != null)
	        	{
	        		System.out.println("current balance: " + acc.getBalance());
	        	}
	         }
	         
	         private void transfer()
	         {
	        	 Account sender = authenticate();
	        	 
	        	 if (sender == null)
	        		 return;
	        	 
	        	 System.out.print("Enter receiver Acc No: ");
	        	 int recAccNo = scan.nextInt();
	        	 Account receiver = findAccount(recAccNo);
	        	 
	        	 if (receiver == null) 
	        	 {
	        		 System.out.println("Receiver not found!");
	        		 return;
	        		
	        	 }	 
	         
 
	         System.out.println("Enter amount: ");
	         double amount = scan.nextDouble();
	         
	         if(amount <= 0 || sender.getBalance() < amount)
	         {
	        	System.out.println("Invalid or Insufficient balance!");
	        	return;
	         }
	        	 
	         
	         sender.transfer(receiver, amount);
	         System.out.println("Transfered successfully!");
	         
	         
	         }
	         
             public void transactionHistory()
             {
            	 Account acc = authenticate();
            	 
            	 if (acc != null)
            		 acc.printTransactions();
             }
}
