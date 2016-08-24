package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class RetirementAccount extends BankAccount implements Runnable{
    Bank myBank;

    public RetirementAccount(Bank myBank) {
        this.myBank = myBank;

        Thread newThread = new Thread(this);
        newThread.start();
    }

    public void run() {
        try {
                while (myBank.threadFlag) {
                    Thread.sleep(120000);
                    interestRate();
                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void interestRate() {
        try {
            setBalance(getBalance() * 1.1);

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}