import java.util.HashMap;

public class Bank {
    private final HashMap<Integer, Integer> accounts = new HashMap<>();

    public synchronized void deposit(int acc_no, int amt) {
        int currentBalance = accounts.getOrDefault(acc_no, 0);
        int newBalance = currentBalance + amt;
        accounts.put(acc_no, newBalance);
        System.out.println("Deposited $" + amt + " into account " + acc_no + ". New balance: $" + newBalance);
    }

    public synchronized void withdraw(int acc_no, int amt) {
        int currentBalance = accounts.getOrDefault(acc_no, 0);
        if (currentBalance >= amt) {
            int newBalance = currentBalance - amt;
            accounts.put(acc_no, newBalance);
            System.out.println("Withdrawn $" + amt + " from account " + acc_no + ". New balance: $" + newBalance);
        } else {
            System.out.println("Insufficient funds for withdrawal from account " + acc_no);
        }
    }

    public synchronized int getBalance(int acc_no) {
        return accounts.getOrDefault(acc_no, 0);
    }
}