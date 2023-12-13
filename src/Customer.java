public class Customer extends Thread {

    private final Bank bank;
    private final int customerId;

    public Customer(Bank bank, int customerId) {
        this.bank = bank;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { //sequence of trasactions
            int amount = (int) (Math.random() * 100) + 1; 
            if (Math.random() < 0.5) {
                bank.deposit(customerId, amount);
            } else {
                bank.withdraw(customerId, amount);
            }
            try {
                Thread.sleep((int) (Math.random() * 100)); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
