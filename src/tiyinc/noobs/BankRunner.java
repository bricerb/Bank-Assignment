package tiyinc.noobs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brice on 8/18/16.
 */
public class BankRunner{

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Bank myBank = new Bank();

        while (true) {
            System.out.println("Bienvenue à la " + myBank.getName() + "\n");
            System.out.println("0. Exit\n");
            System.out.println("1. Would you like to see the bank information?");
            System.out.println("2. Would you like to access your accounts?");

            int userChoice = Integer.valueOf(inputScanner.nextLine());
            if (userChoice == 1) {
                myBank.printInfo();
            } else if (userChoice == 2) {
                mainMenu();
            } else if (userChoice == 0) {
                break;
            } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

    public static void mainMenu() {
        Scanner inputScanner = new Scanner(System.in);
        BankRunner myRunner = new BankRunner();
        Customer myCustomer = new Customer();


        try {
            System.out.println("What is your name?");
            String userName = inputScanner.nextLine();

            myRunner.checkCustomerFile(userName);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        if (userChoice == 1) {
//
//        } else if (userChoice == 2) {
//
//        }
    }

    public void writeCustomerFile(String clientName, String[] parts) {
        FileWriter testWriter = null;

        try {
            File testFile = new File("Clients.txt");
            testWriter = new FileWriter(testFile);
            for (String partsArray : parts) {
                testWriter.write(partsArray + ",");
            }
            testWriter.write(clientName + ",");

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (testWriter != null) {
                try {
                    testWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void writeAccountFile(Customer customer) {
        System.out.println("writeBankFile()");
        FileWriter testWriter = null;
        String custName = customer.getName();

        try {
            File testFile = new File(custName + "-accounts.txt");
            testWriter = new FileWriter(testFile);

            for (BankAccount currAccount : customer.listOfAccounts) {
                testWriter.write("name:" + currAccount.getName() + "\n");
                testWriter.write("balance:" + currAccount.getBalance() + "\n");
                if (currAccount instanceof CheckingAccount) {
                    testWriter.write("type:Checking\n");
                } else if (currAccount instanceof SavingsAccount) {
                    testWriter.write("type:Savings\n");
                } else if (currAccount instanceof RetirementAccount) {
                    testWriter.write("type:Retirement\n");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (testWriter != null) {
                try {
                    testWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void checkCustomerFile(String userName) {
        Bank myBank = new Bank();
        Customer myCustomer = new Customer();
        try {
            File testFile = new File("Clients.txt");
            Scanner fileScanner = new Scanner(testFile);

            String scanString = fileScanner.nextLine();

            String[] parts = scanString.split(",");
            boolean exists = false;

            for (String currentPart : parts) {
                if (userName.equals(currentPart)) {
                    myCustomer.setName(userName);
                    System.out.println("Welcome back, " + userName);
                    myBank.BankMenu(myCustomer);
                    exists = true;
                }
            }
            if (exists == false){
                writeCustomerFile(userName, parts);
                System.out.println("Welcome new customer, " + userName);
                myBank.BankMenu(myCustomer);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void readAccountFile(String customer) {
        try {
            File testFile = new File(customer + "-accounts.txt");
            Scanner fileScanner = new Scanner(testFile);
            Customer myCustomer = new Customer();

            String bankName = null;
            String bankBalance = null;
            String bankType = null;
            double acctBalance = 0.00;


            while (fileScanner.hasNext()) {
                String currLine = fileScanner.nextLine();
//                Double currDouble = fileScanner.nextDouble();
                if (currLine.startsWith("name")) {
                    bankName = currLine.split(":")[1];
                }
                if (currLine.startsWith("Balance")) {
                    bankBalance = currLine.split(":")[1];
                    acctBalance = Double.valueOf(bankBalance);
                }
                if (currLine.startsWith("type")) {
                    bankType = currLine.split(":")[1];
                    if (bankType.equals("Checking")) {
                        BankAccount myAccount = new CheckingAccount();
                        myAccount.setBalance(Double.valueOf(bankBalance));
                        myAccount.setName(bankName);
                        myCustomer.listOfAccounts.add(myAccount);
//                        return myAccount;
                    } else if (bankType.equals("Savings")) {
                        BankAccount myAccount = new SavingsAccount();
                        myAccount.setBalance(Double.valueOf(bankBalance));
                        myAccount.setName(bankName);
                        myCustomer.listOfAccounts.add(myAccount);
//                        return myAccount;
                    } else if (bankType.equals("Retirement")) {
                        BankAccount myAccount = new RetirementAccount();
                        myAccount.setBalance(Double.valueOf(bankBalance));
                        myAccount.setName(bankName);
                        myCustomer.listOfAccounts.add(myAccount);
//                        return myAccount;
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
