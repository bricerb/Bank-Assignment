package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public abstract class BankAccount {
    private double balance;
    private String name;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit() {

    }
    public void withdraw() {

    }

    public void transfer() {

    }

    public abstract void interestRate() {

    }
}