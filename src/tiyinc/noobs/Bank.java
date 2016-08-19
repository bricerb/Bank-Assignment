package tiyinc.noobs;

/**
 * Created by Brice on 8/18/16.
 */
public class Bank {
        private String name = "Banque Nationale Française";

        public Bank() {

        }

        public double getTotalInDeposits() {
            double total = 0.0;
//            for () {
//
//            }
            return total;
        }

        public void printInfo() {

//             this is how I would loop through all the names of every account
//        for () {
            System.out.println("Current Bank Account Name: ");
//        }

            System.out.println("###############################");
            System.out.println("Bank Name: " + name);
            System.out.println("Total in deposits: " + getTotalInDeposits());
            System.out.println("###############################");
        /*
        for (BankAccount currAcct : bankAccountsByName.values()) {
            System.out.println("******** Account Info *************");
            currAcct.printInfo();
            System.out.println("***********************************");
        }
        */
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addBankAccount(BankAccount acct) {

        }

//        public {
//            return bankAccounts;
//        }
    }