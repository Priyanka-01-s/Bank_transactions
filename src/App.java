import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("------------------BANK TRASACTION SYSTEM------------------");
        Bank bank = new Bank();

        System.out.println("Enter the number of customers :");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            Customer customer = new Customer(bank, i);
            customer.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display 
        for (int i = 1; i <= num; i++) {
            System.out.println("Final balance for account " + i + ": $" + bank.getBalance(i));
        }
        sc.close();
    }
}
