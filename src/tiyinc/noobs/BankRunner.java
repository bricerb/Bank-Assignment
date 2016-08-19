package tiyinc.noobs;

import java.util.Scanner;

/**
 * Created by Brice on 8/18/16.
 */
public class BankRunner {

    public static void main(String[] args) {
        Bank myBank = new Bank();
        System.out.println("Bienvenue à la " + myBank.getName() + "\n");
        while(true) {
            mainMenu();
        }

    }

    public static void mainMenu() {
        Scanner inputScanner = new Scanner(System.in);
        Bank myBank = new Bank();
        try {
            System.out.println("1. Are you a new customer?");
            System.out.println("2. Do you already have an account with us?");
            int userChoice = Integer.valueOf(inputScanner.nextLine());
            if (userChoice == 1) {
                myBank.addBankAccount();
            } else if (userChoice == 2) {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        if (userChoice == 1) {
//
//        } else if (userChoice == 2) {
//
//        }
    }
}
