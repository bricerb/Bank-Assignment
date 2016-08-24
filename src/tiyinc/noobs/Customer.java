package tiyinc.noobs;

import java.util.ArrayList;

/**
 * Created by Brice on 8/18/16.
 */
public class Customer {
    private String name;
    private ArrayList<BankAccount> listOfAccounts = new ArrayList<BankAccount>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BankAccount> getListOfAccounts() {
//        System.out.println(listOfAccounts.size());
        return listOfAccounts;
    }

    public void addListOfAccounts(BankAccount account) {
        listOfAccounts.add(account);
    }

    public void printListOfAccounts(ArrayList<BankAccount> listofAccounts) {
        int index = 1;
        for (BankAccount account : listOfAccounts) {
//        for (int counter = 0; counter <  3; counter++) {
            System.out.println(index + ". " + account.getName() + ": " + account.getBalance());
            index ++;
        }
    }
}
