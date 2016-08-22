package tiyinc.noobs;

import java.util.ArrayList;

/**
 * Created by Brice on 8/18/16.
 */
public class Customer {
    private String name;
    ArrayList<BankAccount> listOfAccounts = new ArrayList<BankAccount>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
