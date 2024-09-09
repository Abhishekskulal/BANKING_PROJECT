package com.bankingProject;

public interface Bank {
	void deposit(double amount, int enteredpin);
	void withdraw(double amount, int enteredPin);
	void showAccountDetails(int enteredPin);
	void resetPin(int newPin, int oldPin);
	void transfer(Bank recipient, double amount, int pin);
	int getAccountNumber();
	int getPin();
}