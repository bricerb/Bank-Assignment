package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class SavingsAccount extends BankAccount implements Runnable{
    Bank myBank;

    public SavingsAccount(Bank myBank) {
        this.myBank = myBank;
        Thread newThread = new Thread(this);
        newThread.start();
    }

    public void run() {
        try {
                while (myBank.threadFlag) {
                    Thread.sleep(10000);
                    interestRate();
                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void interestRate() {
        try {
            setBalance(getBalance() * 1.05);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
