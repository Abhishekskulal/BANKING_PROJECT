package com.bankingProject;

import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Bank> accounts = new ArrayList<>();
		boolean exit = false;
		
		while(!exit) {
			System.out.println("-------BANKING SYSTEM-------");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Show Account Details");
			System.out.println("5. Reset PIN");
			System.out.println("6. Transfer Money");
			System.out.println("7. Exit");
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter Account Holder Name: ");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.println("Select Bank SBI or HDFC: ");
				String bankType = scan.nextLine();
				Bank account = BankFactory.createBank(bankType, name);
				
				if(account != null) {
					accounts.add(account);
					System.out.println("Account Created Succesfully!");
					System.out.println("Your Account Number is: "+account.getAccountNumber());
					System.out.println("Your PIN is: "+account.getPin());
				} else {
					System.out.println("Invalid Bank Choice!");
				}
				break;
				
			case 2:
				System.out.println("Enter Account Number: ");
				int accNumDeposit = scan.nextInt();
				Bank accountForDeposit = findAccount(accounts,accNumDeposit);
				if(accountForDeposit != null) {
					System.out.println("Enter PIN: ");
					int pinDeposit = scan.nextInt();
					System.out.println("Enter Amount to Deposit: ");
					double depositAmount = scan.nextDouble();
					accountForDeposit.deposit(depositAmount, pinDeposit);
				} else {
					System.out.println("Account not found!");
				}
				break;
				
			case 3:
				System.out.println("Enter Account Number: ");
				int accNumWithdraw = scan.nextInt();
				Bank accForWithdraw = findAccount(accounts, accNumWithdraw);
				if(accForWithdraw != null) {
					System.out.println("Enter PIN: ");
					int pinWithdraw = scan.nextInt();
					System.out.println("Enter Amount to Withdraw: ");
					double withdrawAmount = scan.nextDouble();
					accForWithdraw.withdraw(withdrawAmount, pinWithdraw);
				} else {
					System.out.println("Account not found!");
				}
				break;
				
			case 4:
				System.out.println("Enter Account Number: ");
				int accNumShow = scan.nextInt();
				Bank accountForShow = findAccount(accounts, accNumShow);
				if(accountForShow != null) {
					System.out.println("Enter PIN: ");
					int pinShow = scan.nextInt();
					accountForShow.showAccountDetails(pinShow);
				} else {
					System.out.println("Account not found!");
				}
				break;
				
			case 5:
				System.out.println("Enter Account Number: ");
				int accNumReset = scan.nextInt();
				Bank accountForReset = findAccount(accounts, accNumReset);
				if(accountForReset != null) {
					System.out.println("Enter Old PIN: ");
					int oldPIN = scan.nextInt();
					System.out.println("Enter New PIN: ");
					int newPIN = scan.nextInt();
					accountForReset.resetPin(newPIN, oldPIN);
				} else {
					System.out.println("Account not found!");
				}
				break;
				
			case 6:
				System.out.println("Enter Your Account Number: ");
				int senderAccountNum = scan.nextInt();
				Bank sender = findAccount(accounts, senderAccountNum);
				
				if(sender != null) {
					System.out.println("Enter Your PIN: ");
					int senderPin = scan.nextInt();
					System.out.println("Enter Recipient's Account Number: ");
					int recipientAccountNum = scan.nextInt();
					Bank recipient = findAccount(accounts, recipientAccountNum);
					
					if(recipient != null) {
						System.out.println("Enter Amount to Transfer: ");
						double amount = scan.nextDouble();
						sender.transfer(recipient, amount, senderPin);
					} else {
						System.out.println("Recipient account not found!");
					}
				} else {
					System.out.println("Sender account not found!");
				}
				break;
				
			case 7:
				exit=true;
				System.out.println("Thank You for using the banking system!");
				break;
				
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		scan.close();
	}
	
	private static Bank findAccount(List<Bank> accounts, int accountNumber) {
		for(Bank account : accounts) {
			if(account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}
}