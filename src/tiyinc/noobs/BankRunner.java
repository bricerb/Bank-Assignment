package tiyinc.noobs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Brice on 8/18/16.
 */
public class BankRunner {

    public static void main(String[] args) {
        Bank myBank = new Bank();
        System.out.println("Bienvenue à la " + myBank.getName() + "\n");
            mainMenu();
    }

    public static void mainMenu() {
        Scanner inputScanner = new Scanner(System.in);
        BankRunner myRunner = new BankRunner();

        try {
            System.out.println("What is your name?");
            String userName = inputScanner.nextLine();

            myRunner.readCustomerFile(userName);

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

    public void writeAccountFile(BankAccount myAcct) {
        System.out.println("writeBankFile()");
        FileWriter testWriter = null;

        try {
            File testFile = new File("-accounts.txt");
            testWriter = new FileWriter(testFile);

            testWriter.write("name:" + myAcct.getName() + "\n");
            testWriter.write("balance:" + myAcct.getBalance() + "\n");
            if (myAcct instanceof CheckingAccount) {
                testWriter.write("type:Checking\n");
            } else if (myAcct instanceof SavingsAccount) {
                testWriter.write("type:Savings\n");
            } else if (myAcct instanceof RetirementAccount) {
                testWriter.write("type:Retirement\n");
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

    public void readCustomerFile(String userName) {
        Bank myBank = new Bank();
        try {
            File testFile = new File("Clients.txt");
            Scanner fileScanner = new Scanner(testFile);

            String scanString = fileScanner.nextLine();

            String[] parts = scanString.split(",");
            boolean exists = false;

            for (String currentPart : parts) {
                if (userName.equals(currentPart)) {
                    myBank.BankMenu(userName);
                    exists = true;
                }
            }
            if (exists == false){
                writeCustomerFile(userName, parts);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void readAccountFile() {
        try {
            File testFile = new File(".txt");
            Scanner fileScanner = new Scanner(testFile);

            String scanString = fileScanner.nextLine();

            String[] parts = scanString.split(",");

//            System.out.println(parts[1]);
            System.out.println(parts[0]);
            int index = 1;

            for (String currentPart : parts) {
                System.out.print(index + ". ");
                System.out.println(currentPart);
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
