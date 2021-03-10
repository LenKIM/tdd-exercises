
public class Account {
    private int balance;

    public Account(int amount) {
        this.balance = amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        this.balance -= money;
    }
}
