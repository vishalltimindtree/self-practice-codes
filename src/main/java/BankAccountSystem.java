// BankAccountSystem.java

package main.java;

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 5000.00);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(2000.00);
        System.out.println("Balance after deposit: " + account.getBalance());

        account.withdraw(1000.00);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}