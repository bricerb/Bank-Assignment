package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class RetirementAccount extends BankAccount implements Runnable{
    private boolean threadFlag = true;

    public void run() {
        try {
                while (threadFlag) {
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

    public void setThreadFlag(boolean threadFlag) {
        this.threadFlag = threadFlag;
    }
}
