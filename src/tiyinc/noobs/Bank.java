package tiyinc.noobs;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Brice on 8/18/16.
 */
public class Bank {
    private String name = "Banque Nationale Française";
    private ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
    private int arrayIndex;
    static boolean threadFlag = true;

    public int getArrayIndex() {
        return arrayIndex;
    }

    public void setArrayIndex(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public void BankMenu(Bank myBank) {
        Scanner inputScanner = new Scanner(System.in);
        BankRunner myRunner = new BankRunner();
        Customer customer = myBank.customerArrayList.get(getArrayIndex());




        while (true) {
            System.out.println("What would you like to do " + customer.getName() + "?\n");
            System.out.println("0. Back to Bank Menu\n");
            System.out.println("1. Add a new account");
            System.out.println("2. Interact with an account");
            System.out.println("3. List account Information");
            int userChoice = Integer.valueOf(inputScanner.nextLine());

            if (userChoice == 1) {
                addBankAccount(customer);
            } else if (userChoice == 2) {
//                myRunner.readAccountFile(customer);
//                customer.printListOfAccounts(customer.getListOfAccounts());
                int index = 1;
                for (BankAccount currentAccount : customer.getListOfAccounts()) {
                    System.out.println(index + ". " + currentAccount.getName());
                    index++;
                }
                    System.out.println("\nSelect an Account");
                    userChoice = Integer.valueOf(inputScanner.nextLine());
                    BankAccount myAcct = customer.getListOfAccounts().get(userChoice - 1);
                    while (true) {
                        System.out.println("What would you like to do with your " + myAcct.getName() + " account?\n");
                        System.out.println("0. Return to Account Selection");
                        System.out.println("1. Withdraw");
                        System.out.println("2. Deposit");
                        System.out.println("3. Transfer to Another Account");
                        userChoice = Integer.valueOf(inputScanner.nextLine());
                        if (userChoice == 0) {
                            break;
                        } else if (userChoice == 1) {
                            System.out.println("How much would you like to withdraw from " + myAcct.getName() + "?");
                            double withdrawAmount = Double.valueOf(inputScanner.nextLine());
                            myAcct.withdraw(withdrawAmount);
                            break;
                        } else if (userChoice == 2) {
                            System.out.println("How much would you like to deposit? from " + myAcct.getName() + "?");
                            double depositAMount = Double.valueOf(inputScanner.next());
                            myAcct.deposit(depositAMount);
                            break;
                        } else if (userChoice == 3) {
                            index = 1;
                            System.out.println("Which Account will you be transfering to");
                            for (BankAccount transAccount : customer.getListOfAccounts()) {
                                System.out.println(index + ". " + transAccount.getName());
                                index++;
                            }
                                userChoice = Integer.valueOf(inputScanner.nextLine());

                                BankAccount myTransAcct = customer.getListOfAccounts().get(userChoice - 1);
                            if (myAcct == myTransAcct) {
                                System.out.println("You can transfer to the same account!");
                            } else {
                                System.out.println("How much will you be transfering from " + myAcct.getName() + " to " + myTransAcct.getName() + "?");
                                double transferAmount = Double.valueOf(inputScanner.nextLine());
                                myAcct.withdraw(transferAmount);
                                myTransAcct.deposit(transferAmount);
                            }
                        }
                    }
            } else if (userChoice == 3) {

                for (BankAccount listAccount : customer.getListOfAccounts()) {
                    System.out.println(listAccount.getName() + " : " + listAccount.getBalance());
                }
            } else if (userChoice == 0) {
                myBank.threadFlag = false;
                myRunner.writeAccountFile(myBank);
                break;
            } else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public double getTotalInDeposits() {
//        Bank myBank = new Bank();
//        Customer myCustomer = new Customer();
        double total = 0.0;
//        String balance = null;

        try {

            File clientFile = new File("Clients.txt");
            Scanner fileScanner = new Scanner(clientFile);

            String scanString = fileScanner.nextLine();

            String[] parts = scanString.split(",");


                for (String currentPart : parts) {
                    File accountFile = new File(currentPart + "-accounts.txt");
                    Scanner acctScanner = new Scanner (accountFile);
                    while(acctScanner.hasNext()) {
                        String currLine = acctScanner.nextLine();
                        if (currLine.startsWith("balance")) {
                            total += Double.valueOf(currLine.split(":")[1]);
                        }
                    }

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
            customer.addListOfAccounts(newAcct);
        } else if (userChoice == 2) {
            BankAccount newAcct = new SavingsAccount(this);
            newAcct.setName(acctName);
            System.out.println("How much will be your first Deposit?");
            double initDeposit = Double.valueOf(inputScanner.nextLine());
            newAcct.setBalance(initDeposit);
            customer.addListOfAccounts(newAcct);
        } else if (userChoice == 3) {
            BankAccount newAcct = new RetirementAccount(this);
            newAcct.setName(acctName);
            System.out.println("How much will be your first Deposit?");
            double initDeposit = Double.valueOf(inputScanner.nextLine());
            newAcct.setBalance(initDeposit);
            customer.addListOfAccounts(newAcct);
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

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    public void addCustomerArraylist(Customer customer) {
        customerArrayList.add(customer);
    }
}