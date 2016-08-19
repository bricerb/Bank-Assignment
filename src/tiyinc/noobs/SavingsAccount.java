package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class SavingsAccount extends BankAccount {

    public void interestRate() {

        while(true) {
            try {
                Thread.sleep(10000);
                double currBalance = getBalance();
                setBalance(currBalance * 1.1);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

}
