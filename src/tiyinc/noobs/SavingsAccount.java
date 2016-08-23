package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class SavingsAccount extends BankAccount implements Runnable{
    private boolean threadFlag = true;

    public void run() {
        try {
                while (threadFlag) {
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

    public void setThreadFlag(boolean threadFlag) {
        this.threadFlag = threadFlag;
    }
}
