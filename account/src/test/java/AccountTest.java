import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account(10000);
    }

    @Test
    void 잔고조회() {
        account = new Account(-1);
        assertEquals(account.getBalance(), 10000);

        Account account2 = new Account(20000);
        assertEquals(account2.getBalance(), 20000);

        Account account3 = new Account(1000);
        assertEquals(account3.getBalance(), 1000);
    }

    @Test
    void 입금() {
        account = new Account(10000);
        account.deposit(1000);
        assertEquals(account.getBalance(), 11000);
    }

    @Test
    void 출금() {
        account = new Account(10000);
        account.withdraw(1000);
        assertEquals(account.getBalance(), 9000);
    }
}
