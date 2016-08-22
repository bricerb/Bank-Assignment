package tiyinc.noobs;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Brice on 8/18/16.
 */
public class Bank implements Runnable{
    private String name = "Banque Nationale Française";
    ArrayList<Customer> customerArrayList;

    public Bank() {

    }

    public void run() {

    }

    public void BankMenu(Customer customer) {
        Scanner inputScanner = new Scanner(System.in);
        BankRunner myRunner = new BankRunner();


        while (true) {
            System.out.println("What would you like to do?\n");
            System.out.println("0. Back to Bank Menu\n");
            System.out.println("1. Add a new account");
            System.out.println("2. Interact with an account");
            int userChoice = Integer.valueOf(inputScanner.nextLine());

            if (userChoice == 1) {
                addBankAccount(customer);
            } else if (userChoice == 2) {
                myRunner.readAccountFile(customer.getName());
            } else if (userChoice == 0) {
                break;
            } else {
                System.out.println("Invalid Input. Please try again.");

            }
        }
    }

    public double getTotalInDeposits() {
        Bank myBank = new Bank();
        Customer myCustomer = new Customer();
        double total = 0.0;

        try {

            File clientFile = new File("Clients.txt");
            Scanner fileScanner = new Scanner(clientFile);

            String scanString = fileScanner.nextLine();

            String[] parts = scanString.split(",");


                for (String currentPart : parts) {
                    File accountFile = new File(currentPart + "-accounts.txt");

                }


            } catch (Exception exception) {
                exception.printStackTrace();
            }
        return total;
    }

    public void printInfo() {

        System.out.println("===================================================================");
        System.out.println("Bank Name: " + name);
        System.out.println("Total money in bank: " + getTotalInDeposits());
        System.out.println("Account Holders: ");
        printCustomerList();
        System.out.println("===================================================================");


    }

    public String getName() {
        return name;
    }

    public void addBankAccount(Customer customer) {
        BankRunner myRunner = new BankRunner();
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
            myRunner.writeAccountFile(customer);
        } else if (userChoice == 2) {
            BankAccount newAcct = new SavingsAccount();
            newAcct.setName(acctName);
            System.out.println("How much will be your first Deposit?");
            double initDeposit = Double.valueOf(inputScanner.nextLine());
            newAcct.setBalance(initDeposit);
            myRunner.writeAccountFile(customer);
        } else if (userChoice == 3) {
            BankAccount newAcct = new RetirementAccount();
            newAcct.setName(acctName);
            System.out.println("How much will be your first Deposit?");
            double initDeposit = Double.valueOf(inputScanner.nextLine());
            newAcct.setBalance(initDeposit);
            myRunner.writeAccountFile(customer);
        }
    }

    public void printCustomerList() {
        try {
            File testFile = new File("Clients.txt");
            Scanner fileScanner = new Scanner(testFile);

            String scanString = fileScanner.nextLine();

            String[] parts = scanString.split(",");

            int index = 0;

            for (String currentPart : parts) {
                    System.out.print((index + 1) + ". ");
                System.out.println(currentPart);
                index++;
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void generateCustomerAccounts() {
        try {
            File testFile = new File("Clients.txt");
            Scanner fileScanner = new Scanner(testFile);
            Customer myCustomer = new Customer();
            Bank myBank = new Bank();

            String scanString = fileScanner.nextLine();

            String[] parts = scanString.split(",");

            int index = 0;

            for (String currentPart : parts) {
                myCustomer.setName(currentPart);


                myBank.customerArrayList.add(myCustomer);


                index++;
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}