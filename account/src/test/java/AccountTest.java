import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    
    private Account account;

    public AccountTest() {
    }

    @Test
    void account_create() throws Exception {
        account = new Account(10000);
        Assertions.assertNotNull(account);
    }

    @Test
    void get_balance() throws Exception {
        account = new Account(10000);
        if (account.getBalance() != 10000) {
            Assertions.fail("Error");
        }

        account = new Account(1000);
        if (account.getBalance() != 1000) {
            Assertions.fail("Error");
        }

        account = new Account(0);
        if (account.getBalance() != 0) {
            Assertions.fail("Error");
        }

    }

    @Test
    void deposit() {
        account = new Account(10000);
        account.deposit(1000);
        Assertions.assertEquals(11000, account.getBalance());
    }

    @Test
    void withdraw() {
        account = new Account(10000);
        account.withdraw(1000);
        Assertions.assertEquals(9000, account.getBalance());
    }
}
