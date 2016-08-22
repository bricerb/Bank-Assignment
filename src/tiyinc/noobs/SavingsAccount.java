package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class SavingsAccount extends BankAccount implements Runnable{

    public void run() {
        try {
                SavingsAccount savingsThread = new SavingsAccount();

                Thread actualThread = new Thread(savingsThread);
                actualThread.start();
                while (true) {
                    Thread.sleep(10000);
                    interestRate();
                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void interestRate() {

        while(true) {
            try {
                double currBalance = getBalance();
                setBalance(currBalance * 1.1);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

}
