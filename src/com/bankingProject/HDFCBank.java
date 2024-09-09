package com.bankingProject;

import java.util.Random;

public class HDFCBank implements Bank {
	private static int accountCounter = 101100; //To auto-generate account number
	private int accountNumber;
	private int pin;
	private double balance;
	private String accountHolderName;
	
	public HDFCBank(String accountHolderName) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = ++accountCounter;
		this.pin = generatePin(); //Auto-generate Pin
		this.balance = 0.0;
	}

	private int generatePin() {
		Random rand = new Random();
		return 1000 + rand.nextInt(9000);
	}
	
	@Override
	public void deposit(double amount, int enteredPin) {
		if(enteredPin == this.pin) {
			balance += amount;
			System.out.println("Amount deposited succesfully. Current balance: "+balance);
		} else {
			System.out.println("Invalid PIN. Deposit failed");
		}
	}
	
	@Override
	public void withdraw(double amount, int enteredPin) {
		if(enteredPin == this.pin) {
			if(balance >= amount) {
				balance -= amount;
				System.out.println("Withdraw succesful. Current balance: "+balance);
			} else {
				System.out.println("Insufficient balance.");
			}	
		} else {
			System.out.println("Invalid PIN. Withdrawal failed.");
		}
	}
	
	@Override
	public void showAccountDetails(int enteredPin) {
		if(enteredPin == this.pin) {
			System.out.println("SBI Bank Account Details:");
			System.out.println("Account Holder: "+ accountHolderName);
			System.out.println("Account Number: "+ accountNumber);
			System.out.println("Balance: "+balance);
		} else {
			System.out.println("Invalid PIN. Cannot display account details.");
		}
	}
	
	@Override
	public void resetPin(int newPin, int oldPin) {
		if (oldPin == this.pin) {
			this.pin = newPin;
			System.out.println("PIN reset succesful.");
		} else {
			System.out.println("Invalid old PIN. Reset failed.");
		}
	}
	
	@Override
	public void transfer(Bank recipient, double amount, int pin) {
		if(this.pin != pin) {
			System.out.println("Incorrect PIN!");
			return;
		}
		if(this.balance < amount) {
			System.out.println("Insufficient balance!");
			return;
		}
		this.balance-=amount;
		recipient.deposit(amount, recipient.getPin());
		System.out.println("Transfer succesful! Transferred "+amount+" to Account "+recipient.getAccountNumber());
	}
	
	@Override
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	@Override
	public int getPin() {
		return this.pin;
	}
}
