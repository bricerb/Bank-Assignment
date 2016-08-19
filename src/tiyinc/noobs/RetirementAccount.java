package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class RetirementAccount extends BankAccount{
    private double balance;

    public void interestRate() {
        try {
            while (true) {
                Thread.sleep(120000);
                this.balance = (balance * 1.05);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
