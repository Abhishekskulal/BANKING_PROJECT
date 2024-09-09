package com.bankingProject;

public class BankFactory {
	public static Bank createBank(String bankType, String accountHolderName) {
		if(bankType.equalsIgnoreCase("SBI")){
			return new SBIBank(accountHolderName);
		} else if (bankType.equalsIgnoreCase("HDFC")) {
			return new HDFCBank(accountHolderName);
		} else {
			return null;
		}
    }
}