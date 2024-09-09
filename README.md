Banking Project in Java
=======================
Project Overview
''''''''''''''''
This project simulates a simple banking system where users can create accounts in two types of banks: SBI and HDFC. The project incorporates essential banking functionalities like account number and pin generation, deposit, withdrawal, pin reset, and validation. Additionally, it demonstrates the use of Java concepts such as interfaces, factory methods, generics, and switch-case statements.

Features
--------
Account Number and Pin Generation: Automatically generate unique account numbers and pins for each customer.
Deposit & Withdrawal: Manage basic transactions like depositing and withdrawing money.
Pin Reset: Securely reset the pin after validation.
Validation: Validate user credentials and account numbers before performing transactions.
Switch-Case Control: Easily navigate through different operations using a switch-case structure in the main method.
Factory Method: Utilize factory design patterns to manage object creation for SBI and HDFC banks.
Generics in Main Method: Demonstrates the use of generics to handle multiple data types and operations efficiently.
Classes and Interfaces
Bank (Interface): The blueprint for all bank operations such as deposit, withdraw, pin reset, and validation.
SBI (Implements Bank): Implements banking operations for the SBI bank.
HDFC (Implements Bank): Implements banking operations for the HDFC bank.
BankFactory: A factory class that uses the factory method to create objects of either SBI or HDFC banks based on user input.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher.
A Java IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code.
Basic understanding of Java programming.
