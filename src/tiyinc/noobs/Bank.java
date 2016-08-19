package tiyinc.noobs;

import java.util.Scanner;

/**
 * Created by Brice on 8/18/16.
 */
public class Bank {
    private String name = "Banque Nationale Française";

    public Bank() {

    }

    public double getTotalInDeposits() {
        double total = 0.0;
//            for () {
//
//            }
        return total;
    }

    public void printInfo() {

        System.out.println("================================");
        System.out.println("Bank Name: " + name);
        System.out.println("Total in deposits: " + getTotalInDeposits());
        System.out.println("================================");

    }

    public String getName() {
        return name;
    }

    public void addBankAccount(BankAccount acct) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("What will you name this account?");
        String acctName = inputScanner.nextLine();
        System.out.println("\nWhat kind of account would you like to begin with?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("3. Retirement");
        int userChoice = Integer.valueOf(inputScanner.nextLine());
        if (userChoice == 1) {
            BankAccount newAcct = new CheckingAccount();
            newAcct.setName(acctName);
            System.out.println("How much will be your first Deposit?");
            double initDeposit = Double.valueOf(inputScanner.nextLine());
            newAcct.setBalance(initDeposit);
        } else if (userChoice == 2) {
            BankAccount newAcct = new SavingsAccount();
            newAcct.setName(acctName);
            System.out.println("How much will be your first Deposit?");
            double initDeposit = Double.valueOf(inputScanner.nextLine());
            newAcct.setBalance(initDeposit);
        } else if (userChoice == 3) {
            BankAccount newAcct = new RetirementAccount();
            newAcct.setName(acctName);
            System.out.println("How much will be your first Deposit?");
            double initDeposit = Double.valueOf(inputScanner.nextLine());
            newAcct.setBalance(initDeposit);
        }
    }
}