import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    public AccountTest() {
    }

    @Test
    void account_create() throws Exception {
        this.account = new Account(10000);
        Assertions.assertNotNull(this.account);
    }

    @Test
    void get_balance() throws Exception {
        this.account = new Account(10000);
        if (this.account.getBalance() != 10000) {
            Assertions.fail("Error");
        }

        this.account = new Account(1000);
        if (this.account.getBalance() != 1000) {
            Assertions.fail("Error");
        }

        this.account = new Account(0);
        if (this.account.getBalance() != 0) {
            Assertions.fail("Error");
        }

    }

    @Test
    void deposit() {
        this.account = new Account(10000);
        this.account.deposit(1000);
        Assertions.assertEquals(11000, this.account.getBalance());
    }

    @Test
    void withdraw() {
        this.account = new Account(10000);
        this.account.withdraw(1000);
        Assertions.assertEquals(9000, this.account.getBalance());
    }
}
