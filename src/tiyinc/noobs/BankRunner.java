package tiyinc.noobs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Brice on 8/18/16.
 */
public class BankRunner {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Bank myBank = new Bank();
        BankRunner myRunner = new BankRunner();
        myRunner.startInterest(myRunner.startCustomerArrayList(myBank));

        boolean mainFlag = true;

        while (mainFlag) {
            System.out.println("Bienvenue à la " + myBank.getName() + "\n");
            System.out.println("0. Exit\n");
            System.out.println("1. Would you like to see the bank information?");
            System.out.println("2. Would you like to access your accounts?");

            int userChoice = Integer.valueOf(inputScanner.nextLine());
            if (userChoice == 1) {
                myBank.printInfo();
            } else if (userChoice == 2) {
                myRunner.mainMenu(myBank);
            } else if (userChoice == 0) {
                mainFlag = false;
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public void mainMenu(Bank myBank) {
        Scanner inputScanner = new Scanner(System.in);
        BankRunner myRunner = new BankRunner();
//        Customer myCustomer = new Customer();


        try {
            System.out.println("What is your name?");
            String userName = inputScanner.nextLine();

            myRunner.checkCustomerFile(myBank, userName);


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

    public void writeAccountFile(Bank myBank) {
        FileWriter testWriter = null;

        try {
            for (Customer customer : myBank.getCustomerArrayList()) {
            String custName = customer.getName();
                System.out.println(custName);
            File testFile = new File(custName + "-accounts.txt");
            testWriter = new FileWriter(testFile);

                for (BankAccount currAccount : customer.getListOfAccounts()) {
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
                testWriter.close();
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

    public void checkCustomerFile(Bank myBank, String userName) {
        Customer myCustomer = new Customer();
        try {
            File testFile = new File("Clients.txt");
                Scanner fileScanner = new Scanner(testFile);

                String scanString = fileScanner.nextLine();

                String[] parts = scanString.split(",");
                boolean exists = false;
                int arrayIndex = 0;

                for (String currentPart : parts) {
                    if (userName.equals(currentPart)) {
                        System.out.println("Welcome back, " + userName);
                        myBank.setArrayIndex(arrayIndex);
                        myBank.BankMenu(myBank);
                        exists = true;
                    }
                    arrayIndex++;
                }
                if (exists == false) {
                    writeCustomerFile(userName, parts);
                    System.out.println("Welcome new customer, " + userName);
                    myCustomer.setName(userName);
                    myBank.setArrayIndex(arrayIndex);
                    myBank.addCustomerArraylist(myCustomer);
                    myBank.BankMenu(myBank);
                }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void readAccountFile(Bank myBank, Customer customer) {
        try {
            File testFile = new File(customer.getName() + "-accounts.txt");
            Scanner fileScanner = new Scanner(testFile);
//            Customer myCustomer = new Customer();

            String bankName = null;
            String bankType = null;
            double acctBalance = 0.00;


            while (fileScanner.hasNext()) {
                String currLine = fileScanner.nextLine();
//                Double currDouble = fileScanner.nextDouble();
                if (currLine.startsWith("name")) {
                    bankName = currLine.split(":")[1];
                } else if (currLine.startsWith("balance")) {
                    acctBalance = Double.valueOf(currLine.split(":")[1]);
                } else if (currLine.startsWith("type")) {
                    bankType = currLine.split(":")[1];
                    if (bankType.equals("Checking")) {
                        CheckingAccount myAccount = new CheckingAccount();
                        myAccount.setBalance(acctBalance);
                        myAccount.setName(bankName);
//                        customer.addListOfAccounts(myAccount);

//                        writeAccountFile(customer);
//                        return myAccount;
                    } else if (bankType.equals("Savings")) {
                        SavingsAccount myAccount = new SavingsAccount(myBank);
                        myAccount.setBalance(acctBalance);
                        myAccount.setName(bankName);
//                        customer.addListOfAccounts(myAccount);
//                        writeAccountFile(customer);
//                        return myAccount;
                    } else if (bankType.equals("Retirement")) {
                        RetirementAccount myAccount = new RetirementAccount(myBank);
                        myAccount.setBalance(acctBalance);
                        myAccount.setName(bankName);
//                        customer.addListOfAccounts(myAccount);

//                        writeAccountFile(customer);
//                        return myAccount;
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Bank startCustomerArrayList(Bank myBank) {
        try {
            File testFile = new File("Clients.txt");
            if (testFile.exists()) {
                Scanner fileScanner = new Scanner(testFile);


                String scanString = fileScanner.nextLine();

                String[] parts = scanString.split(",");

                for (String currentPart : parts) {
                    Customer myCustomer = new Customer();
                    myCustomer.setName(currentPart);
                    readAccountFile(myBank, myCustomer);
                    myBank.addCustomerArraylist(myCustomer);
                    //At this point we have 3 accounts.//
                }
            } else {
                return myBank;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return myBank;
    }

    public void startInterest(Bank myBank) {
        try {
            ArrayList<Customer> customers = myBank.getCustomerArrayList();
            for (Customer customer : customers) {
                File testFile = new File(customer.getName() + "-accounts.txt");
                Scanner fileScanner = new Scanner(testFile);
//            Customer myCustomer = new Customer();

                String bankName = null;
                String bankType = null;
                double acctBalance = 0.00;


                while (fileScanner.hasNext()) {
                    String currLine = fileScanner.nextLine();
//                Double currDouble = fileScanner.nextDouble();
                    if (currLine.startsWith("name")) {
                        bankName = currLine.split(":")[1];
                    }
                    if (currLine.startsWith("balance")) {
                        acctBalance = Double.valueOf(currLine.split(":")[1]);
                    }
                    if (currLine.startsWith("type")) {
                        bankType = currLine.split(":")[1];
                        if (bankType.equals("Checking")) {
                            CheckingAccount myAccount = new CheckingAccount();
                            myAccount.setBalance(acctBalance);
                            myAccount.setName(bankName);
                            customer.addListOfAccounts(myAccount);

//                        writeAccountFile(customer);
//                        return myAccount;
                        } else if (bankType.equals("Savings")) {
                            SavingsAccount myAccount = new SavingsAccount(myBank);
                            myAccount.setBalance(acctBalance);
                            myAccount.setName(bankName);
                            customer.addListOfAccounts(myAccount);

//                        writeAccountFile(customer);
//                        return myAccount;
                        } else if (bankType.equals("Retirement")) {
                            RetirementAccount myAccount = new RetirementAccount(myBank);
                            myAccount.setBalance(acctBalance);
                            myAccount.setName(bankName);
                            customer.addListOfAccounts(myAccount);

//                        writeAccountFile(customer);
//                        return myAccount;
                        }
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
