package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class RetirementAccount extends BankAccount{
    private double balance;

    public void run() {
        try {
            SavingsAccount savingsThread = new SavingsAccount();

            Thread actualThread = new Thread(savingsThread);
            actualThread.start();
            while (true) {
                Thread.sleep(120000);
                interestRate();
                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void interestRate() {
        try {
            while (true) {
                this.balance = (balance * 1.05);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
